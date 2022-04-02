package sungil.mymovie2;

import java.util.ArrayList;

public class Utils {
	private static Utils instance;

	private static ArrayList<Movie> allMovies;
	private static ArrayList<Movie> currentMovies;
	private static ArrayList<Movie> favoriteMovies;
	private static ArrayList<Movie> wishMovies;
	private static ArrayList<Movie> recommendMovies;

	private Utils() {
		if (null == allMovies) {
			allMovies = new ArrayList<>();
			initData();
		}
		if (null == currentMovies) {
			currentMovies = new ArrayList<>();
			initData();
		}
		if (null == favoriteMovies) {
			favoriteMovies = new ArrayList<>();
			initData();
		}
		if (null == wishMovies) {
			wishMovies = new ArrayList<>();
			initData();
		}
		if (null == recommendMovies) {
			recommendMovies = new ArrayList<>();
			initData();
		}
	}

	private void initData() {
		allMovies.add(new Movie(1, R.drawable.movie01, "스파이더맨: 노 웨이 홈", 9.02));
		allMovies.add(new Movie(2, R.drawable.movie02, "킹스맨: 퍼스트 에이전트", 8.19));
		allMovies.add(new Movie(3, R.drawable.movie03, "해피 뉴 이어", 7.56));
		allMovies.add(new Movie(4, R.drawable.movie04, "드라이브 마이 카", 8.84));
		allMovies.add(new Movie(5, R.drawable.movie05, "꽁치의 맛", 8.64));
		allMovies.add(new Movie(6, R.drawable.movie06, "카페 뤼미에르", 7.24));
		allMovies.add(new Movie(7, R.drawable.movie07, "램", 6.56));
		allMovies.add(new Movie(8, R.drawable.movie08, "매트릭스: 리저렉션", 5.62));
		allMovies.add(new Movie(9, R.drawable.movie09, "너에게 가는 길", 9.27));
		allMovies.add(new Movie(10, R.drawable.movie10, "가을 햇살", 7.61));
	}

	public static ArrayList<Movie> getAllMovies() {
		return allMovies;
	}

	public static void setAllMovies(ArrayList<Movie> allMovies) {
		Utils.allMovies = allMovies;
	}

	public static ArrayList<Movie> getCurrentMovies() {
		return currentMovies;
	}

	public static void setCurrentMovies(ArrayList<Movie> currentMovies) {
		Utils.currentMovies = currentMovies;
	}

	public static ArrayList<Movie> getFavoriteMovies() {
		return favoriteMovies;
	}

	public static void setFavoriteMovies(ArrayList<Movie> favoriteMovies) {
		Utils.favoriteMovies = favoriteMovies;
	}

	public static ArrayList<Movie> getWishMovies() {
		return wishMovies;
	}

	public static void setWishMovies(ArrayList<Movie> wishMovies) {
		Utils.wishMovies = wishMovies;
	}

	public static ArrayList<Movie> getRecommendMovies() {
		return recommendMovies;
	}

	public static void setRecommendMovies(ArrayList<Movie> recommendMovies) {
		Utils.recommendMovies = recommendMovies;
	}

	public static Utils getInstance() {
		if (null != instance) {
			return instance;
		} else {
			instance = new Utils();
			return instance;
		}
	}

	public Movie getMovieById(int id) {
		for(Movie m : allMovies) {
			if(m.getMovie_id() == id) {
				return m;
			}
		}
		return null;
	}

	public boolean addToCurrentMovies(Movie movie) {
		return currentMovies.add(movie);
	}
	public boolean addToFavoriteMovies(Movie movie) {
		return favoriteMovies.add(movie);
	}
	public boolean addToWishMovies(Movie movie) {
		return wishMovies.add(movie);
	}
	public boolean addToRecommendMovies(Movie movie) {
		return recommendMovies.add(movie);
	}
	public boolean removeFromCurrentMovies(Movie movie) {
		return currentMovies.remove(movie);
	}
	public boolean removeFromFavoriteMovies(Movie movie) {
		return favoriteMovies.remove(movie);
	}
	public boolean removeFromWishMovies(Movie movie) {
		return wishMovies.remove(movie);
	}
	public boolean removeFromRecommendMovies(Movie movie) {
		return recommendMovies.remove(movie);
	}
}
