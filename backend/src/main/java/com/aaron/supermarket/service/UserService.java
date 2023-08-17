package com.aaron.supermarket.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.DuplicateMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaron.supermarket.models.User;
import com.aaron.supermarket.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
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
}
