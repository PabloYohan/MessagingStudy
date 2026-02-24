package com.example.messagingstudy.aplication.services;

import com.example.messagingstudy.domains.expenses.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.messagingstudy.infra.repositories.ExpenseRepository;

import jakarta.transaction.Transactional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }
    
    @Transactional
    public UUID createExpese(BigDecimal amount, LocalDateTime date){
        UUID id = UUID.randomUUID();
        Expense expense = new Expense(id, amount, date);
        expenseRepository.save(expense);
        return id;
    }
    
}
