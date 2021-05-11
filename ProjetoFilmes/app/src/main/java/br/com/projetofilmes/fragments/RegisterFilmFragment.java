package br.com.projetofilmes.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

import br.com.projetofilmes.R;
import br.com.projetofilmes.controller.FilmController;
import br.com.projetofilmes.controller.PeopleController;
import br.com.projetofilmes.model.Person;

public class RegisterFilmFragment extends Fragment {
    private FragmentTransaction fragmentTransaction;

    private EditText title, genre, year;
    private Spinner list_actors, list_directors;

    public RegisterFilmFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.film_register,container,false );

        title = view.findViewById( R.id.title );
        genre = view.findViewById( R.id.genre );
        year = view.findViewById( R.id.year );
        list_actors = view.findViewById( R.id.list_actors );
        list_directors = view.findViewById( R.id.list_directors);
        Button register = view.findViewById( R.id.register );

        ArrayAdapter<Person> list_actors_adapter = new ArrayAdapter<>( Objects.requireNonNull( getActivity() ),
                android.R.layout.simple_spinner_dropdown_item );
        PeopleController peopleController = PeopleController.getInstance( "actor" );
        list_actors_adapter.addAll( peopleController.getActors() );

        ArrayAdapter<Person> list_directors_adapter = new ArrayAdapter<>( getActivity(), android.R.layout.simple_spinner_dropdown_item );
        PeopleController.getInstance("director");
        list_directors_adapter.addAll( peopleController.getDirectors() );

        list_actors.setAdapter( list_actors_adapter );
        list_directors.setAdapter( list_directors_adapter );

        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().isEmpty() || genre.getText().toString().isEmpty() || year.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText( getActivity(), "fill in all items", Toast.LENGTH_SHORT );
                    toast.show();
                }else {
                    FilmController filmController = new FilmController();
                    FilmController.getInstance();
                    filmController.addFilm( title.getText().toString(),genre.getText().toString(), year.getText().toString(),
                            list_actors.getSelectedItem(), list_directors.getSelectedItem());

                    assert getFragmentManager() != null;
                    fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container_fragment, new FilmFragment());
                    fragmentTransaction.commit();
                }
            }
        } );
        return view;
    }
}
