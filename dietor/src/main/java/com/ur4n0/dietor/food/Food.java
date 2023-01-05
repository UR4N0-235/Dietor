package com.ur4n0.dietor.food;

import java.util.List;

import com.ur4n0.dietor.feed.Feed;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food")
@Getter @Setter @RequiredArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
       
    @Column(name = "name", updatable = false)
    private String name;
    
    @Column(name = "proteins", updatable = false)
    private double proteins;

    @Column(name = "carbohydrates", updatable = false)
    private double carbohydrates;
    
    @Column(name = "fats", updatable = false)
    private double fats;

    @ManyToMany(mappedBy = "foods")
    List<Feed> feeds;
}
