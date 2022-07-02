package com.zensar.ide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.ide.dto.CouponDto;
import com.zensar.ide.entity.Coupon;
import com.zensar.ide.service.CouponService;


@RestController
/*@RequestMapping(value = "/coupon-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })*/
public class CouponController {
	@Autowired
	private CouponService couponService;
	
	/*
	 * @ExceptionHandler(value = CouponAlreadyExistsException.class)
	 * 
	 * @ResponseStatus(HttpStatus.CONFLICT) public ErrorResponse
	 * handleCouponAlreadyExistsException(CouponAlreadyExistsException ex) {
	 * return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage()); }
	 */
	  
	/*
	 * @ExceptionHandler(value = NoSuchCouponExistsException.class)
	 * 
	 * @ResponseStatus(HttpStatus.NOT_FOUND) public ErrorResponse
	 * handleNoSuchCouponExistsException(NoSuchCouponExistsException ex) { return
	 * new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()); }
	 */

//	@GetMapping(value = "/coupon/{couponId}",produces = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE })
	@GetMapping(value = "/coupon/{couponId}")
	// public CouponDto getCoupon(@PathVariable("couponId") int couponId) {
	public ResponseEntity<CouponDto> getCoupon(@PathVariable("couponId") int couponId) {
		// return couponService.getCoupon(CouponId);
		return new ResponseEntity<CouponDto>(couponService.getCoupon(couponId), HttpStatus.OK);
	}

//	@GetMapping(value = "/coupons",produces = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE })
	@GetMapping(value = "/coupons")
	// public List<CouponDto> getCoupons() {
	//public ResponseEntity<List<CouponDto>> getCoupons() {
	// return couponService.getCoupons();
	public ResponseEntity<List<CouponDto>> getCoupons( @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
	@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,@RequestParam(value="sortBy",
	required=false,defaultValue="couponCode")String sortBy,@RequestParam(value="dir",required=false,defaultValue="DESC")Direction dir){
		
		return new ResponseEntity<List<CouponDto>>(couponService.getCoupons(pageNumber,pageSize,sortBy,dir), HttpStatus.OK);
	}

//	@PostMapping(value = "/coupons",consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PostMapping(value = "/coupons")
	// public CouponDto insertCoupon(@RequestBody CouponDto couponDto) {
	public ResponseEntity<CouponDto> insertCoupon(@RequestBody CouponDto couponDto) {
		// return couponService.insertCoupon(couponDto);
		return new ResponseEntity<CouponDto>(couponService.insertCoupon(couponDto), HttpStatus.CREATED);
	}

//	@PutMapping(value = "coupons/{couponId}",consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE })
	@PutMapping(value = "coupons/{couponId}")
	// public void updateCoupon(@PathVariable("couponId") int couponId, @RequestBody
	// CouponDto couponDto) {
	public ResponseEntity<String> updateCoupon(@PathVariable("couponId") int couponId,
			@RequestBody CouponDto couponDto) {
		couponService.updateCoupon(couponId, couponDto);
		return new ResponseEntity<String>("Coupon updated Succesfully", HttpStatus.OK);

	}

	@DeleteMapping(value="coupons/{couponId}")
	// public void deleteCoupon(@PathVariable("couponId") int couponId) {
	public ResponseEntity<String> deleteCoupon(@PathVariable("couponId") int couponId) {
		couponService.deleteCoupon(couponId);
		return new ResponseEntity<String>("Coupon deleted Succesfully", HttpStatus.OK);
	}

	@GetMapping(value="coupons/code/{couponCode}")
	public ResponseEntity<List<CouponDto>> getByCouponCode(@PathVariable("couponCode") String couponCode) {
		return new ResponseEntity<List<CouponDto>>(couponService.getByCouponCode(couponCode), HttpStatus.OK);
	}

	@GetMapping(value="coupons/{couponCode}/{couponCost}")
	public ResponseEntity<List<CouponDto>> getByCouponCodeOrCouponCost(@PathVariable("couponCode") String couponCode,
			@PathVariable("couponCost") int couponCost) {
		return new ResponseEntity<List<CouponDto>>(couponService.getByCouponCodeOrCouponCost(couponCode, couponCost),
				HttpStatus.OK);
	}

	@GetMapping(value="coupons/{couponCode}/{expDate}")
	public ResponseEntity<List<CouponDto>> getByCouponCodeAndExpDate(@PathVariable("couponCode") String couponCode,
			@PathVariable("expDate") String expDate) {
		return new ResponseEntity<List<CouponDto>>(couponService.getByCouponCodeAndExpDate(couponCode, expDate),
				HttpStatus.OK);
	}

	@GetMapping(value="coupons/order/{couponCode}")
	public ResponseEntity<List<CouponDto>> getByCouponCodeOrderByCouponCost(
			@PathVariable("couponCode") String couponCode) {
		return new ResponseEntity<List<CouponDto>>(couponService.getByCouponCodeOrderByCouponCost(couponCode),
				HttpStatus.OK);
	}
}
