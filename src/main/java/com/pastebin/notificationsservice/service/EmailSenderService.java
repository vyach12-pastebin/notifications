package com.pastebin.notificationsservice.service;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String body);
}