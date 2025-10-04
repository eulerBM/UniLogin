package com.services.rabbitmq.consumer;

import com.services.rabbitmq.Services.EmailService;
import com.services.rabbitmq.configs.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoConsumer {

    private final EmailService emailService;

    public NotificacaoConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${rabbit.queue}")
    public void receiveMessage(String email) {
        System.out.println("Email recebido: " + email);

        // Envia o Email
        emailService.senderEmailWelcome(email);
    }
}
