package com.services.rabbitmq.consumer;

import com.services.rabbitmq.configs.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoConsumer {

    @RabbitListener(queues = "${rabbit.queue}")
    public void receiveMessage(String msg) {
        System.out.println("Mensagem recebida: " + msg);
        // processa no segundo back-end -> Enviar emaiL!
    }
}
