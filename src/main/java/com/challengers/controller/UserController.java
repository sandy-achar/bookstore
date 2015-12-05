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

        System.out.println("A login was attempted!");
        System.out.println("userName: " + loginUser.getUserName());
        System.out.println("password: " + loginUser.getPassword());

        String userName = loginUser.getUserName();

        User user = userRepository.findByUserName(userName);
        HttpHeaders httpHeaders = new HttpHeaders();
        if(user != null){
            System.out.println("User Name found!");
            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri());

            if (user.getPassword().equals(loginUser.getPassword())) {

                return new ResponseEntity<>("Success Login!", httpHeaders, HttpStatus.OK);

            } else {

                System.out.println("The actual password: " + user.getPassword());
                return  new ResponseEntity<>("Login Failed", httpHeaders, HttpStatus.OK);

            }

        } else {

            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri());

            //return new ResponseEntity<>("User not Found with username " + userName, httpHeaders, HttpStatus.NOT_FOUND);
            return  new ResponseEntity<>("Login Failed", httpHeaders, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){

        User existedUser = userRepository.findByUserName(userDto.getUserName());
        HttpHeaders httpHeaders = new HttpHeaders();

        if(existedUser != null){

            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri());

            return new ResponseEntity<>("User with username " + userDto.getUserName() + " already existed.", httpHeaders, HttpStatus.BAD_REQUEST);

        } else {

            User user = new User(userDto.getUserName(), userDto.getPassword(), userDto.getFirstName(), userDto.getMiddleName(), userDto.getLastName(),
                    userDto.getStreet(), userDto.getCity(), userDto.getZipCode(), userDto.getState(), userDto.getCountry());
            userRepository.save(user);

            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri());

            return new ResponseEntity<>("User Registered Successfully, user id : " + user.getUserId(), httpHeaders, HttpStatus.CREATED);

        }
    }

    @RequestMapping(value = "/updateuser/{userName}", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@PathVariable String userName, @RequestBody UserDto userDto){
        User user = userRepository.findByUserName(userName);
        HttpHeaders httpHeaders = new HttpHeaders();
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

            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri());
            return new ResponseEntity<>("User Updated Successfully", httpHeaders, HttpStatus.OK);
        }
        else {
            httpHeaders.setLocation(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand()
                    .toUri());
            return new ResponseEntity<>("User not found, user Name : " + userName, httpHeaders, HttpStatus.NOT_FOUND);
        }
    }
}
