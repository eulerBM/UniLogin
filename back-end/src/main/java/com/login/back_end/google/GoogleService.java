package com.login.back_end.google;

import com.login.back_end.rabbitmq.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GoogleService {

    private final ProducerService producerService;

    public GoogleService(ProducerService producerService) {
        this.producerService = producerService;
    }

    public ResponseEntity<?> googleHello(){

        producerService.sendMessage("Oi euler To enviando entre os Back end!");

        return ResponseEntity.ok().body("Hello Google");
    }
}
