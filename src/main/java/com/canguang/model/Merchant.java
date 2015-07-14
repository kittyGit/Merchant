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
	private String mAddress;

	@Column(nullable = false)
	private boolean isCoupon;

	@Column(nullable = true)
	private Integer price;

	@Column(nullable = false)
	private Integer phoneNumber;

	@Column(nullable = false)
	private Date creationTime;

	@Column(nullable = false)
	private String creator;

	@Column(nullable = false)
	private Date LastAlterTime;

	@Column(nullable = false)
	private String mender;

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

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public boolean isCoupon() {
		return isCoupon;
	}

	public void setCoupon(boolean isCoupon) {
		this.isCoupon = isCoupon;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Date getLastAlterTime() {
		return LastAlterTime;
	}

	public void setLastAlterTime(Date lastAlterTime) {
		LastAlterTime = lastAlterTime;
	}

	public String getMender() {
		return mender;
	}

	public void setMender(String mender) {
		this.mender = mender;
	}
}
