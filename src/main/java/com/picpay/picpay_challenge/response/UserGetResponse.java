package com.picpay.picpay_challenge.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserGetResponse {
    private Long id;
    private String fullName;
    private String cpfCnpj;
    private String email;
}
