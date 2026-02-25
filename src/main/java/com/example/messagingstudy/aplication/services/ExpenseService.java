package com.example.messagingstudy.aplication.services;

import com.example.messagingstudy.domains.expenses.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.messagingstudy.infra.repositories.ExpenseCreatedEventRepository;
import com.example.messagingstudy.infra.repositories.ExpenseRepository;

import jakarta.transaction.Transactional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ApplicationEventPublisher publisher;
    private final ExpenseCreatedEventRepository expenseCreatedEventRepository;

    public ExpenseService(ExpenseRepository expenseRepository, 
        ApplicationEventPublisher applicationEventPublisher,
        ExpenseCreatedEventRepository expenseCreatedEventRepository){
        this.expenseRepository = expenseRepository;
        this.publisher = applicationEventPublisher;
        this.expenseCreatedEventRepository = expenseCreatedEventRepository;
    }
    
    @Transactional
    public UUID createExpense(BigDecimal amount, LocalDateTime date){
        UUID id = UUID.randomUUID();
        Expense expense = new Expense(id, amount, date);
        expenseRepository.save(expense);

        UUID event_id = UUID.randomUUID();

        ExpenseCreatedEvent expense_event = new ExpenseCreatedEvent(event_id, id, amount, date, Instant.now());
        expenseCreatedEventRepository.save(expense_event);
        publisher.publishEvent(expense_event);
        return id;
    }
    
}
