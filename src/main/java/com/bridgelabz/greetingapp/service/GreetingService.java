package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getMessage(UserDTO userDTO) {
        if(userDTO.getFirstName() != null && userDTO.getLastname() != null)
            return "Hello " + userDTO.getFirstName() + " " + userDTO.getLastname() ;
        if(userDTO.getFirstName() != null && userDTO.getLastname() == null)
            return "Hello " + userDTO.getFirstName() ;
        if(userDTO.getFirstName() == null && userDTO.getLastname() != null)
            return "Hello " + userDTO.getLastname() ;
        return "Hello World!";
    }
}
