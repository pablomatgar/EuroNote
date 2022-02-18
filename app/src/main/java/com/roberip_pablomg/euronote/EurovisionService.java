package com.roberip_pablomg.euronote;


import android.net.Uri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class EurovisionService {

    public static  EurovisionService eurovisionService;
    private ArrayList<Representative> representatives;
    private HashMap <Integer, String> lyrics = new HashMap<Integer, String>();

    public static EurovisionService getInstance(){

        if(eurovisionService == null){
            eurovisionService = new EurovisionService();
        }
        return  eurovisionService;
    }

    private EurovisionService(){

        this.representatives = new ArrayList<>();

        this.loadLyrics();

        representatives.add(new Representative("18", "Ktheju tokës", "Jonida Maliqi", R.string.second_semifinal, R.string.albania, 90, R.drawable.albania, R.raw.albania));
        representatives.add(new Representative("-", "Walking Out", "Srbuk", R.string.second_semifinal, R.string.armenia, 0, R.drawable.armenia, R.raw.armenia));
        representatives.add(new Representative("9", "Zero Gravity", "Kate Miller-Heidke", R.string.first_semifinal, R.string.australia, 285, R.drawable.australia, R.raw.australia));
        representatives.add(new Representative("-", "Limits", "PÆNDA", R.string.second_semifinal, R.string.austria, 0, R.drawable.austria, R.raw.austria));
        representatives.add(new Representative("7", "Truth", "Chingiz", R.string.second_semifinal, R.string.azerbaijan, 297, R.drawable.azerbaijan, R.raw.azerbaijan));
        representatives.add(new Representative("25", "Like It", "ZENA", R.string.first_semifinal, R.string.belarus, 31, R.drawable.belarus, R.raw.belarus));
        representatives.add(new Representative("-", "Wake Up", "Eliot", R.string.first_semifinal, R.string.belgium, 0, R.drawable.belgium, R.raw.belgium));
        representatives.add(new Representative("-", "The Dream", "Roko", R.string.second_semifinal, R.string.croatia, 0, R.drawable.croatia, R.raw.croatia));
        representatives.add(new Representative("15", "Replay", "Tamta", R.string.first_semifinal, R.string.cyprus, 101, R.drawable.cyprus, R.raw.cyprus));
        representatives.add(new Representative("11", "Friend of a Friend", "Lake Mlawi", R.string.first_semifinal, R.string.czech_republic, 157, R.drawable.czech_republic, R.raw.czech_republic));
        representatives.add(new Representative("12", "Love Is Forever", "Leonora", R.string.second_semifinal, R.string.denmark, 120, R.drawable.denmark, R.raw.denmark));
        representatives.add(new Representative("19", "Storm", "Victor Crone", R.string.first_semifinal, R.string.estonia, 86, R.drawable.estonia, R.raw.estonia));
        representatives.add(new Representative("-", "Look Away", "Darude feat. Sebastian Rejman", R.string.first_semifinal, R.string.finland, 0, R.drawable.finland, R.raw.finland));
        representatives.add(new Representative("14", "Roi", "Bilal Hassani", R.string.big_five, R.string.france, 105, R.drawable.france, R.raw.france));
        representatives.add(new Representative("-", "Keep on Going", "Oto Nemsadze", R.string.first_semifinal, R.string.georgia, 0, R.drawable.georgia, R.raw.georgia));
        representatives.add(new Representative("24", "Sister", "S!sters", R.string.big_five, R.string.germany, 32, R.drawable.germany, R.raw.germany));
        representatives.add(new Representative("21", "Better Love", "Katerine Duska", R.string.first_semifinal, R.string.greece, 71, R.drawable.greece, R.raw.greece));
        representatives.add(new Representative("-", "Az én apám", "Joci Pápai", R.string.first_semifinal, R.string.hungary, 0, R.drawable.hungary, R.raw.hungary));
        representatives.add(new Representative("10", "Hatrið mun sigra", "Hatari", R.string.first_semifinal, R.string.iceland, 234, R.drawable.iceland, R.raw.iceland));
        representatives.add(new Representative("-", "22", "Sarah McTernan", R.string.second_semifinal, R.string.ireland, 0, R.drawable.ireland, R.raw.ireland));
        representatives.add(new Representative("23", "Home", "Kobi Marimi", R.string.winner_2018, R.string.israel, 47, R.drawable.israel, R.raw.israel));
        representatives.add(new Representative("2", "Soldi", "Mahmood", R.string.big_five, R.string.italy, 465, R.drawable.italy, R.raw.italy));
        representatives.add(new Representative("-", "That Night", "Carousel", R.string.second_semifinal, R.string.latvia, 0, R.drawable.latvia, R.raw.latvia));
        representatives.add(new Representative("-", "Run With The Lions", "Jurij Veklenko", R.string.second_semifinal, R.string.lithuania, 0, R.drawable.lithuania, R.raw.lithuania));
        representatives.add(new Representative("16", "Chameleon", "Michela", R.string.second_semifinal, R.string.malta, 95, R.drawable.malta, R.raw.malta));
        representatives.add(new Representative("-", "Stay", "Anna Odobescu", R.string.second_semifinal, R.string.moldova, 0, R.drawable.moldova, R.raw.moldova));
        representatives.add(new Representative("-", "Heaven", "D mol", R.string.first_semifinal, R.string.montenegro, 0, R.drawable.montenegro, R.raw.montenegro));
        representatives.add(new Representative("1", "Arcade", "Duncan Laurence", R.string.second_semifinal, R.string.netherlands, 492, R.drawable.netherlands, R.raw.netherlands));
        representatives.add(new Representative("8", "Proud", "Tamara Todevska", R.string.second_semifinal, R.string.north_macedonia, 295, R.drawable.north_macedonia, R.raw.north_macedonia));
        representatives.add(new Representative("5", "Spirit in the Sky", "KEiiNO", R.string.second_semifinal, R.string.norway, 338, R.drawable.norway, R.raw.norway));
        representatives.add(new Representative("-", "Fire of Love (Pali się)", "Tulia", R.string.first_semifinal, R.string.poland, 0, R.drawable.poland, R.raw.poland));
        representatives.add(new Representative("-", "Telemóveis", "Conan Osiris", R.string.first_semifinal, R.string.portugal, 0, R.drawable.portugal, R.raw.portugal));
        representatives.add(new Representative("-", "On a Sunday", "Ester Peony", R.string.second_semifinal, R.string.romania, 0, R.drawable.romania, R.raw.romania));
        representatives.add(new Representative("3", "Scream", "Sergey Lazarev", R.string.second_semifinal, R.string.russia, 369, R.drawable.russia, R.raw.russia));
        representatives.add(new Representative("20", "Say Na Na Na", "Serhat", R.string.first_semifinal, R.string.san_marino, 81, R.drawable.san_marino, R.raw.san_marino));
        representatives.add(new Representative("17", "Kruna", "Nevena Božović", R.string.first_semifinal, R.string.serbia, 92, R.drawable.serbia, R.raw.serbia));
        representatives.add(new Representative("13", "Sebi", "Zala Kralj & Gašper Šantl", R.string.first_semifinal, R.string.slovenia, 105, R.drawable.slovenia, R.raw.slovenia));
        representatives.add(new Representative("22", "La Venda", "Miki", R.string.big_five, R.string.spain, 60, R.drawable.spain, R.raw.spain));
        representatives.add(new Representative("6", "Too Late For Love", "John Lundvik", R.string.second_semifinal, R.string.sweden, 332, R.drawable.sweden, R.raw.sweden));
        representatives.add(new Representative("4", "She Got Me", "Luca Hänni", R.string.second_semifinal, R.string.switzerland, 360, R.drawable.switzerland, R.raw.switzerland));
        representatives.add(new Representative("26", "Bigger Than Us", "Michael Rice", R.string.big_five, R.string.uk, 16, R.drawable.uk, R.raw.uk));

        for(Representative representative:representatives){
            update(representative.getCountry(),representative.setLyrics(lyrics.get(representative.getCountry())));
        }

        Collections.sort(representatives, new ComparatorByPosition());
    }

    public ArrayList<Representative> getRepresentatives(String option) {
        ArrayList<Representative> representativesReturn = new ArrayList<>();
        switch (option) {
            case "one": for(Representative representative:representatives){
                            if(representative.getSemifinal() == R.string.first_semifinal){
                                representativesReturn.add(representative);
                            }
                        }
                        return representativesReturn;
            case "two": for(Representative representative:representatives){
                            if(representative.getSemifinal() == R.string.second_semifinal){
                                representativesReturn.add(representative);
                            }
                        }
                return representativesReturn;
            case "final": for(Representative representative:representatives){
                            if(representative.getPosition().equals("-") == false){
                                representativesReturn.add(representative);
                            }
                        }
                return representativesReturn;
            case "faves": for(Representative representative:representatives){
                                if(representative.getStars() != -1){
                                    representativesReturn.add(representative);
                                }
                        }
                return representativesReturn;
            default:
                return representatives;
        }
    }

    public Representative getRepresentative(int country) {
        int position = findRepresentative(country);
        if(position != -1) {
             return representatives.get(position);
        }
        return null;
    }

    public void update(int country, Representative representative) {
        int position = findRepresentative(country);
        if(position != -1) {
            representatives.set(position, representative);
        }
    }

    public int findRepresentative(int country){
        int i;
        for(i = 0; i<representatives.size(); i++){
            if(representatives.get(i).getCountry() == country){
                return i;
            }
        }
        return -1;
    }

    private void loadLyrics(){
        Lyrics lyrics = new Lyrics();
        this.lyrics = lyrics.saveLyrics();
    }

}
