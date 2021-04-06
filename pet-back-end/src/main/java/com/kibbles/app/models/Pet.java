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

    @Column(nullable = false)
    private String type;

    //    @OneToMany(mappedBy = "pet",
    //        cascade = CascadeType.ALL)
    //    @JsonIgnoreProperties(value = "pet",
    //        allowSetters = true)
    //    private Set<PetType> types = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "pet",
        allowSetters = true)
    @JoinColumn(name = "userid")
    private Set<Userpet> user = new HashSet<>();

    public Pet() {
    }

    public Pet(User user, String name) {
        this.user = user;
        this.name = name;
    }

    public Pet(
        long petid,
        String name,
        int ageinmonths,
        String type,
        Set<Userpet> user) {
        this.petid = petid;
        this.name = name;
        this.ageinmonths = ageinmonths;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Userpet> getUser() {
        return user;
    }

    public void setUser(Set<Userpet> user) {
        this.user = user;
    }
}
