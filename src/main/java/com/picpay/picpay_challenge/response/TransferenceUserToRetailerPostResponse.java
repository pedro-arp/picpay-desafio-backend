package com.picpay.picpay_challenge.response;

import com.picpay.picpay_challenge.domain.CommonUser;
import com.picpay.picpay_challenge.domain.Retailer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TransferenceUserToRetailerPostResponse {
    private CommonUser payer;
    private Retailer retailerPayee;
    private Double value;


}


