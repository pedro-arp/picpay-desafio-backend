package com.picpay.picpay_challenge.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CommonUserGetResponse {
    private Long id;
    private String fullName;
    private String cpf;
    private String email;
}
