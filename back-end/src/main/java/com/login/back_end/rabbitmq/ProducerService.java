package com.login.back_end.rabbitmq;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final AmqpTemplate amqpTemplate;

    @Value("${rabbit.exchange}")
    private String exchange;

    @Value("${rabbit.routing.key}")
    private String routingKey;

    public ProducerService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendRabbitForEmailWelcome(String email) {
        System.out.println(email);
        amqpTemplate.convertAndSend(exchange, routingKey, email);
    }

}
