package com.picpay.picpay_challenge.request;

import com.picpay.picpay_challenge.domain.CommonUser;
import com.picpay.picpay_challenge.domain.Retailer;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TransferenceRetailerPostRequest {

    @NotBlank(message = "The field 'payer' is required")
    private CommonUser payer;
    @NotBlank(message = "The field 'payee' is required")
    private Retailer retailerPayee;
    @NotBlank(message = "The field 'value' is required")
    private Double value;

}


