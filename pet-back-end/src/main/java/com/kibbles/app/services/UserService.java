package com.kibbles.app.services;

import com.kibbles.app.models.User;

import java.util.List;

public interface UserService {

    User findUserById(long id);

    List<User> findByNameContaining(String username);

    void delete(long id);

    User update(User user, long id);

    public void deleteAll();

}
