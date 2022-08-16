package com.petproject.jwtapptest.rest;

import com.petproject.jwtapptest.dto.SendMessageRequestDto;
import com.petproject.jwtapptest.model.Message;
import com.petproject.jwtapptest.model.User;
import com.petproject.jwtapptest.repository.MessageRepository;
import com.petproject.jwtapptest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST controller for ROLE_ADMIN requests.
 *
 * @author Trofimov Alexandr
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api/v1/messages/")
public class SendMessageRestControllerV1 {

    private final UserService userService;
    private MessageRepository messageRepository;

    @Autowired
    public SendMessageRestControllerV1(UserService userService, MessageRepository messageRepository) {
        this.userService = userService;
        this.messageRepository = messageRepository;
    }

    @PostMapping(value = "send")
    public ResponseEntity sendMessage(@RequestBody SendMessageRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            User user = userService.findByUserName(username);
            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String messageStr = requestDto.getMessage();
            if (messageStr.length() > 7)
                if (messageStr.substring(0, 8).equalsIgnoreCase("history ")) {
                    Map<Object, Object> response = new HashMap<>();
                    List<Message> messages = messageRepository.findByUser(user);

                    for (int i = messages.size() - 1; i >= 0 & i > messages.size() - 11; i--) {
                        response.put("message " + i + ":", messages.get(i).getText());
                    }
                    return ResponseEntity.ok(response);
                }
            Message message = new Message(messageStr, user);
            messageRepository.save(message);

            return new ResponseEntity<>(requestDto, HttpStatus.OK);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }

    }
}