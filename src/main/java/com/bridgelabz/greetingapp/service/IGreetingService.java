package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.GreetingMessage;
import java.util.List;

public interface IGreetingService {

    public GreetingMessage getMessage(UserDTO userDTO);
    public GreetingMessage findById(Long id);
    public List<GreetingMessage> findMessages();
}
