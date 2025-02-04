package com.picpay.picpay_challenge.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TransferenceUserPostRequest {

    private String payer;

    private String payee;

    private Double value;

}


