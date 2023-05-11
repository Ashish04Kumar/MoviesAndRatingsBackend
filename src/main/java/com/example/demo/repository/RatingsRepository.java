package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.ratings;

public interface RatingsRepository extends JpaRepository<ratings, String>  {

}
