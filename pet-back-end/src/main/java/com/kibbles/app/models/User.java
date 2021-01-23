package com.kibbles.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Email;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    /**
     * The username (String). Cannot be null and must be unique
     */
    @Column(nullable = false,
        unique = true)
    private String username;

    /**
     * The password (String) for this user. Cannot be null. Never get displayed
     */
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * Primary email account of user. Could be used as the userid. Cannot be null and must be unique.
     */
    @Column(nullable = false,
        unique = true)
    @Email
    private String primaryemail;

    public User() {
    }

    public User(
        String username,
        String password,
        @Email String primaryemail) {
        this.username = username;
        this.password = password;
        this.primaryemail = primaryemail;
    }
    
}
