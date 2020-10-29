package com.bridgelabz.greetingapp;

import com.bridgelabz.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class MVCTesting {
    @Autowired

    private MockMvc mockMvc;

    @MockBean
    IGreetingService service;

    @Test
    public void demoTest() throws Exception {
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setGreetingMessage("Hello World");
        when(service.findById(123L)).thenReturn(greetingMessage);
        MvcResult mvcResult = mockMvc.perform(get("/Greeting/id?id=123")).andReturn();
        Assertions.assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }
}


