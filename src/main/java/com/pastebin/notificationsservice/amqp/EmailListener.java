package com.pastebin.notificationsservice.amqp;

import com.pastebin.notificationsservice.dto.RegisterNotificationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailListener {
    private final EmailProducer emailProducer;

    @Value("${spring.rabbitmq.exchanges.register}")
    private String internalExchange;

    @Value("${spring.rabbitmq.routing-keys.register}")
    private String internalEmailNotificationRoutingKey;

    @RabbitListener(queues = "${spring.rabbitmq.queues.register}")
    public void receiveEmail(RegisterNotificationDTO notificationDTO) {
        log.info("got: {}", notificationDTO);
    }
}
