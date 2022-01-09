package com.vishnu.dos.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class VIshnuRestController {

    private final MeterRegistry meterRegistry;

    public VIshnuRestController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }


    @GetMapping("/")
    public String sayHai(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "Hello user:" + name;
    }

    @GetMapping("/vvdos")
    public String vvdos() throws InterruptedException {
        meterRegistry.counter("dos_attack_counter","status","NOTOK").increment();
        return "I got a Dos Hit";
    }



}
