package com.Tesla.Tesla.model;

import com.sun.istack.NotNull;
import lombok.Data;
import com.Tesla.Tesla.controller.RegisterController;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column
    private String username;

    @NotNull
    @Column
    private String password;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Email
    @NotNull
    @Column(name = "email")
    private String email;

    @Transient
    private String passwordConfirm;

}
