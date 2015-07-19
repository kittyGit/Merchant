package com.canguang.message;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canguang.message.dto.Result;
import com.canguang.message.dto.VarsDto;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 短信发送器
 * 
 * @author Administrator
 *
 */
public class MessageSender implements IMessageSender {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MessageSender.class);

	/**
	 * 参数名：短信应用id
	 */
	private static final String APPID = "appid";

	/**
	 * 参数名：时间戳，每次发送之前从服务器获取
	 */
	private static final String TIMESTAMP = "timestamp";
	/**
	 * 参数名：授权模式（ md5 or sha1 or normal ）
	 */
	private static final String SIGN_TYPE = "sign_type";
	/**
	 * 参数名：数字签名
	 */
	private static final String SIGNATURE = "signature";

	/**
	 * 参数名：收短信人手机号码
	 */
	private static final String TO = "to";
	/**
	 * 参数名：短信模板中的变量
	 */
	private static final String VARS = "vars";
	/**
	 * 参数名：项目标记（id）
	 */
	private static final String PROJECT = "project";

	private SendMessageConfig config;

	private ObjectMapper objectMapper;

	private CloseableHttpClient closeableHttpClient;

	public void init() {
		closeableHttpClient = HttpClientBuilder.create().build();
	}

	public void close() {
		try {
			closeableHttpClient.close();
		} catch (IOException e) {
		}
	}

	public SendMessageConfig getConfig() {
		return config;
	}

	public void setConfig(SendMessageConfig config) {
		this.config = config;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	/**
	 * 获取时间戳
	 * 
	 * @return
	 */
	private String getTimestamp() {
		HttpGet httpGet = new HttpGet(config.getGetTimestampUrl());
		try {
			HttpResponse response = closeableHttpClient.execute(httpGet);
			HttpEntity httpEntity = response.getEntity();

			String jsonStr = EntityUtils.toString(httpEntity,
					StandardCharsets.UTF_8);

			if (jsonStr != null) {
				return objectMapper.readTree(jsonStr).path(TIMESTAMP).asText();
			}
		} catch (Exception e) {
			LOGGER.error("获取发短信时间戳发生异常", e);
			throw new RuntimeException(e);
		}

		return null;
	}

	/**
	 * 创建签名
	 * 
	 * @param sortedDataMap
	 * @return
	 */
	private String buildSignature(Map<String, String> sortedDataMap) {
		String app = config.getAppId();
		String appKey = config.getAppKey();

		StringJoiner joiner = new StringJoiner("&");
		for (Entry<String, String> entry : sortedDataMap.entrySet()) {
			StringJoiner usbJoiner = new StringJoiner("=");
			joiner.add(usbJoiner.add(entry.getKey()).add(entry.getValue())
					.toString());
		}

		String jointData = app + appKey + joiner.toString() + app + appKey;

		LOGGER.debug(jointData);

		return DigestUtils.md5Hex(jointData);
	}

	private HttpEntity build(String to, VarsDto varsDto) throws Exception {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();

		Map<String, String> sortedDataMap = new TreeMap<>();

		sortedDataMap.put(APPID, config.getAppId());
		sortedDataMap.put(TIMESTAMP, getTimestamp());
		sortedDataMap.put(SIGN_TYPE, config.getSignType());

		sortedDataMap.put(PROJECT, config.getProjectId());
		sortedDataMap.put(TO, to);
		sortedDataMap.put(VARS, objectMapper.writeValueAsString(varsDto));

		ContentType contentType = ContentType.create(
				ContentType.TEXT_PLAIN.getMimeType(), StandardCharsets.UTF_8);
		for (Entry<String, String> entry : sortedDataMap.entrySet()) {
			builder.addTextBody(entry.getKey(), entry.getValue(), contentType);
		}

		String signature = buildSignature(sortedDataMap);
		builder.addTextBody(SIGNATURE, signature, contentType);

		return builder.build();
	}

	@Override
	public Result send(String to, VarsDto varDto) {

		LOGGER.info("开始发送短信");

		Result result = null;
		try {
			HttpPost httpPost = new HttpPost(config.getSendMessageUrl());
			httpPost.addHeader("charset", StandardCharsets.UTF_8.name());

			httpPost.setEntity(build(to, varDto));
			HttpResponse response = closeableHttpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				String jsonStr = EntityUtils.toString(httpEntity,
						StandardCharsets.UTF_8.name());
				result = objectMapper.readValue(jsonStr, Result.class);
			}
		} catch (Exception e) {

			LOGGER.error("发送短信发生异常", e);

			result = new Result();
			result.setStatus(Result.Status.ERROR);
		}

		LOGGER.info("发送短信结束");

		return result;
	}
}
