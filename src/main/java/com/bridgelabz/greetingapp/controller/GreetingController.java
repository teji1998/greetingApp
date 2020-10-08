package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class GreetingController {

    @Autowired
    GreetingService greetingService;


    @PostMapping()
    public ResponseEntity getMessage(@RequestBody UserDTO userDTO) {
        GreetingMessage message = greetingService.createMessage(userDTO);
        return new ResponseEntity(message.getGreetingMessage(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity getMessageById(@RequestParam Long id) {
        GreetingMessage greetingMessage = greetingService.findById(id);
        return new ResponseEntity(greetingMessage, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAllMessage() {
        List<GreetingMessage> greetingMessageList = greetingService.findMessages();
        return new ResponseEntity<>(greetingMessageList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updatingMessageUsingId(@RequestParam Long id, @RequestBody UserDTO userDTO) {
        GreetingMessage greetingMessage = greetingService.updateMessage(id, userDTO);
        return new ResponseEntity(greetingMessage, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteMessage(Long id) {
        String greetingMessage = greetingService.deleteMessage(id);
        return new ResponseEntity(greetingMessage, HttpStatus.OK);
    }

}

