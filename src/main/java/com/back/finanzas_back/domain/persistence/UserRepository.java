package com.back.finanzas_back.domain.persistence;

import com.back.finanzas_back.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
//    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
//    Optional<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
