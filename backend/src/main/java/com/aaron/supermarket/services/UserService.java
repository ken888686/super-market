package com.aaron.supermarket.services;

import com.aaron.supermarket.models.User;
import com.aaron.supermarket.repositories.UserRepository;
import org.hibernate.DuplicateMappingException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User create(User user) throws DuplicateMappingException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateMappingException(DuplicateMappingException.Type.COLUMN, user.getEmail());
        }
        var now = Timestamp.valueOf(LocalDateTime.now());
        user.setCreateTime(now);
        user.setUpdateTime(now);
        return userRepository.save(user);
    }

    public void test() {
        userRepository.findAll();
    }
}
