package com.roberip_pablomg.euronote;

import java.util.Comparator;

public class ComparatorByPosition implements Comparator <Representative> {

    @Override
    public int compare(Representative o1, Representative o2) {
        return o2.getPoints() - o1.getPoints();
    }
}
