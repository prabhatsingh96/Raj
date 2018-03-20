package com.example.prabhat.raj.UtilsApp;

/**
 * Created by fluper on 19/2/18.
 */

public class Product {

    private String title;
    private String description;

    public Product(){

    }

    public Product(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
