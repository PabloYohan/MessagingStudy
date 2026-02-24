package com.example.messagingstudy.aplication.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.messagingstudy.domains.expenses.ExpenseCreatedEvent;
import com.example.messagingstudy.infra.rabbitMQ.RabbitConfig;


@Component
public class ExpenseProcessedEventListener {
    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void recieve(ExpenseCreatedEvent event){
        System.out.println("Recebido: " + event.getId());
    }
}
