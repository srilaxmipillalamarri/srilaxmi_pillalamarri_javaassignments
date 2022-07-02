package com.zensar.ide.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
//@NamedQueries(value = {  @NamedQuery(name = "Coupon.test", query = "from Coupon c where c.couponCode=?1"),
//@NamedQuery(name = "Coupon.test1", query = "from Coupon c where c.couponCode=?1 And c.exDate=?2")})

//@NamedNativeQueries(value = { @NamedNativeQuery(name = "Coupon.test", query = "select * from coupon c where c.coupon_code=?1",resultClass = Coupon.class),
//@NamedNativeQuery(name = "Coupon.test1", query = "select * from coupon c where c.coupon_code=?1 and c.ex_date=?2",resultClass = Coupon.class)})


public class Coupon {
	@Id
	private int couponId;
	private String couponCode;
	private int couponCost;
	private String expDate;

	public Coupon() {
		super();
	}

	private Coupon(int couponId, String couponCode, int couponCost,String expDate) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.couponCost = couponCost;
		this.expDate = expDate;
		
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getCouponCost() {
		return couponCost;
	}

	public void setCouponCost(int couponCost) {
		this.couponCost = couponCost;
	}
	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", couponCost=" + couponCost + ",expDate=" + expDate+"]";
	}
}