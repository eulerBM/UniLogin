package com.login.back_end.rabbitmq;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private AmqpTemplate amqpTemplate;

    @Value("${rabbit.exchange}")
    private String exchange;

    @Value("${rabbit.routing.key}")
    private String routingKey;

    public ProducerService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(String msg) {
        amqpTemplate.convertAndSend(exchange, routingKey, msg);
        System.out.println("Mensagem enviada: " + msg);
    }

}
