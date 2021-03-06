package com.kibbles.app.controllers;

import com.kibbles.app.models.Pet;
import com.kibbles.app.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping(value = "/all",
        produces = "application/json")
    public ResponseEntity<?> listAllPets() {
        List<Pet> allPets = petService.findAll();
        return new ResponseEntity<>(allPets,
            HttpStatus.OK);
    }

    @GetMapping(value = "/pet/{petid}",
        produces = "application/json")
    public ResponseEntity<?> getPetById(
        @PathVariable
            long petid) {
        Pet p = petService.findPetById(petid);
        return new ResponseEntity<>(p,
            HttpStatus.OK);
    }

}
