package com.example.uiimplementation3;

public class CarItem {
    int image;
    String type, desc, no;
    double rating;

    public CarItem(int image, double rating, String type, String desc, String no) {
        this.image = image;
        this.type = type;
        this.desc = desc;
        this.no = no;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }


    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public String getNo() {
        return no;
    }

    public double getRating() {
        return rating;
    }

}
