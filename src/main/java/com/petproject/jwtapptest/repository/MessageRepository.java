package com.petproject.jwtapptest.repository;

import com.petproject.jwtapptest.model.Message;
import com.petproject.jwtapptest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByUser(User user);
}
