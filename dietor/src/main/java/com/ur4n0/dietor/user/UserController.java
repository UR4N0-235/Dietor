package com.ur4n0.dietor.user;

import java.lang.reflect.Field;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ur4n0.dietor.dto.CreateUserRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("singUp")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest) {
        if (userService.findByEmail(createUserRequest.getEmail()).isPresent()) {
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
        if(hasMissingFieldCheck(createUserRequest)) {
            return new ResponseEntity<>("Missing attributes !", HttpStatus.BAD_REQUEST);
        }

        User userCreated = userService.create(createUserRequest);
        return new ResponseEntity<>("created user with id " + userCreated.getId(), HttpStatus.CREATED);
    }

    public boolean hasMissingFieldCheck(CreateUserRequest createUserRequest){
        try{
            Field[] fields = CreateUserRequest.class.getFields();
            for(Field field : fields){
                Object value = field.get(createUserRequest);
                if(value == null){
                    return true; // if has missing field
                }
            }
        }catch(IllegalArgumentException|IllegalAccessException error){
            error.printStackTrace();
        }
        return false; // if don't
    }
}
