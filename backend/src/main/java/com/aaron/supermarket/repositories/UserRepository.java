package com.aaron.supermarket.repositories;

import com.aaron.supermarket.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
