package com.pastebin.notificationsservice.amqp;

import com.pastebin.notificationsservice.dto.RegisterNotificationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmailProducer {
    private final AmqpTemplate amqpTemplate;

    public void publishEmail(RegisterNotificationDTO notificationDTO,
                             String exchange, String routingKey) {
        amqpTemplate.convertAndSend(exchange, routingKey, notificationDTO);
    }
}
