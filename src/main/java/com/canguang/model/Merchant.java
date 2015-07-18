package com.canguang.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private boolean hasCoupon;

	@Column(nullable = false)
	private String phoneNumber;

	@Column(nullable = true)
	private String price;

	@Column(nullable = false)
	private Date creationTime;
	
	@OneToMany(mappedBy="merchant")
	private List<Store> stores;
	
	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public boolean isHasCoupon() {
		return hasCoupon;
	}

	public void setHasCoupon(boolean hasCoupon) {
		this.hasCoupon = hasCoupon;
	}
}
