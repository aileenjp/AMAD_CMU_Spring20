package com.example.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private List<Movie> mMovieList;
    private Context mContext;

    public MyListAdapter(List<Movie> mMovieList, Context mContext) {
        this.mMovieList = mMovieList;
        this.mContext = mContext;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        TextView mTextView2;
        ImageView mImageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.card_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);
        holder.mTextView.setText(movie.getTitle());
        holder.mTextView2.setText("Rating: " + movie.getRating());
        Picasso.get().load(movie.getPosterURL())
                .error(R.drawable.image_placeholder)
                .placeholder(R.drawable.image_placeholder)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }
}
