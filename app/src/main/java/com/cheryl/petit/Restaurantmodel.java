package com.cheryl.petit;

import java.io.Serializable;

public class Restaurantmodel implements Serializable {

    private String item_id;
    private String Restaurantname;
    private String Restaurantcity;
    private String Restaurantreigon;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Restaurantmodel() {
    }

    public Restaurantmodel(String restaurantcity, String restaurantreigon , String restaurantname, String item_id) {

        this.Restaurantname = restaurantname;
        this.Restaurantcity = restaurantcity;
        this.Restaurantreigon = restaurantreigon;
    }

    public String getRestaurantname() {
        return Restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        Restaurantname = restaurantname;
    }

    public String getRestaurantcity() {
        return Restaurantcity;
    }

    public void setRestaurantcity(String restaurantcity) {
        Restaurantcity = restaurantcity;
    }

    public String getRestaurantreigon() {
        return Restaurantreigon;
    }

    public void setRestaurantreigon(String restaurantreigon) {
        Restaurantreigon = restaurantreigon;
    }
}
