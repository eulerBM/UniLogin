package com.services.rabbitmq.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue minhaFila(){
        return new Queue("fila-notificacoes", false);
    }
}
