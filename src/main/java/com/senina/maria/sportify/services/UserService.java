package com.senina.maria.sportify.services;

import com.senina.maria.sportify.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmailAndPassword(String email, String password);
}
