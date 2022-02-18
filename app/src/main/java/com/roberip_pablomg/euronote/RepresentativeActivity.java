package com.roberip_pablomg.euronote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class RepresentativeActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String REPRESENTATIVE_COUNTRY = "representativeCountry";

    private RepresentativeViewModel viewModel;
    private TextView tvSongName;
    private TextView tvSingerName;
    private TextView tvPosition;
    private TextView tvPoints;
    private TextView tvCountry;
    private TextView semifinal;
    private ImageView flag;
    private VideoView video;
    private TextView lyrics;
    private Button playBt;
    private Button pauseBt;
    private Button replayBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representative);
        System.out.println("hey");
        this.viewModel = ViewModelProviders.of(this).get(RepresentativeViewModel.class);
        System.out.println("no");
        Intent intent = getIntent();
        int country = intent.getIntExtra( REPRESENTATIVE_COUNTRY, -1);
        Representative representative = viewModel.selectRepresentative(country);
        findWidgets();
        showRepresentative(representative);
    }

    private void showRepresentative(Representative representative){
        this.tvSongName.setText(representative.getSongName());
        this.tvSingerName.setText(representative.getSingerName());
        this.tvCountry.setText(representative.getCountry());
        this.tvPosition.setText(representative.getPosition());
        this.tvPoints.setText(String.valueOf(representative.getPoints()));
        this.flag.setImageResource(representative.getFlag());
        this.video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + representative.getVideo()));
        this.semifinal.setText(this.getResources().getString(representative.getSemifinal()));
        this.lyrics.setText(representative.getLyrics());
    }

    private void findWidgets(){
        this.tvSongName = findViewById(R.id.songName);
        this.tvSingerName = findViewById(R.id.singerName);
        this.tvCountry = findViewById(R.id.country);
        this.tvPosition = findViewById(R.id.position);
        this.tvPoints = findViewById(R.id.points);
        this.flag = findViewById(R.id.flag);
        this.video = findViewById(R.id.video);
        this.semifinal = findViewById(R.id.semifinal);
        this.playBt = findViewById(R.id.playButton);
        this.pauseBt = findViewById(R.id.pauseButton);
        this.replayBt = findViewById(R.id.replayButton);
        this.lyrics = findViewById(R.id.lyrics);
        this.playBt.setOnClickListener(this);
        this.pauseBt.setOnClickListener(this);
        this.replayBt.setOnClickListener(this);
        this.lyrics.setMovementMethod(new ScrollingMovementMethod());


    }

    //ACTUALIZAR VIEWMODEL AL AÑADIR A FAVES
    //AÑADIR ESTRELLAS
    //CAMBIAR COLOR DE BOTONES
    //OPTIMIZAR EL CÓDIGO Y LIMPIAR

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playButton:
                video.start();
                break;
            case R.id.pauseButton:
                video.pause();
                break;
            case R.id.replayButton:
                video.resume();
            break;
        }
    }
}
