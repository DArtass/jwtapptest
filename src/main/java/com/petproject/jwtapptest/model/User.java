package com.petproject.jwtapptest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity{

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany (mappedBy="user", fetch=FetchType.EAGER)
    private List<Message> messages;

    @Override
    public String toString() {
        return "User{" +
                "id: " + super.getId() + ", " +
                "name: " + username + "}";
    }
}
