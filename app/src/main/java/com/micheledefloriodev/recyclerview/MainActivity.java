package com.micheledefloriodev.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private List<ModelData> users;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        users=new ArrayList<>();



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new RecyclerViewAdapter(users,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true); // le cardView sono tutte delle stesse dimensioni
        setupSwipeRefresh();


    }
    /*
    Notifica avvenuta cambiamento all interno del Recycle View( e adapter)

     */
    private void notifyOnDataChanged(){
        users.clear();
        users = addElement();
        recyclerView.removeAllViews();
        adapter = new RecyclerViewAdapter(users,this);
        recyclerView.setAdapter(adapter);

    }
    private List<ModelData> addElement(){
        List<ModelData> modelData= new ArrayList<>();
        modelData.add(new ModelData("Fischl",R.drawable.fotoprofilo_genshin));
        modelData.add(new ModelData("Ganyu",R.drawable.fotoprofilo_genshin2));
        modelData.add(new ModelData("TizioVento",R.drawable.fotoprofilo_genshin3));
        return modelData;
    }
    /*

    imposta i parametri del swipe refresh

     */
    private void setupSwipeRefresh () {
        swipeRefreshLayout=findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorScheme(
                android.R.color.holo_blue_bright,
                android.R.color.holo_blue_dark,
                android.R.color.holo_blue_light,
                android.R.color.black);
    }
/*
viene richiamato al momento dello swipe

 */
    @Override
    public void onRefresh() {
        notifyOnDataChanged();
        swipeRefreshLayout.setRefreshing(false);
    }
}