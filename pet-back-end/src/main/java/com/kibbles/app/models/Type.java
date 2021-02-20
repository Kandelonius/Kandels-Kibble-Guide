package com.kibbles.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "types")
public class Type {

    /**
     * The primary key (long) of the types table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long typeid;

    /**
     * The name (String) of the type. Cannot be null and must be unique. (cat or dog)
     */
    @Column(nullable = false,
        unique = true)
    private String name;

    /**
     * Part of the join relationship between pet and type
     * connects roles to the user role combination
     */
    @OneToMany(mappedBy = "type",
        cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "type",
        allowSetters = true)
    private Set<PetType> users = new HashSet<>();

    public Type() {
    }
}
