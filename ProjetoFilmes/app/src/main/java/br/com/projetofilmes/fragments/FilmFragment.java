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
import br.com.projetofilmes.adapter.FilmAdapter;

public class FilmFragment extends Fragment {
    private onFragmentBtnSelected listener;

    public FilmFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.recycler_main,container,false );

        RecyclerView recyclerView = view.findViewById( R.id.recyclerView );
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        FilmAdapter filmAdapter = new FilmAdapter();

        Button addFilm = view.findViewById( R.id.addItem );
        addFilm.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelected("film");
            }
        } );
        recyclerView.setAdapter( filmAdapter );
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach( context );

        if (context instanceof onFragmentBtnSelected){
            listener = (onFragmentBtnSelected) context;
        }else{
            throw new ClassCastException(context.toString() + "must implement listener");
        }
    }

    public interface onFragmentBtnSelected{
        void onButtonSelected(String item);
    }
}
