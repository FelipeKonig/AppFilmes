package br.com.projetofilmes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.projetofilmes.R;
import br.com.projetofilmes.controller.PeopleController;
import br.com.projetofilmes.model.Person;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.MyViewHolder>  {

    private PeopleController peopleController;
    private String type;

    public PeopleAdapter(String type) {
        if (type.contentEquals( "actor" )){
            this.peopleController = PeopleController.getInstance("actor");
        }else{
            this.peopleController = PeopleController.getInstance("director");
        }
        this.type = type;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name, birth_day;
        private ImageView photo;

        MyViewHolder(@NonNull View itemView) {
            super( itemView );

            name = itemView.findViewById( R.id.name );
            birth_day = itemView.findViewById( R.id.birth_day );
            photo = itemView.findViewById( R.id.photo );
        }
    }

    @NonNull
    @Override
    public PeopleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.people_row_recycler, parent, false);
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Person person;
        if (type.contentEquals( "actor" )){
            person = peopleController.getActors().get(position);
        }else{
            person = peopleController.getDirectors().get(position);
        }
            
        holder.name.setText( person.getName() );
        holder.birth_day.setText( person.getDate_birth() );
        holder.photo.setImageResource( person.getImage() );
    }

    @Override
    public int getItemCount() {
        if (type.contentEquals( "actor" )){
            return peopleController.getActors().size();
        }else{
            return peopleController.getDirectors().size();
        }
    }
}
