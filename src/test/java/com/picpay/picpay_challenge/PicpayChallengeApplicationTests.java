package com.picpay.picpay_challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class PicpayChallengeApplicationTests {

    @Test
    void contextLoads() {
    }

}
