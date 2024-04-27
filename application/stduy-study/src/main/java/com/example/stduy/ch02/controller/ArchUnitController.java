package com.example.stduy.ch02.controller;

import com.example.stduy.ch02.service.ArchUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ArchUnitController {

    private final ArchUnitService archUnitService;

    @GetMapping("/test")
    public String testMethod() {
        archUnitService.test();
        return "SUCCESS";
    }

}
