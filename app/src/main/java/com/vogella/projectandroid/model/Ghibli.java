package com.vogella.projectandroid.model;

import com.google.gson.annotations.SerializedName;

public class Ghibli{

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("director")
    private String director;

    @SerializedName("producer")
    private String producer;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("rt_score")
    private String score;


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription(){return description;}

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getScore() {
        return score;
    }
}
