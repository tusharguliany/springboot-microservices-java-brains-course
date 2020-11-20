package com.guliany.movies.models;

public class Movie {

	private String id;
	private String name;
	private String overview;

	public Movie() {
		super();
	}

	public Movie(String id, String name, String overview) {
		super();
		this.id = id;
		this.name = name;
		this.overview = overview;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + " overview=" + overview + "]";
	}

}
