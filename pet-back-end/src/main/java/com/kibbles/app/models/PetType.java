package com.kibbles.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "types")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long typeid;

    /**
     * The name (String) of the pet type. Cannot be null and must be unique. (cat or dog)
     */
    @Column(nullable = false,
        unique = true)
    private String name;

    @ManyToOne(mappedBy = "pet",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "pets",
        allowSetters = true)
    @Column(nullable = false)
    private Set<PetType> pettype = new HashSet<>();

    public PetType() {
    }

    /**
     * Given the name, create a new role object. User gets added later
     *
     * @param name the name of the role in uppercase
     */
    public Pet(String name)
    {
        this.name = name.toUpperCase();
    }
}
