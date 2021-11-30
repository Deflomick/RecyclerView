package com.micheledefloriodev.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter della nostra classe RecyclerView
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder>
{
    private List<ModelData> users;
    private Context context;

    public RecyclerViewAdapter(List<ModelData> users, Context context) {
        this.users = users;
        this.context = context;
    }
// inflate ( o gonfiaggio ) lo riportiamo su ViewHolder -> il quale andrà a definire e richiamare i vari componenti
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.layout_row,parent,false);
        return new viewHolder(v);
    }
// impostare gli oggetti presi dalla lista popolata da classi Model
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ModelData user= users.get(position);
        holder.nomeUser.setText(user.getName());
        holder.userImage.setImageResource(user.getUserimage());
        holder.touch_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cardview diventa clickabile
                Toast.makeText(context, "Position"+ position, Toast.LENGTH_SHORT).show();
            }
        });
    }
// resitituire la dimensione della lista
    @Override
    public int getItemCount() {
        return users.size();
    }
// definiamo il ViewHolder
    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView nomeUser;
        private ImageView userImage;
        private LinearLayout touch_layout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nomeUser=itemView.findViewById(R.id.nomeText);
            userImage=itemView.findViewById(R.id.imageView);
            touch_layout=itemView.findViewById(R.id.touch_layout);

        }
    }
}
