package com.example.demo.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.OnlyMovieDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.MovieRepository;


@Service
public class MovieService {
	    @Autowired
	    private MovieRepository movieRepository;
	   
	    
	    public List<OnlyMovieDTO> getIntegerestDurationMovies(int limit) {
	        List<movies> IntegerestMovies = movieRepository.findTop10ByOrderByRuntimeMinutesDesc();
	        List<OnlyMovieDTO> moviesDTO = new ArrayList<>();
	        for (movies movie : IntegerestMovies) {
	            OnlyMovieDTO movieDTO = new OnlyMovieDTO();
	            movieDTO.setTconst(movie.getTconst());
	            movieDTO.setPrimaryTitle(movie.getPrimaryTitle());
	            movieDTO.setRuntimeMinutes(movie.getRuntimeMinutes());
	            movieDTO.setGenres(movie.getGenres());
	            moviesDTO.add(movieDTO);
	        }
	        return moviesDTO;
	        
}
	    

	    public movies createNewMovieWithRating(MovieDTO moviesDTO) {
	       movies movie = new movies();
	       movie.setTconst(moviesDTO.getTconst());
	       movie.setTitleType(moviesDTO.getTitleType());
	        movie.setPrimaryTitle(moviesDTO.getPrimaryTitle());
	        movie.setRuntimeMinutes(moviesDTO.getRuntimeMinutes());
	        movie.setGenres(moviesDTO.getGenres());

	        ratings rating = new ratings();
	        rating.setTconst(moviesDTO.getTconst());
	        rating.setAverageRating(moviesDTO.getAverageRating());
	        rating.setNumVotes(moviesDTO.getNumVotes());

	        movie.setRatings(rating);

	        return movieRepository.save(movie);
	    }
	    
	    
	    
	    public List<MovieDTO> getTopRatedMovies() {
	        List<movies> moviess = movieRepository.findByRatingsAverageRatingGreaterThan(6.0);
	        List<MovieDTO> dtos = new ArrayList<>();
	        for (movies movie : moviess) {
	            dtos.add(new MovieDTO(movie.getTconst(),movie.getTitleType(),movie.getPrimaryTitle(),movie.getRuntimeMinutes(),movie.getGenres(), movie.getRatings().getAverageRating(),movie.getRatings().getNumVotes()));
	        }
	        Collections.sort(dtos, Comparator.comparingDouble(MovieDTO::getAverageRating).reversed());
	        return dtos;
	    }
	   
	    
}
