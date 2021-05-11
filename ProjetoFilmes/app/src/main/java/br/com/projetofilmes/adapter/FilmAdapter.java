package br.com.projetofilmes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.projetofilmes.R;
import br.com.projetofilmes.controller.FilmController;
import br.com.projetofilmes.model.Film;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {

    private FilmController filmController;

    public FilmAdapter() {
        this.filmController = FilmController.getInstance();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, genre, director, actor, realese_year;
        ImageView cover;

        MyViewHolder(@NonNull View itemView) {
            super( itemView );

            title = itemView.findViewById( R.id.title );
            genre = itemView.findViewById( R.id.genre );
            director = itemView.findViewById( R.id.director );
            actor = itemView.findViewById( R.id.actor);
            realese_year = itemView.findViewById( R.id.release_year);
            cover = itemView.findViewById( R.id.cover );
        }
    }

    @NonNull
    @Override
    public FilmAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_row_recycler, parent, false);
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.MyViewHolder holder, int position) {
        Film film = filmController.getFilms().get( position );

        holder.title.setText( film.getTitle() );
        holder.genre.setText( film.getGenre() );
        holder.director.setText( film.getDirector().getName());
        holder.actor.setText( film.getActor().getName());
        holder.realese_year.setText( film.getRelease_year());
        holder.cover.setImageResource( film.getImage() );
    }

    @Override
    public int getItemCount() {
        return filmController.getFilms().size();
    }
}
