package com.example.SKSV_Ecom.Controller;

import com.example.SKSV_Ecom.Model.Coupon;
import com.example.SKSV_Ecom.Service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping ("/save")
    public String saveCoupon(@RequestBody Coupon coupon) {
        return couponService.saveCoupon(coupon);
    }

    @GetMapping("/all")
    public List<Coupon> getAllCoupon() {
        return couponService.findAllCoupon();
    }

    @PutMapping("/update/{couponId}")
    public Coupon updateCoupon(@PathVariable String couponId, @RequestBody Coupon updatedCoupon) {
        return couponService.updateCoupon(couponId, updatedCoupon);
    }

    @DeleteMapping("/delete/{couponId}")
    public String deleteCoupon(@PathVariable String couponId) {
        couponService.deleteCoupon(couponId);
        return "Coupon with ID " + couponId + " deleted successfully!";
    }



}
