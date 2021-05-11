package br.com.projetofilmes.model;

public class Film {

    private String title,genre, release_year;
    private int image;
    private Person director, actor;

    public Film(String title, String genre, String lance_date, int image, Person director, Person actor) {
        this.title = title;
        this.genre = genre;
        this.release_year = lance_date;
        this.image = image;
        this.director = director;
        this.actor = actor;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getRelease_year() {
        return release_year;
    }

    public int getImage() {
        return image;
    }

    public Person getDirector() {
        return director;
    }

    public Person getActor() {
        return actor;
    }
}
