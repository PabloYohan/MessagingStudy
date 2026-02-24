package com.example.messagingstudy.aplication.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseDTO(BigDecimal amount, LocalDateTime date) {
    
}
