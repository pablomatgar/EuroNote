package com.roberip_pablomg.euronote;

import android.net.Uri;

public class Representative {
    private String position;
    private String songName;
    private String singerName;
    private int semifinal;
    private int country;
    private int points;
    private int stars;
    private int flag;
    private int video;
    private String lyrics;

    public Representative(String position, String songName, String singerName, int semifinal, int country, int points, int flag, int video) {
        this.position = position;
        this.songName = songName;
        this.singerName = singerName;
        this.semifinal = semifinal;
        this.country = country;
        this.points = points;
        this.flag = flag;
        this.video = video;
        this.lyrics = null;
        this.stars = -1;
    }

    public Representative(String position, String songName, String singerName, int semifinal, int country, int points, int flag, int video, String lyrics, int stars) {
        this.position = position;
        this.songName = songName;
        this.singerName = singerName;
        this.semifinal = semifinal;
        this.country = country;
        this.points = points;
        this.flag = flag;
        this.video = video;
        this.lyrics = lyrics;
        this.stars = stars;
    }

    public Representative setPosition(String position) {
        return new Representative(position, this.songName, this.singerName, this.semifinal, this.country, this.points, this.flag, this.video, this.lyrics, this.stars);
    }

    public Representative setSongName(String songName) {
        return new Representative(this.position, songName, this.singerName, this.semifinal, this.country, this.points, this.flag, this.video, this.lyrics, this.stars);
    }

    public Representative setSingerName(String singerName) {
        return new Representative(this.position, this.songName, singerName, this.semifinal, this.country, this.points, this.flag, this.video, this.lyrics, this.stars);
    }

    public Representative setSemifinal(int semifinal) {
        return new Representative(this.position, this.songName, this.singerName, semifinal, this.country, this.points, this.flag, this.video, this.lyrics, this.stars);
    }

    public Representative setCountry(int country) {
        return new Representative(this.position, this.songName, this.singerName, this.semifinal, country, this.points, this.flag, this.video, this.lyrics, this.stars);
    }

    public Representative setPoints(int points) {
        return new Representative(this.position, this.songName, this.singerName, this.semifinal, this.country, points, this.flag, this.video, this.lyrics, this.stars);
    }

    public Representative setFlag(int flag) {
        return new Representative(this.position, this.songName, this.singerName, this.semifinal, this.country, this.points, flag, this.video, this.lyrics, this.stars);
    }

    public Representative setVideo(int video) {
        return new Representative(this.position, this.songName, this.singerName, this.semifinal, this.country, this.points, this.flag, video, this.lyrics, this.stars);
    }

    public Representative setLyrics(String lyrics) {
        return new Representative(this.position, this.songName, this.singerName, this.semifinal, this.country, this.points, this.flag, this.video, lyrics, this.stars);
    }

    public Representative setStars(int stars) {
        return new Representative(this.position, this.songName, this.singerName, this.semifinal, this.country, this.points, this.flag, this.video, this.lyrics, stars);
    }

    public String getPosition() {
        return position;
    }

    public String getSongName() {
        return songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public int getSemifinal() {
        return semifinal;
    }

    public int getCountry() {
        return country;
    }

    public int getPoints() {
        return points;
    }

    public int getFlag() {
        return flag;
    }

    public int getStars() {
        return stars;
    }

    public int getVideo() {
        return video;
    }

    public String getLyrics() {
        return lyrics;
    }
}
