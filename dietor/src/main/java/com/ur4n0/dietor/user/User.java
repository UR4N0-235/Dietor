package com.ur4n0.dietor.user;

import java.util.List;

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
}
