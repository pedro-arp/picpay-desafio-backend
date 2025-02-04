package com.picpay.picpay_challenge.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TransferenceUserToUserPostResponse {
    private String payer;
    private String payee;
    private Double value;


}


