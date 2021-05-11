package br.com.projetofilmes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.projetofilmes.R;
import br.com.projetofilmes.adapter.PeopleAdapter;

public class PeopleFragment extends Fragment {
    private FilmFragment.onFragmentBtnSelected listener;

    private String type;

    public PeopleFragment(String type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.recycler_main,container,false );

        RecyclerView recyclerView = view.findViewById( R.id.recyclerView );
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        PeopleAdapter peopleAdapter;
        if (type.contentEquals( "actor" )){
            peopleAdapter = new PeopleAdapter( "actor");
        }else{
            peopleAdapter = new PeopleAdapter( "director" );
        }

        Button addPerson = view.findViewById( R.id.addItem );
        addPerson.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.contentEquals( "actor" )){
                    listener.onButtonSelected("actor");
                }else{
                    listener.onButtonSelected("director");
                }
            }
        } );
        recyclerView.setAdapter( peopleAdapter );

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach( context );

        if (context instanceof FilmFragment.onFragmentBtnSelected){
            listener = (FilmFragment.onFragmentBtnSelected) context;
        }else{
            throw new ClassCastException(context.toString() + "must implement listener");
        }
    }
}
