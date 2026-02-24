package com.example.messagingstudy.domains.expenses;

import java.math.BigDecimal;
import java.time.Instant;
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
@Table(name = "expense_created_event")
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseCreatedEvent {
    @Id
    private UUID Id;

    @Column(name = "expense_id", nullable = false)
    private UUID expenseId;

    private BigDecimal amount;

    @Column(name = "expense_date")
    LocalDateTime date;

    @Column(name = "occurredat")
    private Instant occurredAt;
}
