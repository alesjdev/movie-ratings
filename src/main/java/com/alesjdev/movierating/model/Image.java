package com.alesjdev.movierating.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {

    @JsonProperty("file_path")
    private String filePath;

    @JsonProperty("height")
    private int height;

    @JsonProperty("width")
    private int width;


    // Getters and Setters
    public String getFile_path() {
        return filePath;
    }

    public void setFile_path(String filePath) {
        this.filePath = filePath;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
