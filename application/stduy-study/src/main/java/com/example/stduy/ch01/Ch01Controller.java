package com.example.stduy.ch01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Ch01Controller {

    private static int SAMPLE_CONSTANT = 0;

    @GetMapping("/test")
    public String test01() {
        SAMPLE_CONSTANT++;
        System.out.println("test01 호출 : " + SAMPLE_CONSTANT);
        return "test : " + SAMPLE_CONSTANT;
    }



}
