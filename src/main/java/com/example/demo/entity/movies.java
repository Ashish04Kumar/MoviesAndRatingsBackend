package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class movies {
	
	    @Id
	 
	    private String tconst;
	    
	    @Column(name="titleType")
	    
	    private String titleType;
	    @Column(name="primaryTitle")
	    private String primaryTitle;
	    @Column(name="runtimeMinutes")
	    private Integer runtimeMinutes;
	    @Column(name="genres")
	    private String genres;

	    @OneToOne(mappedBy="movies",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private ratings ratings;

		public String getTconst() {
			return tconst;
		}

		public void setTconst(String tconst) {
			this.tconst = tconst;
		}

		public String getTitleType() {
			return titleType;
		}

		public void setTitleType(String titleType) {
			this.titleType = titleType;
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

		public ratings getRatings() {
			return ratings;
		}

		public void setRatings(ratings ratings) {
			this.ratings = ratings;
		}

		public movies(String tconst, String titleType, String primaryTitle, Integer runtimeMinutes, String genres,
				com.example.demo.entity.ratings ratings) {
			super();
			this.tconst = tconst;
			this.titleType = titleType;
			this.primaryTitle = primaryTitle;
			this.runtimeMinutes = runtimeMinutes;
			this.genres = genres;
			this.ratings = ratings;
		}

		public movies() {}

		public movies(String tconst, String titleType, String primaryTitle, Integer runtimeMinutes, String genres)
		{
			super();
			this.tconst = tconst;
			this.titleType = titleType;
			this.primaryTitle = primaryTitle;
			this.runtimeMinutes = runtimeMinutes;
			this.genres = genres;
		}

}
