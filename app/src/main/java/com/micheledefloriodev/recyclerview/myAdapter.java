package com.micheledefloriodev.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    private List<String> values;



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader, txtFooter;
        public View layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            layout=itemView;
            txtHeader= txtHeader.findViewById(R.id.firstLine);
            txtFooter= txtFooter.findViewById(R.id.secondLine);

        }

        // each data item is just a string in this case

    }
    public void add(int position,String item){
        values.add(position,item);
        notifyItemInserted(position);
    }
    public void remove(int position){
        values.remove(position);
        notifyItemRemoved(position);
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public myAdapter(List<String> myDataSet){
        values=myDataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.layout_row,parent,false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final String name = values.get(position);
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(position);
            }
        });
        holder.txtFooter.setText("Footer"+name);


    }

    @Override
    public int getItemCount() {
        return values.size();
    }



}
