package com.ur4n0.dietor.user;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}