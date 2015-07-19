package com.canguang.message.dto;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConversionTest {

	private static ObjectMapper objectMapper;

	@BeforeClass
	public static void beforeClass() {
		objectMapper = new ObjectMapper();
	}

	@Test
	public void testVarsDtoToJson() throws Exception {
		VarsDto varsDto = new VarsDto();
		varsDto.setUsername("hello");
		varsDto.setvCode("world");

		String jsonStr = objectMapper.writeValueAsString(varsDto);

		Assert.assertThat(jsonStr,
				IsEqual.equalTo("{\"username\":\"hello\",\"vCode\":\"world\"}"));
	}

	@Test
	public void testJsonToResultSuccess() throws Exception {
		String json = "{\"status\":\"success\"}";
		Result result = objectMapper.readValue(json, Result.class);
		Assert.assertThat(result.getStatus(),
				IsEqual.equalTo(Result.Status.SUCCESS));
		Assert.assertThat(result.getCode(), IsNull.nullValue());
		Assert.assertThat(result.getMsg(), IsNull.nullValue());
	}

	@Test
	public void testJsonToResultError() throws Exception {
		String json = "{\"status\":\"error\",\"code\":\"101\",\"msg\":\"error message\"}";

		Result result = objectMapper.readValue(json, Result.class);
		Assert.assertThat(result.getStatus(),
				IsEqual.equalTo(Result.Status.ERROR));
		Assert.assertThat(result.getCode(), IsEqual.equalTo("101"));
		Assert.assertThat(result.getMsg(), IsEqual.equalTo("error message"));
	}
}
