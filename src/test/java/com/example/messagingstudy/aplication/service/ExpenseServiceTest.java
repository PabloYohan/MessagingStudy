package com.example.messagingstudy.aplication.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;

import com.example.messagingstudy.aplication.services.ExpenseService;
import com.example.messagingstudy.infra.repositories.ExpenseCreatedEventRepository;
import com.example.messagingstudy.infra.repositories.ExpenseRepository;

public class ExpenseServiceTest {
    @Mock
    private ExpenseRepository expenseRepository;
    @Mock
    private ApplicationEventPublisher applicationEventPublisher;
    @Mock
    private ExpenseCreatedEventRepository expenseCreatedEventRepository;
    @InjectMocks
    private ExpenseService expenseService;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void createExpense_ShouldSaveExpenseAndPublishEvent() {
        BigDecimal amount = BigDecimal.valueOf(100);
        LocalDateTime date = LocalDateTime.now();

        UUID id = expenseService.createExpense(amount, date);

        verify(expenseRepository, times(1)).save(any());

        verify(expenseCreatedEventRepository, times(1)).save(any());
        
        verify(applicationEventPublisher, atMost(1)).publishEvent(any());

        assert(id != null);
    }

}
