package com.example.messagingstudy.aplication.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.messagingstudy.aplication.dto.ExpenseDTO;
import com.example.messagingstudy.aplication.services.ExpenseService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> ExpenseCreate(@Valid @RequestBody ExpenseDTO body) {

        UUID id = expenseService.createExpense(body.amount(), body.date());
        Map<String, Object> response = new HashMap<>();
        response.put("id", id.toString());
        
        return ResponseEntity.status(201).body(response);
    }
    
}
