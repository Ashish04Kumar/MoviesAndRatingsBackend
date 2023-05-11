package com.example.demo.dto;

import java.math.BigDecimal;

public class GenreMoviesSubtotalsResponse {
	private String genre;
    private String primaryTitle;
    private  BigDecimal numVotes;
    
    
 

	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPrimaryTitle() {
		return primaryTitle;
	}
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}
	public BigDecimal getNumVotes() {
		return numVotes;
	}
	public void setNumVotes(BigDecimal numVotes) {
		this.numVotes = numVotes;
	}
	public GenreMoviesSubtotalsResponse(String genre, String primaryTitle, BigDecimal numVotes) {
		super();
		this.genre = genre;
		this.primaryTitle = primaryTitle;
		this.numVotes = numVotes;
	}
    
	public GenreMoviesSubtotalsResponse()
	{
		
	}
    
}
