package application;

public class Movie {
	
	private String title;
	private String description;
	private int year;
	private double rating;
	
	public Movie(String title, String description, int year, double rating) {
		super();
		this.title = title;
		this.description = description;
		this.year = year;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	

}
