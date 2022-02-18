package com.roberip_pablomg.euronote;

import androidx.lifecycle.ViewModel;

public class RepresentativeViewModel extends ViewModel {

    private EurovisionService eurovisionService;
    private int country;
    private Representative representative;

    public RepresentativeViewModel(){
        eurovisionService = EurovisionService.getInstance();
    }

    public Representative selectRepresentative(int country) {
        this.country = country;
        this.representative = eurovisionService.getRepresentative(country);
        return this.representative;
    }

    public Representative getRepresentative() {
        return this.representative;
    }


}
