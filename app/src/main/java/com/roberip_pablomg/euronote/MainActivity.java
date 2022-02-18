package com.roberip_pablomg.euronote;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements EurovisionAdapter.onItemClickListener{

    private ViewModel viewModel;
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;
    private EurovisionAdapter adapter;
    private BottomNavigationView bottomNavigationView;
    private AppCompatActivity activity;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.activity = this;
        this.textView = findViewById(R.id.textView2);
        this.viewModel = ViewModelProviders.of(activity).get(MainViewModel.class);
        this.layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        this.rv = findViewById(R.id.rv);
        this.adapter = new EurovisionAdapter(this);
        this.adapter.setOnItemClickListener(this);
        this.bottomNavigationView = findViewById(R.id.bnv);

        rv.setAdapter(adapter);
        rv.setLayoutManager(layoutManager);
        textView.setText(R.string.all);
        adapter.setRepresentatives(((MainViewModel)viewModel).getRepresentatives());
        adapter.setVM(viewModel);
        bottomNavigationView.setSelectedItemId(R.id.all);



        bottomNavigationView.setOnNavigationItemSelectedListener(
        new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.all:
                        viewModel = ViewModelProviders.of(activity).get(MainViewModel.class);
                        adapter.setVM(viewModel);
                        adapter.setRepresentatives(((MainViewModel)viewModel).getRepresentatives());
                        textView.setText(R.string.all);
                        break;
                    case R.id.first_semifinal:
                        viewModel = ViewModelProviders.of(activity).get(FirstSemifinalViewModel.class);
                        adapter.setVM(viewModel);
                        adapter.setRepresentatives(((FirstSemifinalViewModel)viewModel).getRepresentatives());
                        textView.setText(R.string.first_semifinal);
                        break;
                    case R.id.second_semifinal:
                        viewModel = ViewModelProviders.of(activity).get(SecondSemifinalViewModel.class);
                        adapter.setVM(viewModel);
                        adapter.setRepresentatives(((SecondSemifinalViewModel)viewModel).getRepresentatives());
                        textView.setText(R.string.second_semifinal);
                        break;
                    case R.id.grand_final:
                        viewModel = ViewModelProviders.of(activity).get(GrandFinalViewModel.class);
                        adapter.setVM(viewModel);
                        adapter.setRepresentatives(((GrandFinalViewModel)viewModel).getRepresentatives());
                        textView.setText(R.string.grand_final);
                        break;
                    case R.id.faves:
                        viewModel = ViewModelProviders.of(activity).get(FavesViewModel.class);
                        adapter.setVM(viewModel);
                        adapter.setRepresentatives(((FavesViewModel)viewModel).getRepresentatives());
                        textView.setText(R.string.faves);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Representative representative = null;
        String viewModelR = null;
        if (viewModel instanceof MainViewModel){
            representative = ((MainViewModel) viewModel).getRepresentativeByPos(position);
            viewModelR = "";
            System.out.println("nothing");
        }
        else if (viewModel instanceof FirstSemifinalViewModel){
            representative = ((FirstSemifinalViewModel) viewModel).getRepresentativeByPos(position);
            viewModelR = "one";
            System.out.println("one");

        }
        else if (viewModel instanceof SecondSemifinalViewModel){
            representative = ((SecondSemifinalViewModel) viewModel).getRepresentativeByPos(position);
            viewModelR = "two";
            System.out.println("two");

        }
        else if (viewModel instanceof GrandFinalViewModel){
            representative = ((GrandFinalViewModel) viewModel).getRepresentativeByPos(position);
            viewModelR = "final";
            System.out.println("final");

        }
        else if (viewModel instanceof FavesViewModel){
            representative = ((FavesViewModel) viewModel).getRepresentativeByPos(position);
            viewModelR = "faves";
            System.out.println("faves");

        }
        Toast.makeText(this, representative.getSongName(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, RepresentativeActivity.class );
        intent.putExtra(RepresentativeActivity.REPRESENTATIVE_COUNTRY, representative.getCountry());
        startActivityForResult( intent, 8 );
    }
}
