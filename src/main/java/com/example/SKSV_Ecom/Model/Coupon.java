package com.example.SKSV_Ecom.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection  = "coupon")
public class Coupon {
    @Id
    String couponId;
    String couponName;


}
