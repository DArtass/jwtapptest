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
}
