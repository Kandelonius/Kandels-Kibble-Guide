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

    @OneToMany(mappedBy = "pet",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "pet",
        allowSetters = true)
    private Set<Userpet> users = new HashSet<>();

    public Pet() {
    }

    public Pet(
        long petid,
        String name,
        Set<Userpet> users) {
        this.petid = petid;
        this.name = name;
        this.users = users;
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

    public Set<Userpet> getUsers() {
        return users;
    }

    public void setUsers(Set<Userpet> users) {
        this.users = users;
    }
}
