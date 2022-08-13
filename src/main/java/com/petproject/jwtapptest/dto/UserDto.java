package com.petproject.jwtapptest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import com.petproject.jwtapptest.model.User;

/**
 * DTO class for user requests by ROLE_USER
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUserName(userName);

        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());

        return userDto;
    }
}