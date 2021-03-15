package com.kibbles.app.services;

import com.kibbles.app.models.Pet;
import com.kibbles.app.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PetServiceImpl implements PetService{

    @Autowired
    PetRepository petrepos;

    @Override
    public List<Pet> findAll() {
        return null;
    }

    @Override
    public Pet findPetById(long id) {
        return null;
    }

    @Override
    public Pet save(Pet pet) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void deleteAll() {

    }
}
