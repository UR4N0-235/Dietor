package com.ur4n0.dietor.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ur4n0.dietor.dto.CreateUserRequest;
import com.ur4n0.dietor.dto.UpdateUserRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    public Optional<User> findById(Long id) { 
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) { 
        return userRepository.findByEmail(email);
    }

    public User create(CreateUserRequest newUserRequest){
        User user = new User(newUserRequest);
        return userRepository.save(user);
    }
    
    public User update(UpdateUserRequest updateUserRequest){
        User user = new User(updateUserRequest);
        return userRepository.save(user);
    }

    public List<User> all(){
        return userRepository.findAll();
    }
    
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
