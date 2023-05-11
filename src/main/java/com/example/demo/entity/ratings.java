package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class ratings {
	
	@Id
	private String tconst;
	
	@Column(name="averageRating")
	private double averageRating;
	
	@Column(name="numVotes")
	private Integer numVotes;
	
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tconst")
    private movies movies;



	public String getTconst() {
		return tconst;
	}



	public void setTconst(String tconst) {
		this.tconst = tconst;
	}



	public double getAverageRating() {
		return averageRating;
	}



	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}



	public Integer getNumVotes() {
		return numVotes;
	}



	public void setNumVotes(Integer numVotes) {
		this.numVotes = numVotes;
	}



	public movies getMovies() {
		return movies;
	}



	public void setMovies(movies movies) {
		this.movies = movies;
	}



	public ratings(String tconst, double averageRating, Integer numVotes, com.example.demo.entity.movies movies) {
		super();
		this.tconst = tconst;
		this.averageRating = averageRating;
		this.numVotes = numVotes;
		this.movies = movies;
	}
	public ratings()
	{}
	
}
