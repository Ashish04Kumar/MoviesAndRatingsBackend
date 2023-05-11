package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.OnlyMovieDTO;
import com.example.demo.entity.movies;

import com.example.demo.service.MovieService;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class movieController {
	   
	   @Autowired
	    private MovieService movieService;
	   
	  
	   
	   @Autowired
	    private JdbcTemplate jdbcTemplate; 
	    
	    
	    @GetMapping("/longest-duration-movies")
	    public List<OnlyMovieDTO> getLongestDurationMovies() {
	        List<OnlyMovieDTO> movies = movieService.getIntegerestDurationMovies(10);
	        return movies;
	    }
	    
	    
	    @PostMapping("/new-movie")
	    public ResponseEntity<movies> createNewMovieWithRating(@RequestBody MovieDTO moviesDTO) {
	        movies movie = movieService.createNewMovieWithRating(moviesDTO);
	        return ResponseEntity.ok(movie);
	    }
	    
	    @GetMapping("/top-rated-movies")
	    public List<MovieDTO> getTopRatedMovies() {
	        return movieService.getTopRatedMovies();
	    }

	    
	    
	    @GetMapping("/genre-movies-with-subtotals")
	    public List<Object[]> getGenreMoviesWithSubtotals() {
	        String sql = "SELECT m.genres AS genre, m.primary_title AS primary_title, SUM(r.num_votes) AS num_votes " +
	                     "FROM movies m JOIN ratings r ON m.tconst = r.tconst " +
	                     "WHERE m.genres IS NOT NULL " +
	                     "GROUP BY m.genres, m.primary_title WITH ROLLUP";

	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
	        List<Object[]> results = new ArrayList<>();

	        for (Map<String, Object> row : rows) {
	            String genre = (String) row.get("genre");
	            String title = (String) row.get("primary_title");
	            BigDecimal numVotes = (BigDecimal) row.get("num_votes");

	            if (genre == null && title == null) {
	                results.add(new Object[] { "TOTAL", null, numVotes });
	            } else if (genre != null && title == null) {
	                results.add(new Object[] { genre, null, numVotes });
	            } else {
	                results.add(new Object[] { genre, title, numVotes });
	            }
	        }

	        return results;
	    }
	    
	    
	    @PostMapping("/update-runtime-minutes")
	    public ResponseEntity<String> updateRuntimeMinutes() {
	        String sql = "UPDATE movies SET runtime_minutes = "
	                + "CASE "
	                + "WHEN genres LIKE '%Documentary%' THEN runtime_minutes + 15 "
	                + "WHEN genres LIKE '%Animation%' THEN runtime_minutes + 30 "
	                + "ELSE runtime_minutes + 45 "
	                + "END";
	        int count = jdbcTemplate.update(sql);
	        String message = String.format("%d movies updated successfully", count);
	        return ResponseEntity.ok(message);
	    }
	    }
