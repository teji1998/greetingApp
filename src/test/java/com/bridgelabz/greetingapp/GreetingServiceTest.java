package com.bridgelabz.greetingapp;

import com.bridgelabz.greetingapp.dto.GreetingMessageDTO;
import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.repository.IGreetingRepository;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GreetingServiceTest {
        @Mock
        IGreetingRepository greetingRepository;

        @InjectMocks
        GreetingService service;

        @Test
        public void demoTest() {
            Assertions.assertEquals(1, 1);
        }

        @Test
        public void givenUserDTO_WhenSaved_ShouldReturnSuccessFull() {
            GreetingMessage greetingMessage = new GreetingMessage();
            when(greetingRepository.save(greetingMessage)).thenReturn(greetingMessage);
            String message = service.createMessage(new UserDTO());
            Assertions.assertEquals("Message successfully saved", message);
        }

        @Test
        public void givenEditedData_WhenUpdated_ShouldReturnSuccessFull() {
            GreetingMessage greetingMessage = new GreetingMessage();
            greetingMessage.setGreetingId(123L);
            GreetingMessageDTO greetingDTO = new GreetingMessageDTO();
            greetingDTO.setGreetingId(123L);
            when(greetingRepository.save(greetingMessage)).thenReturn(greetingMessage);
            when(greetingRepository.findById(anyLong())).thenReturn(java.util.Optional.of(greetingMessage));
            String message = service.updateMessage(greetingDTO);
            Assertions.assertEquals("Message updated", message);
        }
}
