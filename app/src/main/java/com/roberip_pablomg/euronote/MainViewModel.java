package com.roberip_pablomg.euronote;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private EurovisionService eurovisionService;

    public MainViewModel(){
        eurovisionService = EurovisionService.getInstance();
    }

    public ArrayList<Representative> getRepresentatives()
    {
        return eurovisionService.getRepresentatives("");
    }

    public Representative getRepresentative(int country)
    {
        return eurovisionService.getRepresentative(country);
    }

    public Representative getRepresentativeByPos(int position)
    {
        return eurovisionService.getRepresentatives("").get(position);
    }

    public void updateRepresentative(Representative representative){
        eurovisionService.update(representative.getCountry(), representative);
    }

}
