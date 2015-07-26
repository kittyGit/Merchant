package com.canguang.model;

/**
 * 优惠券的使用状态
 * 
 * @author Administrator
 *
 */
public enum CouponStatus {

	USED("已使用"), UNUSED("未使用");

	private String description;

	private CouponStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
