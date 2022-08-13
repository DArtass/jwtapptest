package com.petproject.jwtapptest.dto;

import lombok.Data;

/**
 * DTO class for authentication (login) request.
 *
 * @author Trofimov Alexandr
 * @version 1.0
 */

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}