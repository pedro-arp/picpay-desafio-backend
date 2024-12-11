package com.picpay.picpay_challenge;

import org.springframework.boot.SpringApplication;

public class TestPicpayChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.from(PicpayChallengeApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
