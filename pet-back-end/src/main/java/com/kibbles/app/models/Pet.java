package com.kibbles.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long petid;

    @Column(nullable = false,
        unique = true)
    private String name;

    @Column(nullable = false)
    private int ageinmonths;

    @OneToMany(mappedBy = "pet",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "pet",
        allowSetters = true)
    private Set<PetType> types = new HashSet<>();

    @OneToMany
    @JsonIgnoreProperties(value = "pets",
        allowSetters = true)
    @JoinColumn(name = "userid")
    private Set<Userpet> user = new HashSet<>();

    public Pet() {
    }

    public Pet(
        long petid,
        String name,
        int ageinmonths,
        Set<Userpet> user) {
        this.petid = petid;
        this.name = name;
        this.ageinmonths = ageinmonths;
        this.user = user;
    }

    public long getPetid() {
        return petid;
    }

    public void setPetid(long petid) {
        this.petid = petid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeinmonths() {
        return ageinmonths;
    }

    public void setAgeinmonths(int ageinmonths) {
        this.ageinmonths = ageinmonths;
    }

    public Set<Userpet> getUser() {
        return user;
    }

    public void setUser(Set<Userpet> user) {
        this.user = user;
    }
}
