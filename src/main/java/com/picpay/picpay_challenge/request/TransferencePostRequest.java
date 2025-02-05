package com.picpay.picpay_challenge.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TransferencePostRequest {
    @NotBlank(message = "The field 'payer' is required")
    private String payer;
    @NotBlank(message = "The field 'payee' is required")
    private String payee;
    @NotBlank(message = "The field 'value' is required")
    private Double value;

}


