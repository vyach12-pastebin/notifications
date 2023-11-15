package com.pastebin.notificationsservice.dto;

import lombok.Builder;

@Builder
public record VerificationCodeDTO(
        String email,
        String verificationCode
) {
}
