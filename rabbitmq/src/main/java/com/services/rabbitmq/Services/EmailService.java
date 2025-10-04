package com.services.rabbitmq.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String emailServer;

    public void senderEmailWelcome(String to){
        System.out.println(to);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(emailServer);
        message.setTo(to);
        message.setSubject("Seja Bem-Vindo ao UniLogin");
        message.setText("Óla amigo :D");

        emailSender.send(message);

    }
}
