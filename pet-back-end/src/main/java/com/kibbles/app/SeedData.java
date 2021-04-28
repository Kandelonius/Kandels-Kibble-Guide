package com.kibbles.app;

import com.kibbles.app.models.Pet;
import com.kibbles.app.models.User;
import com.kibbles.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Transactional
    @Override
    public void run(String[] args) throws Exception {
        userService.deleteAll();


        User u1 = new User(
            "John",
            "secure",
            "a@b.c"
        );

        userService.save(u1);

        Pet p1 = new Pet(u1,
            "Fluffy");

        u1.getUserpet()
            .add(p1);

        userService.update(u1, u1.getUserid());

    }
}
