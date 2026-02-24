package com.example.messagingstudy.aplication.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.messagingstudy.aplication.DTO.ExpenseDTO;
import com.example.messagingstudy.aplication.services.ExpenseService;

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
    public ResponseEntity<UUID> ExpenseCreate(@RequestBody ExpenseDTO body) {

        UUID id = expenseService.createExpese(body.amount(), body.date());
        
        return ResponseEntity.status(201).body(id);
    }
    
}
