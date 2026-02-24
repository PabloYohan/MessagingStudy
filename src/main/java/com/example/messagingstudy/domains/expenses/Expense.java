package com.example.messagingstudy.domains.expenses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "expense")
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    private UUID id;

    private BigDecimal amount;

    @Column(name = "expense_date")
    private LocalDateTime date;

}
