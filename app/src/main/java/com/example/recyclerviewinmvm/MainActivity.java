package com.example.recyclerviewinmvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclerviewinmvm.adapters.MovieListAdapter;
import com.example.recyclerviewinmvm.models.MovieModel;
import com.example.recyclerviewinmvm.viewmodels.MovieListViewModel;

import java.util.List;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    RecyclerView recview;
    List<MovieModel> movielist;
    MovieListViewModel listViewModel;
    MovieListAdapter adapter;
    TextView noresfound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recview=findViewById(R.id.recview);
        noresfound=findViewById(R.id.noresult);

        recview.setLayoutManager(new LinearLayoutManager(this));
        recview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        adapter=new MovieListAdapter(movielist);
        recview.setAdapter(adapter);

        listViewModel= ViewModelProviders.of(this).get(MovieListViewModel.class);
        listViewModel.getMovielistObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels!=null) {
                    movielist= movieModels;
                    adapter.updatemovielist(movieModels);
                    noresfound.setVisibility(View.GONE);
                }
                if(movieModels==null)
                {
                    recview.setVisibility(View.GONE);
                    noresfound.setVisibility(View.VISIBLE);
                }
            }
        });
        listViewModel.makeApiCall();


    }
}