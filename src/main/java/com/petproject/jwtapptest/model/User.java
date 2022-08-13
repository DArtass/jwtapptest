package com.petproject.jwtapptest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity{

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_messages",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "message_id", referencedColumnName = "id")})
    private List<Message> messages;
}
