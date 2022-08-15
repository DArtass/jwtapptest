package com.petproject.jwtapptest.repository;

import com.petproject.jwtapptest.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
