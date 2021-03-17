package com.kibbles.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pettype")
public class PetType
    implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long typeid;

    /**
     * 1/2 of the primary key (long) for pettypes.
     * Also is a foreign key into the pets table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "petid")
    @JsonIgnoreProperties(value = "types",
        allowSetters = true)
    private Pet pet;

    /**
     * 1/2 of the primary key (long) for pettypes.
     * Also is a foreign key into the types table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "typeid")
    @JsonIgnoreProperties(value = "users",
        allowSetters = true)
    private Type type;

    public PetType() {
    }

    public PetType(
        Pet pet,
        Type type) {
        this.pet = pet;
        this.type = type;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
