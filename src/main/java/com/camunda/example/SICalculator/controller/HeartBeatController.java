package com.camunda.example.SICalculator.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heart-beat/v1")
public class HeartBeatController {

    //@RequestMapping("/beat")
    //@Scheduled(cron = "${heartbeat.duration}")
    @GetMapping("/beat")
    public String heartbeat(){
        return print();
    }
    @Cacheable("name")
    public String print(){
        System.out.println("Invoked..");
        return "Naveen";
    }
}
