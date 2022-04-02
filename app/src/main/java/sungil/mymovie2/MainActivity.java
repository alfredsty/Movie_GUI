package sungil.mymovie2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import sungil.mymovie2.AllMovieActivity;
import sungil.mymovie2.CurrentMovieActivity;
import sungil.mymovie2.FavoriteMovieActivity;
import sungil.mymovie2.R;

public class MainActivity
		extends AppCompatActivity
		implements View.OnClickListener
{
	Button all_movie, current_movie, favorite_movie,
			wish_movie, recommend_movie, btn_sidg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		all_movie = findViewById(R.id.all_movie);
		current_movie = findViewById(R.id.current_movie);
		favorite_movie = findViewById(R.id.favorite_movie);
		wish_movie = findViewById(R.id.wish_movie);
		recommend_movie = findViewById(R.id.recommend_movie);
		btn_sidg = findViewById(R.id.btn_sidg);

		all_movie.setOnClickListener(this);
		current_movie.setOnClickListener(this);
		favorite_movie.setOnClickListener(this);
		wish_movie.setOnClickListener(this);
		recommend_movie.setOnClickListener(this);
		btn_sidg.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.all_movie:
				Intent intent1 = new Intent(MainActivity.this, AllMovieActivity.class);
				startActivity(intent1);
				break;
			case R.id.current_movie:
				Intent intent2 = new Intent(MainActivity.this, CurrentMovieActivity.class);
				startActivity(intent2);
				break;
			case R.id.favorite_movie:
				Intent intent3 = new Intent(MainActivity.this, FavoriteMovieActivity.class);
				startActivity(intent3);
				break;
			case R.id.wish_movie:
				Intent intent4 = new Intent(MainActivity.this, sungil.mymovie2.WishMovieActivity.class);
				startActivity(intent4);
				break;
			case R.id.recommend_movie:
				Intent intent5 = new Intent(MainActivity.this, sungil.mymovie2.RecommendMovieActivity.class);
				startActivity(intent5);
				break;
			case R.id.btn_sidg:
				Intent intent6 = new Intent(MainActivity.this, sungil.mymovie2.WebviewActivity.class);
				intent6.putExtra("url", "https://m.naver.com");
				startActivity(intent6);
				break;
		}
	}
}