package com.zensar.ide.endpoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Endpoint(id = "coupon-details")
public class CustomEndPoint {
	private Map<String, Integer> couponDetails = new HashMap<>();

	@PostConstruct
	public void init() {
		couponDetails.put("CouponsPrinted",500);
		couponDetails.put("CouponsRejected",50);
	}

	@ReadOperation
	public Map<String, Integer> getAllCourses() {
		return couponDetails;

	}

	@ReadOperation
	public int getCouponBySection(@Selector String section) {
		return couponDetails.get(section);

	}

	@WriteOperation
	public void addCourse(@Selector String section, @Selector int count) {
		couponDetails.put(section, count);
	}

	@DeleteOperation
	public void deleteCourse(@Selector String section) {
		couponDetails.remove(section);
	}
}