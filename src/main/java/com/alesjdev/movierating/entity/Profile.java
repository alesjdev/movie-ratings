package com.alesjdev.movierating.entity;

import org.springframework.beans.factory.annotation.Value;

public class Profile {

    @Value("${tmdb.image-path}")
    private String IMAGE_PATH;

    private String file_path;

    private int height;

    private int width;


    // Constructors
    public Profile() {
    }

    public Profile(String file_path) {
        this.file_path = file_path;
    }

    public Profile(String file_path, int height, int width) {
        this.file_path = file_path;
        this.height = height;
        this.width = width;
    }


    // Getters and Setters
    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = IMAGE_PATH + file_path;
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
