package com.kibbles.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false)
    private int age;

    /**
     * Primary email account of user. Could be used as the userid. Cannot be null and must be unique.
     */
    @Column(nullable = false,
        unique = true)
    @Email
    private String primaryemail;

    @OneToMany(mappedBy = "user",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "user",
        allowSetters = true)
    private List<Pet> userpet = new ArrayList<>();

    public User() {
    }

    public User(
        String username,
        String password,
        @Email String primaryemail) {
        setUsername(username);
        setPassword(password);
        this.primaryemail = primaryemail;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter for password
     *
     * @param password the new password (String) for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrimaryemail() {
        return primaryemail;
    }

    public void setPrimaryemail(String primaryemail) {
        this.primaryemail = primaryemail;
    }

    public List<Pet> getUserpet() {
        return userpet;
    }

    public void setUserpet(List<Pet> userpet) {
        this.userpet = userpet;
    }
}
