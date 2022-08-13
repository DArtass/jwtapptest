package com.petproject.jwtapptest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import com.petproject.jwtapptest.model.Status;
import com.petproject.jwtapptest.model.User;

/**
 * DTO class for user requests by ROLE_ADMIN
 *
 * @author Trofimov Alexandr
 * @version 1.0
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setStatus(Status.valueOf(status));
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUserName(user.getUserName());
        adminUserDto.setStatus(user.getStatus().name());
        return adminUserDto;
    }
}