package com.canguang.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 客戶信息
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "Customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@ManyToOne 
	@JoinColumn(name="merchantId", nullable=false)
	private Merchant merchant;
	

	@Column(nullable = false)
	private String customerName;

	@Column(nullable = false)
	private String customerPwd;

	@Column(nullable = false)
	private String phoneNumber;

	@Column(nullable = false)
	private Date registerTime;

	@Column(nullable = false)
	private String registerAddress;

	@Column(nullable = false)
	private Integer level;

	@Column(nullable = true)
	private Integer coupon;

	@Column(nullable = true)
	private String price;

	@Column(nullable = false)
	private CouponStatus couponStatus;

	@Column(nullable = false)
	private boolean isValidated;
	
	public Customer() {}
	
	public Customer(String customerName, String customerPwd, String phoneNumber, Date registerTime,
			String registerAddress, Integer level, Integer coupon, String price, CouponStatus couponStatus,
			boolean isValidated) {
		this.customerName = customerName;
		this.customerPwd = customerPwd;
		this.phoneNumber = phoneNumber;
		this.registerTime = registerTime;
		this.registerAddress = registerAddress;
		this.level = level;
		this.coupon = coupon;
		this.price = price;
		this.couponStatus = couponStatus;
		this.isValidated = isValidated;
	}

	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPwd() {
		return customerPwd;
	}

	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getCoupon() {
		return coupon;
	}

	public void setCoupon(Integer coupon) {
		this.coupon = coupon;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public CouponStatus getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(CouponStatus couponStatus) {
		this.couponStatus = couponStatus;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
}
