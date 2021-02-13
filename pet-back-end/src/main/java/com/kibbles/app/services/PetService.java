package com.kibbles.app.services;

import com.kibbles.app.models.Pet;

public interface PetService {

    Pet save(Pet pet);

    void delete(long id);

    public void deleteAll();
}
