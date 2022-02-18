package com.roberip_pablomg.euronote;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;

public class FavesViewModel extends ViewModel {

    private EurovisionService eurovisionService;

    public FavesViewModel(){
        eurovisionService = EurovisionService.getInstance();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Representative> getRepresentatives()
    {
        ArrayList<Representative> result = eurovisionService.getRepresentatives("faves");
        Collections.sort(result, new ComparatorByStars().thenComparing(new ComparatorByPosition()));
        return result;
    }

    public Representative getRepresentative(int country)
    {
        return eurovisionService.getRepresentative(country);
    }

    public Representative getRepresentativeByPos(int position)
    {
        return eurovisionService.getRepresentatives("faves").get(position);
    }

    public void updateRepresentative(Representative representative){
        eurovisionService.update(representative.getCountry(), representative);
    }

}
