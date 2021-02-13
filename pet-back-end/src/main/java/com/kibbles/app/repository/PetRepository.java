package com.kibbles.app.repository;

import com.kibbles.app.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository
    extends CrudRepository<Pet, Long> {

}
