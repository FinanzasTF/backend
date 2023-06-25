package com.back.finanzas_back.domain.service;


import com.back.finanzas_back.domain.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    Optional<User> getById(Integer id);
    User save(User user);
    User update(User user);
    boolean deleteById(Integer id);
    Optional<User> validation(String email, String password);
}