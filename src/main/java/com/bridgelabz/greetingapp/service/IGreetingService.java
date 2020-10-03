package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.GreetingMessage;

public interface IGreetingService {

    GreetingMessage getMessage(UserDTO userDTO);

    GreetingMessage findById(Long id);
    
}
