package com.example.messagingstudy.domains.expenses;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class ExpenseCreatedEvent {
    UUID eventId;
    int expenseId;
    double amount;
    LocalDateTime date;
    Instant occurredAt;
}
