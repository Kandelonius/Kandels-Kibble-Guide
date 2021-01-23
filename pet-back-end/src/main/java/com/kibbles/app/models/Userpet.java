package com.kibbles.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "userpet")

public class Userpet {

    /**
     * The primary key (long) of the userpet table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long petid;

    @ManyToOne
    @JoinColumn(name = "userid",
        nullable = false)
    @JsonIgnoreProperties(value = "userpet",
        allowSetters = true)
    private User user;

    public Userpet() {
    }

    public Userpet(
        long petid,
        User user) {
        this.petid = petid;
        this.user = user;
    }

    public long getPetid() {
        return petid;
    }

    public void setPetid(long petid) {
        this.petid = petid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
