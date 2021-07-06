package com.cheryl.petit;

import java.io.Serializable;

public class Hotelmodel implements Serializable{

    private String item_id;
    private String Hotelname;
    private String Hotelcity;
    private String Hotelreigon;
    private String Hotelabout;
    private String Hotelimg;
    private String Hotelphone;
    private String Hotelfacebook;
    private String Hotelemail;
    private String Hotelwebsite;


    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Hotelmodel() {
    }

    public Hotelmodel(String hotelcity, String hotelreigon ,String hotelname,String hotelimg, String hotelabout,String hotelphone,String hotelfacebook,String hotelemail,String hotelwebsite, String item_id) {

        this.Hotelname = hotelname;
        this.Hotelcity = hotelcity;
        this.Hotelreigon = hotelreigon;
        this.Hotelimg = hotelimg;
        this.Hotelabout = hotelabout;
        this.Hotelphone = hotelphone;
        this.Hotelfacebook = hotelfacebook;
        this.Hotelemail = hotelemail;
        this.Hotelwebsite = hotelwebsite;
    }

    public String getHotelname() {
        return Hotelname;
    }

    public void setHotelname(String hotelname) {
        Hotelname = hotelname;
    }

    public String getHotelcity() {
        return Hotelcity;
    }

    public void setHotelcity(String hotelcity) {
        Hotelcity = hotelcity;
    }

    public String getHotelreigon() {
        return Hotelreigon;
    }

    public void setHotelreigon(String hotelreigon) {
        Hotelreigon = hotelreigon;
    }

    public String getHotelabout() {
        return Hotelabout;
    }

    public void setHotelabout(String hotelabout) {
        Hotelabout = hotelabout;
    }

    public String getHotelimg() {
        return Hotelimg;
    }

    public void setHotelimg(String hotelimg) {
        Hotelimg = hotelimg;
    }

    public String getHotelphone() {
        return Hotelphone;
    }

    public void setHotelphone(String hotelphone) {
        Hotelphone = hotelphone;
    }

    public String getHotelfacebook() {
        return Hotelfacebook;
    }

    public void setHotelfacebook(String hotelfacebook) {
        Hotelfacebook = hotelfacebook;
    }

    public String getHotelemail() {
        return Hotelemail;
    }

    public void setHotelemail(String hotelemail) {
        Hotelemail = hotelemail;
    }

    public String getHotelwebsite() {
        return Hotelwebsite;
    }

    public void setHotelwebsite(String hotelwebsite) {
        Hotelwebsite = hotelwebsite;
    }
}
