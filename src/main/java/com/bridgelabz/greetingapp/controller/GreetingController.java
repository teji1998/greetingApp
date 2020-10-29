package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingMessageDTO;
import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    IGreetingService greetingService;

    @PostMapping("/add")
    public ResponseEntity getMessage(@RequestBody UserDTO userDTO) {
        String message = greetingService.createMessage(userDTO);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity getMessageById(@RequestParam Long id) {
        GreetingMessage greetingMessage = greetingService.findById(id);
        return new ResponseEntity(greetingMessage.getGreetingMessage(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAllMessage() {
        List<GreetingMessage> greetingMessageList = greetingService.findMessages();
        return new ResponseEntity<>(greetingMessageList, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity updatingMessageUsingId(@RequestBody GreetingMessageDTO greetingMessageDTO) {
        System.out.println(greetingMessageDTO);
        String greetingMessage = greetingService.updateMessage(greetingMessageDTO);
        return new ResponseEntity(greetingMessage, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteMessage(@RequestParam Long id) {
        String greetingMessage = greetingService.deleteMessage(id);
        return new ResponseEntity(greetingMessage, HttpStatus.OK);
    }
}

