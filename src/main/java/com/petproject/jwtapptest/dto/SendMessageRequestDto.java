package com.petproject.jwtapptest.dto;

import lombok.Data;

/**
 * DTO class for authentication (login) request.
 *
 * @author Trofimov Alexandr
 * @version 1.0
 */

@Data
public class SendMessageRequestDto {
    private String username;
    private String message;
}