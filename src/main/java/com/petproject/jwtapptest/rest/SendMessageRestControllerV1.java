package com.petproject.jwtapptest.rest;

import com.petproject.jwtapptest.dto.AdminUserDto;
import com.petproject.jwtapptest.model.User;
import com.petproject.jwtapptest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for ROLE_ADMIN requests.
 *
 * @author Trofimov Alexandr
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api/v1/sendmess/")
public class SendMessageRestControllerV1 {

    private final UserService userService;

    @Autowired
    public SendMessageRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}