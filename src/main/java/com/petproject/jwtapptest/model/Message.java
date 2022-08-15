package com.petproject.jwtapptest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
public class Message extends BaseEntity{

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    private User sender;

    public Message() {}

    public Message(String text, User sender) {
        this.text = text;
        this.sender = sender;
        this.setStatus(Status.valueOf("ACTIVE"));
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + super.getId() + ", " +
                "text: " + text + ", " +
                "sender: " + sender.getUsername() + "}";
    }
}
