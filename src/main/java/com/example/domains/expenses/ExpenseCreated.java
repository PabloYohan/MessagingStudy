package com.example.domains.expenses;

import java.time.LocalDateTime;
import java.util.UUID;

public class ExpenseCreated {
    UUID eventId;
    int expenseId;
    double amount;
    LocalDateTime date;
}
