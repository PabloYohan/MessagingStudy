package com.example.messagingstudy.infra.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.messagingstudy.domains.expenses.ExpenseCreatedEvent;

public interface ExpenseCreatedEventRepository extends JpaRepository<ExpenseCreatedEvent, UUID> {

}
