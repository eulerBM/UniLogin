package com.services.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoConsumer {

    @RabbitListener(queues = "fila-notificacoes")
    public void receberNotificacao(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
        // Aqui você poderia enviar e-mail ou salvar no banco
    }
}
