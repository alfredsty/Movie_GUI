package sungil.mymovie2;

public class Movie {
	private int movie_id;
	private int movie_img;
	private String movie_title;
	private double movie_score;

	public Movie(int movie_id, int movie_img, String movie_title, double movie_score) {
		this.movie_id = movie_id;
		this.movie_img = movie_img;
		this.movie_title = movie_title;
		this.movie_score = movie_score;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getMovie_img() {
		return movie_img;
	}

	public void setMovie_img(int movie_img) {
		this.movie_img = movie_img;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public double getMovie_score() {
		return movie_score;
	}

	public void setMovie_score(double movie_score) {
		this.movie_score = movie_score;
	}

	@Override
	public String toString() {
		return "Movie{" +
				"movie_id=" + movie_id +
				", movie_img=" + movie_img +
				", movie_title='" + movie_title + '\'' +
				", movie_score=" + movie_score +
				'}';
	}
}
