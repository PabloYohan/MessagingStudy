package com.example.messagingstudy.aplication.controllers;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.messagingstudy.aplication.dto.ExpenseDTO;
import com.example.messagingstudy.aplication.services.ExpenseService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ExpenseController.class)
@AutoConfigureMockMvc
public class ExpenseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


    @MockitoBean
    private ExpenseService expenseService;


    @Test
    void ExpenseController_ShouldReturnCreatedAndUUID() throws Exception {
        UUID fakeId = UUID.randomUUID();
        when(expenseService.createExpense(new BigDecimal(100), LocalDateTime.of(2026, 2, 25, 10, 0))).thenReturn(fakeId);
        
        ExpenseDTO expenseDTO = new ExpenseDTO(new BigDecimal(100), LocalDateTime.of(2026, 2, 25, 10, 0));
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String json = objectMapper.writeValueAsString(expenseDTO);

        mockMvc.perform(post("/expenses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isCreated())
            .andExpect(content().json("{\"id\":\"" + fakeId + "\"}"));
    }
}
