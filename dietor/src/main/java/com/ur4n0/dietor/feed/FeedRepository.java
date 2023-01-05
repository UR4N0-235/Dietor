package com.ur4n0.dietor.feed;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
public interface FeedRepository extends JpaRepository<Feed, Long> {
    
}
