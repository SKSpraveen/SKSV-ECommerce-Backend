package com.example.SKSV_Ecom.Service;

import com.example.SKSV_Ecom.Model.Coupon;

import java.util.List;

public interface CouponService {
    String saveCoupon(Coupon coupon);
    List<Coupon> findAllCoupon();
    Coupon updateCoupon(String couponId, Coupon updatedCoupon);
    void deleteCoupon(String couponId);
}
