package com.bridgelabz.greetingapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreetingMessageDTO {
    private Long greetingId;
    private String message;
    private String firstName;
    private String lastName;
}
