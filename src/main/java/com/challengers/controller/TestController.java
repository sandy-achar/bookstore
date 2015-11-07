package com.challengers.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Malika(mxp134930) on 11/6/2015.
 */
@RestController
public class TestController {
    @RequestMapping("/")
    public String test(){
        return "Hello from test Conroller";
    }
}
