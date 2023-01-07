package com.ur4n0.dietor.user;

import java.util.List;

import com.ur4n0.dietor.dto.CreateUserRequest;
import com.ur4n0.dietor.dto.UpdateUserRequest;
import com.ur4n0.dietor.feed.Feed;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "userApi")
@Getter @Setter @RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "age", nullable = false)
    private int age;

    @OneToMany(mappedBy = "user")
    private List<Feed> feeds;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "goal")
    private ObjectivEnum goal;

    public enum ObjectivEnum {
        LOSE, GAIN
    }

    public User(CreateUserRequest user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.age = user.getAge();
    }

    public User(UpdateUserRequest user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.age = user.getAge();
        this.feeds = user.getFeeds();
        this.goal = user.getGoal();
    }    

    
}
