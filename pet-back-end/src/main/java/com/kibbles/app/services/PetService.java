package com.kibbles.app.services;

import com.kibbles.app.models.Pet;

import java.util.List;

public interface PetService {

    List<Pet> findAll();

    Pet findPetById(long id);

    Pet save(long userid, String petname);

    void delete(long id);

    void deleteAll();
}
