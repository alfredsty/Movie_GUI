package sungil.mymovie2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {

	public static final String MOVIE_ID_KEY = "movie_id";

	private ImageView movieItemImg;
	private Button btnMovieItemCurrent;
	private Button btnMovieItemFavorite;
	private Button btnMovieItemWish;
	private Button btnMovieItemRecommend;
	private TextView txtMovieItemTitle;
	private TextView txtMovieItemScore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie);

		initViews();

		Intent intent = getIntent();
		if (null != intent) {
			int movie_id = intent.getIntExtra(MOVIE_ID_KEY, -1);
			if (movie_id != -1) {
				Movie nowMovie = Utils.getInstance().getMovieById(movie_id);
				if (null != nowMovie) {
					setData(nowMovie);

					checkCurrentMovie(nowMovie);
					checkFavoriteMovie(nowMovie);
					checkWishMovie(nowMovie);
					checkRecommendMovie(nowMovie);
				}
			}
		}
	}

	private void initViews() {
		movieItemImg = findViewById(R.id.movieItemImg);
		btnMovieItemCurrent = findViewById(R.id.btnMovieItemCurrent);
		btnMovieItemFavorite = findViewById(R.id.btnMovieItemFavorite);
		btnMovieItemWish = findViewById(R.id.btnMovieItemWish);
		btnMovieItemRecommend = findViewById(R.id.btnMovieItemRecommend);
		txtMovieItemTitle = findViewById(R.id.txtMovieItemTitle);
		txtMovieItemScore = findViewById(R.id.txtMovieItemScore);
	}

	private void setData(Movie movie) {
		movieItemImg.setImageResource(movie.getMovie_img());
		txtMovieItemTitle.setText(movie.getMovie_title());
		txtMovieItemScore.setText(Double.toString(movie.getMovie_score()));
	}

	private void checkCurrentMovie(final Movie movie) {
		ArrayList<Movie> currentMovies = Utils.getInstance().getCurrentMovies();

		boolean existInCurrentMovies = false;

		for (Movie m : currentMovies) {
			if (m.getMovie_id() == movie.getMovie_id()) {
				existInCurrentMovies = true;
			}
		}

		if (existInCurrentMovies) {
			btnMovieItemCurrent.setEnabled(false);
		} else {
			btnMovieItemCurrent.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (Utils.getInstance().addToCurrentMovies(movie)) {
						Toast.makeText(MovieActivity.this, "책이 추가되었습니다~!", Toast.LENGTH_SHORT).show();

						Intent intent = new Intent(MovieActivity.this, CurrentMovieActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(MovieActivity.this, "에러입니다..", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
	}

	private void checkFavoriteMovie(final Movie movie) {
		ArrayList<Movie> favoriteMovies = Utils.getInstance().getFavoriteMovies();

		boolean existInFavoriteMovies = false;

		for (Movie m : favoriteMovies) {
			if (m.getMovie_id() == movie.getMovie_id()) {
				existInFavoriteMovies = true;
			}
		}

		if (existInFavoriteMovies) {
			btnMovieItemFavorite.setEnabled(true);
		} else {
			btnMovieItemFavorite.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (Utils.getInstance().addToFavoriteMovies(movie)) {
						Toast.makeText(MovieActivity.this, "책이 추가되었습니다~!", Toast.LENGTH_SHORT).show();

						Intent intent = new Intent(MovieActivity.this, FavoriteMovieActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(MovieActivity.this, "에러입니다..", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
	}

	private void checkWishMovie(final Movie movie) {
		ArrayList<Movie> wishMovies = Utils.getInstance().getWishMovies();

		boolean existInWishMovies = false;

		for (Movie m : wishMovies) {
			if (m.getMovie_id() == movie.getMovie_id()) {
				existInWishMovies = true;
			}
		}

		if (existInWishMovies) {
			btnMovieItemWish.setEnabled(false);
		} else {
			btnMovieItemWish.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (Utils.getInstance().addToWishMovies(movie)) {
						Toast.makeText(MovieActivity.this, "책이 추가되었습니다~!", Toast.LENGTH_SHORT).show();

						Intent intent = new Intent(MovieActivity.this, WishMovieActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(MovieActivity.this, "에러입니다..", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
	}

	private void checkRecommendMovie(final Movie movie) {
		ArrayList<Movie> recommendMovies = Utils.getInstance().getRecommendMovies();

		boolean existInRecommendMovies = false;

		for (Movie m : recommendMovies) {
			if (m.getMovie_id() == movie.getMovie_id()) {
				existInRecommendMovies = true;
			}
		}

		if (existInRecommendMovies) {
			btnMovieItemRecommend.setEnabled(false);
		} else {
			btnMovieItemRecommend.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (Utils.getInstance().addToRecommendMovies(movie)) {
						Toast.makeText(MovieActivity.this, "책이 추가되었습니다~!", Toast.LENGTH_SHORT).show();

						Intent intent = new Intent(MovieActivity.this, RecommendMovieActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(MovieActivity.this, "에러입니다..", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
	}
}