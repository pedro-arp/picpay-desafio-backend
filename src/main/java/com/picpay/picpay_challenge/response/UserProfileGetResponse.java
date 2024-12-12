package com.picpay.picpay_challenge.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserProfileGetResponse {

    public record User(Long id, String fullName) {

    }

    public record Profile(Long id, String name) {

    }

    private Long id;
    private User user;
    private Profile profile;

}