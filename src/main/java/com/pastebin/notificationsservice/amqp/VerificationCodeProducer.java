package com.pastebin.notificationsservice.amqp;

import com.pastebin.notificationsservice.dto.VerificationCodeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerificationCodeProducer {
    private final AmqpTemplate amqpTemplate;

    public void publishVerificationCode(VerificationCodeDTO verificationCodeDTO,
                                        String exchange, String routingKey) {
        amqpTemplate.convertAndSend(exchange, routingKey, verificationCodeDTO);
    }
}
