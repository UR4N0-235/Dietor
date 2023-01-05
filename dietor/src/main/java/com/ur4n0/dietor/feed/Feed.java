package com.ur4n0.dietor.feed;

import java.util.Date;
import java.util.List;

import com.ur4n0.dietor.food.Food;
import com.ur4n0.dietor.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "feed")
@Getter @Setter @RequiredArgsConstructor
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "time", columnDefinition = "TEXT")
    private Date time;

    @ManyToMany
    @JoinTable(
        name = "eat", 
        joinColumns = @JoinColumn(name = "fk_feed_id"), 
        inverseJoinColumns = @JoinColumn(name = "fk_food_id"))
    List<Food> foods;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
