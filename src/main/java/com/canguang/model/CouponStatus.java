package com.canguang.model;

/**
 * 优惠券的使用状态
 * 
 * @author Administrator
 *
 */
public enum CouponStatus {

	USED(1), UNUSED(2);

	private int _nCode;

	private CouponStatus(int _nCode) {
		this._nCode=_nCode;
	}

	@Override

	public String toString() {

		return String.valueOf(this._nCode);

	}

	public int get_nCode() {
		return _nCode;
	}

	public void set_nCode(int _nCode) {
		this._nCode = _nCode;
	}

}
