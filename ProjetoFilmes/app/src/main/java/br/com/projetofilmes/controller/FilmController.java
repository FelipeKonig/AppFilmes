package br.com.projetofilmes.controller;

import java.util.ArrayList;

import br.com.projetofilmes.R;
import br.com.projetofilmes.model.Film;
import br.com.projetofilmes.model.Person;

public class FilmController {

    private static FilmController filmController;
    private ArrayList<Film> films = new ArrayList<>(  );

    public FilmController() { }

    public void addFilm(String title, String genre, String lance_date, Object actor, Object director){

        Film film = new Film( title, genre,lance_date, R.drawable.randomfilm, (Person)actor,(Person)director);

        filmController.getFilms().add( film );
    }

    public static FilmController getInstance() {
        if (filmController == null){
            filmController = new FilmController();
            filmController.addFilms();
        }
        return filmController;
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    private void addFilms(){
        PeopleController actor = PeopleController.getInstance("actor");
        PeopleController director = PeopleController.getInstance("director");

        Film film1 = new Film( "Machete", "Action","10-12-2010", R.drawable.machete,
                actor.getActors().get( 0 ), director.getDirectors().get( 0 ) );

        Film film2 = new Film( "Ponyo", "Animation","30-06-2010", R.drawable.ponyo,
                actor.getActors().get( 1 ), director.getDirectors().get( 1 ) );

        Film film3 = new Film( "Casanova", "Adventure","06-01-2006", R.drawable.casanova,
                actor.getActors().get( 2 ), director.getDirectors().get( 2 ) );

        films.add( film1 );
        films.add( film2 );
        films.add( film3 );
    }
}
