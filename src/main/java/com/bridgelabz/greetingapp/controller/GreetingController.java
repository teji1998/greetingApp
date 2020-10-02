package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping("/hello")
    public ResponseEntity getMessage(@RequestBody UserDTO userDTO) {
        String message = greetingService.getMessage(userDTO);
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
