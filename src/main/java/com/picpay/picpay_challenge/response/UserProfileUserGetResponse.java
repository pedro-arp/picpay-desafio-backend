package com.picpay.picpay_challenge.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserProfileUserGetResponse {

    private Long id;
    private String fullName;
    private String email;
}