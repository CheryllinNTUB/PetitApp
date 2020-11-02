package com.cheryl.petit;

import java.io.Serializable;

public class Restaurantmodel implements Serializable {

    private String item_id;
    private String Restname;
    private String Restcity;
    private String Restreigon;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Restaurantmodel() {
    }

    public Restaurantmodel(String restaurantcity, String restaurantreigon , String restaurantname, String item_id) {

        this.Restname = restaurantname;
        this.Restcity = restaurantcity;
        this.Restreigon = restaurantreigon;
    }

    public String getRestname() {
        return Restname;
    }

    public void setRestname(String restname) {
        Restname = restname;
    }

    public String getRestcity() {
        return Restcity;
    }

    public void setRestcity(String restcity) {
        Restcity = restcity;
    }

    public String getRestreigon() {
        return Restreigon;
    }

    public void setRestreigon(String restreigon) {
        Restreigon = restreigon;
    }
}
