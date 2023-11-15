package com.pastebin.notificationsservice.amqp;

import com.pastebin.notificationsservice.dto.RegisterNotificationDTO;
import com.pastebin.notificationsservice.dto.VerificationCodeDTO;
import com.pastebin.notificationsservice.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegisterNotificationListener {
    private final VerificationCodeProducer verificationCodeProducer;
    private final EmailSenderService emailSenderService;

    @Value("${spring.rabbitmq.exchanges.verification-code}")
    private String internalExchange;

    @Value("${spring.rabbitmq.routing-keys.verification-code}")
    private String internalVerificationCodeRoutingKey;

    @RabbitListener(queues = "${spring.rabbitmq.queues.register-notification}")
    public void receiveEmail(RegisterNotificationDTO notificationDTO) {
        emailSenderService.sendEmail(notificationDTO.to(), notificationDTO.subject(), notificationDTO.body());

        log.info("notification: {}",notificationDTO);
    }
}
