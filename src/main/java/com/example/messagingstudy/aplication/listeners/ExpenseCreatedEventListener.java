package com.example.messagingstudy.aplication.listeners;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.example.messagingstudy.domains.expenses.ExpenseCreatedEvent;

@Component
public class ExpenseCreatedEventListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(ExpenseCreatedEvent event) {
        System.out.println("Evento disparado: " + event.getExpenseId());
    }
}
