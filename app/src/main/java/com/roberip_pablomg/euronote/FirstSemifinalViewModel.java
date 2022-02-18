package com.roberip_pablomg.euronote;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class FirstSemifinalViewModel extends ViewModel {

    private EurovisionService eurovisionService;

    public FirstSemifinalViewModel(){
        eurovisionService = EurovisionService.getInstance();
    }

    public ArrayList<Representative> getRepresentatives()
    {
        return eurovisionService.getRepresentatives("one");
    }

    public Representative getRepresentative(int country)
    {
        return eurovisionService.getRepresentative(country);
    }

    public Representative getRepresentativeByPos(int position)
    {
        return eurovisionService.getRepresentatives("one").get(position);
    }

    public void updateRepresentative(Representative representative){
        eurovisionService.update(representative.getCountry(), representative);
    }

}
