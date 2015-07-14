package com.canguang.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商家信息
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "Merchants")
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer merchantId;

	@Column(nullable = false, unique = true)
	private String code;

	@Column(nullable = false)
	private String merchantName;

	@Column(nullable = false)
	private String merchantAddress;

	@Column(nullable = false)
	private boolean isCoupon;

	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = true)
	private String price;

	@Column(nullable = false)
	private Date creationTime;

	@Column(nullable = false)
	private String creator;

	@Column(nullable = true)
	private Date lastAlterTime;

	@Column(nullable = true)
	private String merchantMender;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public boolean isCoupon() {
		return isCoupon;
	}

	public void setCoupon(boolean isCoupon) {
		this.isCoupon = isCoupon;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getLastAlterTime() {
		return lastAlterTime;
	}

	public void setLastAlterTime(Date lastAlterTime) {
		this.lastAlterTime = lastAlterTime;
	}

	public String getMerchantMender() {
		return merchantMender;
	}

	public void setMerchantMender(String merchantMender) {
		this.merchantMender = merchantMender;
	}

}
