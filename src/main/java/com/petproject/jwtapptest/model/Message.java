package com.petproject.jwtapptest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
public class Message extends BaseEntity{

    @Column(name = "text")
    private String text;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="user_id")
    private User user;

    public Message() {}

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
        this.setStatus(Status.valueOf("ACTIVE"));
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + super.getId() + ", " +
                "text: " + text + ", " +
                "sender: " + user.getUsername() + "}";
    }
}
