package br.com.projetofilmes.controller;

import java.util.ArrayList;

import br.com.projetofilmes.R;
import br.com.projetofilmes.model.Person;

public class PeopleController {

    private static PeopleController peopleController;
    private ArrayList<Person> actors = new ArrayList<>();
    private ArrayList<Person> directors = new ArrayList<>();

    public PeopleController() { }

    public void addPerson(String name, String birth_date, String type){

        if (type.contentEquals( "actor" )){
            Person actor = new Person( name, birth_date, "actor", R.drawable.randomactor );
            peopleController.getActors().add( actor );
        }else{
            Person director = new Person( name, birth_date, "actor", R.drawable.randomdirector );
            peopleController.getDirectors().add( director );
        }
    }

    public static PeopleController getInstance(String type) {
        if (peopleController == null) {
            peopleController = new PeopleController();
        }
        if (type.contentEquals( "actor" )){
            if (peopleController.getActors().isEmpty())
                peopleController.addActors();
        }else{
            if (peopleController.getDirectors().isEmpty())
                peopleController.addDirectors();
        }
        return peopleController;
    }

    public ArrayList<Person> getActors() {
        return actors;
    }

    public ArrayList<Person> getDirectors() {
        return directors;
    }

    private void addDirectors(){
        Person director1 = new Person( "Robert Rodriguez", "10-12-1973", "director", R.drawable.robert );
        Person director2 = new Person( "Hayao Miyazaki", "21-04-1967", "director", R.drawable.hayao);
        Person director3 = new Person( "Lasse Hallström", "03-01-1984", "director", R.drawable.lasse);

        directors.add( director1);
        directors.add( director2);
        directors.add( director3);
    }

    private void addActors(){
        Person actor1 = new Person( "Danny Trejo", "14-04-1978", "actor", R.drawable.danny );
        Person actor2 = new Person( "Yuria Nara", "13-06-2004", "actor", R.drawable.nara);
        Person actor3 = new Person( "heath ledger", "24-08-1988", "actor", R.drawable.heath);

        actors.add( actor1);
        actors.add( actor2);
        actors.add( actor3);
    }
}
