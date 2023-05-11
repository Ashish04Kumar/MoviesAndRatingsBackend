package com.example.demo.repository;
//+
//"ORDER BY genres")
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.movies;


public interface MovieRepository extends JpaRepository<movies, String> {
    
    List<movies> findTop10ByOrderByRuntimeMinutesDesc();
    
    List<movies> findByRatingsAverageRatingGreaterThan(double rating);

}
