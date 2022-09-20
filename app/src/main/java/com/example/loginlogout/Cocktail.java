package com.example.loginlogout;

import java.io.Serializable;

public class Cocktail implements Serializable {
    private String title , information  ;
    private double price ;
    private int image ;

    public Cocktail(String title, String information, double price, int image) {
        this.title = title;
        this.information = information;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
