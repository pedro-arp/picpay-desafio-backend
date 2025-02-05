package com.picpay.picpay_challenge.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RetailerPostResponse {
    private Long id;
    private String fullName;
    private String cnpj;
    private String email;
    private Double accountBalance;
}
