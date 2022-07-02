package com.zensar.ide.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.zensar.ide.dto.CouponDto;
import com.zensar.ide.entity.Coupon;

public interface CouponService {
	public CouponDto getCoupon(int CouponId);

	//public List<CouponDto> getCoupons();
	public List<CouponDto> getCoupons(int pageNumber,int pageSize,String sortBy,Direction dir);
	//public List<CouponDto> getCoupons(int pageNumber,int pageSize);

	public CouponDto insertCoupon(CouponDto couponDto);

	public void updateCoupon(int couponId, CouponDto couponDto);

	public void deleteCoupon(int couponId);

	public List<CouponDto> getByCouponCode(String couponCode);

	public List<CouponDto> getByCouponCodeOrCouponCost(String couponCode, int cost);

	public List<CouponDto> getByCouponCodeAndExpDate(String couponCode, String expDate);

	public List<CouponDto> getByCouponCodeOrderByCouponCost(String couponCode);

}