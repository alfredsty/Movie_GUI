package sungil.mymovie2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllMovieActivity extends AppCompatActivity {

	private RecyclerView movieRecView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_movie);

		movieRecView = findViewById(R.id.movieRecView);

		sungil.mymovie2.MovieRecViewAdapter adapter = new sungil.mymovie2.MovieRecViewAdapter(this, "allMovies");

		movieRecView.setAdapter(adapter);
		movieRecView.setLayoutManager(new GridLayoutManager(this, 1));

		adapter.setMovies(Utils.getInstance().getAllMovies());
	}
}