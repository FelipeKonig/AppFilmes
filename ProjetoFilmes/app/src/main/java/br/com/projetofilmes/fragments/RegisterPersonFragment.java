package br.com.projetofilmes.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import br.com.projetofilmes.R;
import br.com.projetofilmes.controller.PeopleController;

public class RegisterPersonFragment extends Fragment {
    private FragmentTransaction fragmentTransaction;

    private String type;

    private EditText name, birth_day;

    public RegisterPersonFragment(String type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.person_register,container,false );

        name = view.findViewById( R.id.name );
        birth_day = view.findViewById( R.id.birth_day );
        Button register = view.findViewById( R.id.bt_register );
        ImageView photo = view.findViewById( R.id.photo );

        if (type.contentEquals( "director" ))
            photo.setImageResource( R.drawable.randomdirector );

        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || birth_day.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText( getActivity(), "name or date of birth are empty", Toast.LENGTH_SHORT );
                    toast.show();
                }else {
                    PeopleController peopleController = new PeopleController();
                    PeopleController.getInstance(type);
                    if (type.contentEquals( "actor" )){
                        peopleController.addPerson( name.getText().toString(),birth_day.getText().toString(),"actor" );
                    } else{
                        peopleController.addPerson( name.getText().toString(),birth_day.getText().toString(),"director" );
                    }
                    assert getFragmentManager() != null;
                    fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container_fragment, new PeopleFragment( type));
                    fragmentTransaction.commit();
                }
            }
        } );
        return view;
    }
}
