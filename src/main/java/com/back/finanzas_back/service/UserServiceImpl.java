package com.back.finanzas_back.service;

import com.back.finanzas_back.domain.model.entity.User;
import com.back.finanzas_back.domain.persistence.UserRepository;
import com.back.finanzas_back.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Integer id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> validation(String email, String password) {
        if (userRepository.findByEmailAndPassword(email,password).isPresent()) {
            return userRepository.findByEmailAndPassword(email,password);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
