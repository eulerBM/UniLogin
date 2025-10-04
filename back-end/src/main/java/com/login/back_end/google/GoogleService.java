package com.login.back_end.google;

import com.login.back_end.rabbitmq.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GoogleService {

    private ProducerService producerService;

    public GoogleService(ProducerService producerService) {
        this.producerService = producerService;
    }

    public ResponseEntity<?> googleHello(){

        System.out.println("Estou batendo na rota google!");

        producerService.sendRabbitForEmailWelcome("eullerborgesdamotta155@gmail.com");

        return ResponseEntity.ok().body("Hello Google");
    }
}
