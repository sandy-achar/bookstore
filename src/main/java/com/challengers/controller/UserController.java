package com.challengers.controller;

import com.challengers.LoginUser;
import com.challengers.dto.UserDto;
import com.challengers.entities.User;
import com.challengers.repo.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Created by Malika(mxp134930) on 11/29/2015.
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/getall")
    public String getAllUsers() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userRepository.findAll());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginUser loginUser){

        System.out.println("\nLogin was attempted with username: " + loginUser.getUserName());

        String userName = loginUser.getUserName();

        User user = userRepository.findByUserName(userName);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand()
                .toUri());

        if(user != null){

            if (user.getPassword().equals(loginUser.getPassword())) {

                System.out.println("Login was successful.");
                return new ResponseEntity<>("Success", httpHeaders, HttpStatus.OK);

            } else {

                System.out.println("Login failed. Wrong password.");
                return  new ResponseEntity<>("Fail", httpHeaders, HttpStatus.OK);

            }

        } else {

            System.out.println("Login failed. User doesnt exist");
            return  new ResponseEntity<>("Login Failed", httpHeaders, HttpStatus.OK);

        }

    }

    @RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){

        System.out.println("\nSomeone is trying to register now.");

        User existedUser = userRepository.findByUserName(userDto.getUserName());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand()
                .toUri());

        if(existedUser != null){

            System.out.println("Registration failed. User already exists!");
            return new ResponseEntity<>("Failed", httpHeaders, HttpStatus.OK);

        } else {

            User user = new User(userDto.getUserName(), userDto.getPassword(), userDto.getFirstName(), userDto.getMiddleName(), userDto.getLastName(),
                    userDto.getStreet(), userDto.getCity(), userDto.getZipCode(), userDto.getState(), userDto.getCountry());
            userRepository.save(user);

            System.out.println("Registration successful. User id: " + user.getUserId());
            return new ResponseEntity<>("User Registered Successfully, user id : " + user.getUserId(), httpHeaders, HttpStatus.CREATED);

        }
    }

    @RequestMapping(value = "/updateuser/{userName}", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@PathVariable String userName, @RequestBody UserDto userDto){

        System.out.println("\nUpdate user with username: " + userName);

        User user = userRepository.findByUserName(userName);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand()
                .toUri());

        if(user != null){
            user.setUserName(userDto.getUserName());
            user.setPassword(userDto.getPassword());
            user.setFirstName(userDto.getFirstName());
            user.setMiddleName(userDto.getMiddleName());
            user.setLastName(userDto.getLastName());
            user.setStreet(userDto.getStreet());
            user.setCity(userDto.getCity());
            user.setZipCode(userDto.getZipCode());
            user.setState(userDto.getState());
            user.setCountry(userDto.getCountry());
            userRepository.save(user);

            System.out.println("Update to username: " + userName + " was successful.");
            return new ResponseEntity<>("User Updated Successfully", httpHeaders, HttpStatus.OK);

        } else {

            System.out.println("Update to username: " + userName + " was failed. User doesn't exist.");
            return new ResponseEntity<>("User not found, user Name : " + userName, httpHeaders, HttpStatus.NOT_FOUND);

        }
    }
}
