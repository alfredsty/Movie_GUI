package sungil.mymovie2;

import static sungil.mymovie2.MovieActivity.MOVIE_ID_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieRecViewAdapter
		extends RecyclerView.Adapter<MovieRecViewAdapter.ViewHolder> {
	private static final String TAG = "MovieRecViewAdapter";

	private ArrayList<Movie> movies = new ArrayList<>();

	private Context mContext;

	private String parentActivity;

	public MovieRecViewAdapter(Context mContext, String parentActivity) {
		this.mContext = mContext;
		this.parentActivity = parentActivity;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_list_item, parent, false);
		ViewHolder holder = new ViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
		holder.movieImg.setImageResource(movies.get(position).getMovie_img());
		holder.movieTitle.setText(movies.get(position).getMovie_title());
		holder.movieScore.setText(Double.toString(movies.get(position).getMovie_score()));

		holder.parent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, MovieActivity.class);
				intent.putExtra(MOVIE_ID_KEY, movies.get(position).getMovie_id());
				mContext.startActivity(intent);
			}
		});
	}

	@Override
	public int getItemCount() {
		return movies.size();
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
		notifyDataSetChanged();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		private CardView parent;
		private ImageView movieImg;
		private TextView movieTitle, movieScore;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			parent = itemView.findViewById(R.id.parent);
			movieImg = itemView.findViewById(R.id.movieImg);
			movieTitle = itemView.findViewById(R.id.movieTitle);
			movieScore = itemView.findViewById(R.id.movieScore);
		}
	}
}
