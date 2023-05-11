package com.example.demo.dto;

public class MovieDTO {
	private String tconst;
	private String titleType;
	private String primaryTitle;
    private Integer runtimeMinutes;
    private String genres;
    
    private double averageRating;
    private Integer numVotes;
    
    
    public String getTitleType() {
		return titleType;
	}
	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}
	
	public String getTconst() {
		return tconst;
	}
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}
	public String getPrimaryTitle() {
		return primaryTitle;
	}
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}
	public Integer getRuntimeMinutes() {
		return runtimeMinutes;
	}
	public void setRuntimeMinutes(Integer runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
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
	public MovieDTO(String tconst, String titleType, String primaryTitle, Integer runtimeMinutes, String genres,
			double averageRating, Integer numVotes) {
		super();
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
		this.averageRating = averageRating;
		this.numVotes = numVotes;
	}
	public MovieDTO() {}
    
}
