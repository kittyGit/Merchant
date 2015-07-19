package com.canguang.message.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public class Result {

	private Status status;
	private String code;
	private String msg;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Result [status=" + status + ", code=" + code + ", message="
				+ msg + "]";
	}

	public enum Status {
		ERROR("error"), SUCCESS("success");

		private String code;

		private Status(String code) {
			this.code = code;
		}

		@JsonValue
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		@Override
		public String toString() {
			return code;
		}
	}
}
