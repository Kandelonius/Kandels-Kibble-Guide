package com.kibbles.app.services;

import com.kibbles.app.models.Pet;
import com.kibbles.app.models.User;
import com.kibbles.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userrepos;

    @Autowired
    PetService petService;

    public User findUserById(long id) throws
                                      EntityNotFoundException {
        return userrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User id " + id + " not found!"));
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userrepos.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public User save(User user) {
        User newUser = new User();

        if (user.getUserid() != 0) {
            userrepos.findById(user.getUserid())
                .orElseThrow(() -> new EntityNotFoundException("User id " + user.getUserid() + " not found!"));
            newUser.setUserid(user.getUserid());
        }

        newUser.setUsername(user.getUsername()
            .toLowerCase());
        newUser.setPassword(user.getPassword());
        newUser.setPrimaryemail(user.getPrimaryemail()
            .toLowerCase());


        newUser.getUserpet()
            .clear();
        for (Pet p : user.getUserpet()) {

            //            Pet addPet = petService.findPetById(p.getPetid());

            newUser.getUserpet()
                .add(new Pet(newUser,
                    p.getName()));
        }

        return userrepos.save(newUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User id " + id + " not found!"));
        userrepos.deleteById(id);
    }

    @Override
    public User update(
        User user,
        long id) {
        User currentUser = findUserById(id);

        if (user.getUsername() != null) {
            currentUser.setUsername(user.getUsername()
                .toLowerCase());
        }

        if (user.getPassword() != null) {
            currentUser.setPassword(user.getPassword());
        }

        if (user.getPrimaryemail() != null) {
            currentUser.setPrimaryemail(user.getPrimaryemail()
                .toLowerCase());
        }

        if (user.getUserpet()
            .size() > 0) {

            currentUser.getUserpet()
                .clear();
            for (Pet p : user.getUserpet()) {
                currentUser.getUserpet()
                    .add(new Pet(currentUser,
                        p.getName()));
            }

        }

        return userrepos.save(currentUser);
    }

    @Override
    public List<User> findByNameContaining(String username) {
        return userrepos.findByUsernameContainingIgnoreCase(username.toLowerCase());
    }

    @Transactional
    @Override
    public void deleteAll() {
        userrepos.deleteAll();
    }

}
