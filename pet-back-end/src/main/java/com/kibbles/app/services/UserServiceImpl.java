package com.kibbles.app.services;

import com.kibbles.app.models.User;
import com.kibbles.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userrepos;

    public User findUserById(long id) throws
                                      EntityNotFoundException
    {
        return userrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User id " + id + " not found!"));
    }

}
