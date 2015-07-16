package com.canguang.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *  商家管理员
 * @author Administrator
 *
 */

@Entity
@Table(name = "Admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	
	@OneToOne
<<<<<<< HEAD
	@JoinColumn(name="merchantId", unique=true, nullable=false)
=======
	@JoinColumn(name="merchantId", unique=true, nullable=true)
>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
	private Merchant merchant;

	@Column(nullable = false)
	private String adminName;

	@Column(nullable = false)
	private String adminPwd;

	@Column(nullable=false)
	private Date creationTime;
	
	@Column(nullable=false)
<<<<<<< HEAD
	private String creator;
	
	@Column(nullable=false)
	private Date LastAlterTime;
	
	@Column(nullable=false)
	private String mender;
	
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
	
=======
	private boolean isSuperAdmin;
	
	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public boolean isSuperAdmin() {
		return isSuperAdmin;
	}

	public void setSuperAdmin(boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

>>>>>>> ea52b9487616970665c519dbd57c388a2171883b
	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
}
