package com.example.SKSV_Ecom.Service;

import com.example.SKSV_Ecom.Model.Coupon;
import com.example.SKSV_Ecom.Repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepo couponRepo;

    @Override
    public String saveCoupon(Coupon coupon) {
        return couponRepo.save(coupon).getCouponId();
    }

    @Override
    public List<Coupon> findAllCoupon() {
        try {
            List<Coupon> coupons = couponRepo.findAll();
            System.out.println("Fetched coupons: " + coupons);
            return coupons;
        } catch (Exception e) {
            System.err.println("Error fetching coupons: " + e.getMessage());
            return Collections.emptyList(); // Return empty list instead of failing
        }
    }

    @Override
    public Coupon updateCoupon(String couponId, Coupon updatedCoupon) {
        return couponRepo.findById(couponId).map(existingCoupon -> {
            existingCoupon.setCouponName(updatedCoupon.getCouponName());
            return couponRepo.save(existingCoupon);
        }).orElseThrow(() -> new RuntimeException("Coupon not found with id: " + couponId));
    }


    @Override
    public void deleteCoupon(String couponId) {
        if (couponRepo.existsById(couponId)) {
            couponRepo.deleteById(couponId);
        } else {
            throw new RuntimeException("Coupon not found with id: " + couponId);
        }
    }



}
