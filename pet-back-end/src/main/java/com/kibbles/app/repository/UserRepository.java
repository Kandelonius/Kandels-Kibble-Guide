package com.kibbles.app.repository;

import com.kibbles.app.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
    extends CrudRepository<User, Long>{


}
