package com.kibbles.app.services;

import com.kibbles.app.models.Pet;
import com.kibbles.app.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "petService")
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petrepos;

    @Override
    public List<Pet> findAll() {
        List<Pet> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        petrepos.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Pet findPetById(long id) {
        return petrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Pet id " + id + " not found!"));
    }

    @Override
    public Pet save(Pet pet) {
        if (pet.getUser()
            .size() > 0) {
            throw new EntityExistsException("Pet already exists.");
        }

        return petrepos.save(pet);
    }

    @Transactional
    @Override
    public void delete(long id) {

        if (petrepos.findById(id)
            .isPresent()) {
            petrepos.deleteById(id);

        } else {
            throw new EntityNotFoundException("Pet id " + id + " not found!");
        }
    }

    @Override
    public void deleteAll() {
        petrepos.deleteAll();
    }
}
