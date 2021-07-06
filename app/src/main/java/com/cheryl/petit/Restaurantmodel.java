package com.cheryl.petit;

import java.io.Serializable;

public class Restaurantmodel implements Serializable {

    private String item_id;
    private String Restname;
    private String Restcity;
    private String Restreigon;
    private String Restabout;
    private String Restimg;
    private String Resttel;
    private String Restfacebook;


    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Restaurantmodel() {
    }

    public Restaurantmodel(String restaurantcity, String restaurantreigon , String restaurantname, String restabout, String restimg,String resttel,String restfacebook, String item_id) {

        this.Restname = restaurantname;
        this.Restcity = restaurantcity;
        this.Restreigon = restaurantreigon;
        this.Restabout = restabout;
        this.Restimg = restimg;
        this.Resttel = resttel;
        this.Restfacebook = restfacebook;
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

    public String getRestabout() {
        return Restabout;
    }

    public void setRestabout(String restabout) {
        Restabout = restabout;
    }

    public String getRestimg() {
        return Restimg;
    }

    public void setRestimg(String restimg) {
        Restimg = restimg;
    }

    public String getResttel() {
        return Resttel;
    }

    public void setResttel(String resttel) {
        Resttel = resttel;
    }

    public String getRestfacebook() {
        return Restfacebook;
    }

    public void setRestfacebook(String restfacebook) {
        Restfacebook = restfacebook;
    }
}
