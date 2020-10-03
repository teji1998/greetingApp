package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.repository.IGreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    IGreetingRepository greetingRepository;

    public GreetingMessage createMessage(UserDTO userDTO) {
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setGreetingMessage(getMessage(userDTO));
        GreetingMessage message = greetingRepository.save(greetingMessage);
        return message;
    }

    public String getMessage(UserDTO userDTO) {
        if(userDTO.getFirstName() != null && userDTO.getLastName() != null)
            return "Hello " + userDTO.getFirstName() + " " + userDTO.getLastName() ;
        if(userDTO.getFirstName() != null && userDTO.getLastName() == null)
            return "Hello " + userDTO.getFirstName() ;
        if(userDTO.getFirstName() == null && userDTO.getLastName() != null)
            return "Hello " + userDTO.getLastName() ;
        return "Hello World!";
    }

    public GreetingMessage findById(Long id) {
        return greetingRepository.findById(id).get();
    }
}
