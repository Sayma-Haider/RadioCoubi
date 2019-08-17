package com.example.radiocoubi;

public class OldShows {

    private String showName,duration;

    public OldShows(){
    }

    public OldShows(String showName, String duration) {
        this.showName = showName;
        this.duration = duration;
    }

    public String getShowName() {
        return showName;
    }

    public String getDuration() {
        return duration;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
