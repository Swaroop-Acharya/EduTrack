package com.example.edutrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class SaveMarks extends AppCompatActivity {
    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    FloatingActionButton floatingActionButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_marks);

        recyclerView=(RecyclerView)findViewById(R.id.savemark_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("SaveMarks"), MainModel.class)
                        .build();


        mainAdapter = new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);


        floatingActionButton3 =findViewById(R.id.fBtn1);
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddMarks.class));

            }
        });

    }

    @Override
    protected void onStart() {

        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.startListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search_bar);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtsearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtsearch(query);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
    private void txtsearch(String str){
        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("SaveMarks").orderByChild("Title").startAt(str).endAt(str+"~"), MainModel.class)
                        .build();

        mainAdapter =new MainAdapter(options);
        mainAdapter.startListening();
        recyclerView.setAdapter(mainAdapter);
    }
}