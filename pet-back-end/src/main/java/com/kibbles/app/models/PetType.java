package com.kibbles.app.models;

import javax.persistence.*;

@Entity
@Table(name = "types")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long typeid;

}
