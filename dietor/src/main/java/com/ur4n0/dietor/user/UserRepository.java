package com.ur4n0.dietor.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}