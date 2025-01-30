package com.example.SKSV_Ecom.Repo;

import com.example.SKSV_Ecom.Model.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends MongoRepository<Coupon,String> {
}
