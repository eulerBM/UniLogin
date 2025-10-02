package com.services.rabbitmq.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue fila;

    public NotificacaoProducer(RabbitTemplate rabbitTemplate, Queue fila) {
        this.rabbitTemplate = rabbitTemplate;
        this.fila = fila;
    }

    public void enviarNotificacao(String mensagem) {
        rabbitTemplate.convertAndSend(fila.getName(), mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }

}
