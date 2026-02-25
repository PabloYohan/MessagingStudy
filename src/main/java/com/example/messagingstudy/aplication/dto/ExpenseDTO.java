package com.example.messagingstudy.aplication.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ExpenseDTO(@PositiveOrZero(message = "O valor deve ser maior que zero") BigDecimal amount, @NotNull(message = "A data não pode ser vazia") LocalDateTime date) {
    
}
