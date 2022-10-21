package com.example.recyclerviewinmvm.models;

public class MovieModel
{
    String name;
    String imageurl;

    public MovieModel() {
    }

    public MovieModel(String name, String imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return imageurl;
    }

    public void setImage(String imageurl) {
        this.imageurl = imageurl;
    }
}