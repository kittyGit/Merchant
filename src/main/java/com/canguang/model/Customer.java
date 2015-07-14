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
	@JoinColumn(name = "merchantId", nullable = false)
	private Merchant merchant;

	@Column(nullable = false)
	private String customerName;

	@Column(nullable = false)
	private String customerPwd;

	@Column(nullable = false)
	private String confirmPwd;

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
	private Integer price;

	@Column(nullable = false)
	private CouponStatus couponStatus;

	@Column(nullable = false)
	private boolean isValidated;

	@Column(nullable = false)
	private Date creationTime;

	@Column(nullable = false)
	private String creator;

	@Column(nullable = false)
	private Date LastAlterTime;

	@Column(nullable = false)
	private String mender;

	
	public Customer(){
		
	}
    public Customer(String customerName,String customerPwd,String confirmPwd,
    		String phoneNumber,Date registerTime,String registerAddress,
    		Integer level,Integer coupon ,Integer price,
    		CouponStatus couponStatus,boolean isValidated,Date creationTime,
    		String creator,Date LastAlterTime,String mender){
    	this.customerName=customerName;
    	this.customerPwd=customerPwd;
    	this.confirmPwd=confirmPwd;
    	this.phoneNumber=phoneNumber;
    	this.registerTime=registerTime;
    	this.registerAddress=registerAddress;
    	this.level=level;
    	this.coupon=coupon;
    	this.price=price;
    	this.couponStatus=couponStatus;
    	this.isValidated=isValidated;
    	this.creationTime=creationTime;
    	this.creator=creator;
    	this.LastAlterTime=LastAlterTime;
    	this.mender=mender;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

    
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
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

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public CouponStatus getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(CouponStatus couponStatus) {
		this.couponStatus = couponStatus;
	}

}
