package com.canguang.message;

/**
 * 短信配置类
 * 
 * @author Administrator
 *
 */
public class SendMessageConfig {

	public static final String TYPE_MD5 = "md5";

	/**
	 * 短信发送的url地址
	 */
	private String sendMessageUrl;
	/**
	 * 获取时间戳的url地址
	 */
	private String getTimestampUrl;

	/**
	 * 短信应用id
	 */
	private String appId;
	/**
	 * 应用密钥
	 */
	private String appKey;

	/**
	 * 短信项目id
	 */
	private String projectId;

	/**
	 * 数字签名方式
	 */
	private String signType = TYPE_MD5;

	public String getSendMessageUrl() {
		return sendMessageUrl;
	}

	public void setSendMessageUrl(String sendMessageUrl) {
		this.sendMessageUrl = sendMessageUrl;
	}

	public String getGetTimestampUrl() {
		return getTimestampUrl;
	}

	public void setGetTimestampUrl(String getTimestampUrl) {
		this.getTimestampUrl = getTimestampUrl;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getSignType() {
		return signType;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}
