package com.musinsa.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

class UtilApplicationTests {

    @Test
    void contextLoads() {

        String u = String.valueOf(UUID.randomUUID());
        String u1 = String.valueOf(UUID.randomUUID());

        System.out.println(u.replaceAll("-", "") + u1.replaceAll("-", ""));

    }

}
