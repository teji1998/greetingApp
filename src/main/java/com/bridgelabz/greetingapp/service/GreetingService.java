package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingMessageDTO;
import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.exception.GreetingMessageException;
import com.bridgelabz.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.repository.IGreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GreetingService implements IGreetingService {

    @Autowired
    IGreetingRepository greetingRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String createMessage(UserDTO userDTO) {
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setGreetingMessage(this.getMessage(userDTO.getFirstName(),userDTO.getLastName(),
                userDTO.getMessage()));
        greetingRepository.save(greetingMessage);
        return "Message successfully saved";
    }

    public String getMessage(String firstName, String lastName, String message) {
        if((firstName != null && firstName.length() != 0) && (lastName != null && lastName.length() != 0))
            return "Hello " + firstName + " " + lastName ;
        if(firstName != null && firstName.length() != 0 )
            return "Hello " + firstName ;
        if(lastName != null && lastName.length() != 0)
            return "Hello " + lastName ;
        if(message != null && message.length() !=0)
            return message;
        return "Hello World!";
    }

    @Override
    public GreetingMessage findById(Long id) {
        return greetingRepository.findById(id).orElseThrow(
                () -> new GreetingMessageException("Record not found")) ;
    }

    @Override
    public List<GreetingMessage> findMessages() {
        return greetingRepository.findAll();
    }

    @Override
    public String updateMessage( GreetingMessageDTO greetingMessageDTO) {

        findById(greetingMessageDTO.getGreetingId());
            GreetingMessage greetingMessage = new GreetingMessage();
            greetingMessage.setGreetingId(greetingMessageDTO.getGreetingId());
            greetingMessage.setGreetingMessage(getMessage(greetingMessageDTO.getFirstName(),
                    greetingMessageDTO.getLastName(),greetingMessageDTO.getMessage()));
            greetingRepository.save(greetingMessage);
            return "Message updated";

    }

    public String deleteMessage(Long id) {
        greetingRepository.delete(findById(id));
        return "Deleted message";
    }
}