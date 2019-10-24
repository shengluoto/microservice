package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TCK on 2019/10/24.
 */
@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient client;

    public String hello() {
        return null;
    }
}
