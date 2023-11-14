package com.pastebin.notificationsservice.dto;


public record RegisterNotificationDTO(
        String to,
        String subject,
        String body
) {
}
