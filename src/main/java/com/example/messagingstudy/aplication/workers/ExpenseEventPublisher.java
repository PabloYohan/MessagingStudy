package com.example.messagingstudy.aplication.workers;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.messagingstudy.domains.expenses.ExpenseCreatedEvent;
import com.example.messagingstudy.infra.rabbitMQ.RabbitConfig;
import com.example.messagingstudy.infra.repositories.ExpenseCreatedEventRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExpenseEventPublisher {
    private final ExpenseCreatedEventRepository expenseCreatedEventRepository;
    private final RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 5000)
    @Transactional
    public void publishPendingEvents(){
        List<ExpenseCreatedEvent> events = expenseCreatedEventRepository.findByProcessedFalse();
        for(ExpenseCreatedEvent event : events){
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, event);
            event.MarkAsProcessed();
        }
    }

}
