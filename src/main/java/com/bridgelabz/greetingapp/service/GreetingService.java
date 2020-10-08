package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingMessageDTO;
import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.exception.GreetingMessageException;
import com.bridgelabz.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.repository.IGreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GreetingService {

    @Autowired
    IGreetingRepository greetingRepository;

    @Autowired
    ModelMapper modelMapper;

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
        return greetingRepository.findById(id).orElseThrow(() -> new GreetingMessageException("Record not found")) ;
    }

    public List<GreetingMessage> findMessages() {
        return greetingRepository.findAll();
    }

    public GreetingMessage updateMessage(GreetingMessageDTO greetingMessageDTO) {
       findById(greetingMessageDTO.getGreetingId());
       GreetingMessage greetingMessage = modelMapper.map(greetingMessageDTO, GreetingMessage.class);
       return greetingRepository.save(greetingMessage);
    }

    public String deleteMessage(Long id) {
        greetingRepository.delete(greetingRepository.findById(id).get());
        return "Deleted message";
    }
}