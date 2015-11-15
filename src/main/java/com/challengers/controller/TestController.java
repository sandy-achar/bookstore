package com.challengers.controller;

import com.challengers.repo.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Malika(mxp134930) on 11/6/2015.
 */
@RestController
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userRepository.findAll());
    }
}
