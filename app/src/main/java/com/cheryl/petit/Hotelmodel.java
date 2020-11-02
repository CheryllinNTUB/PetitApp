package com.cheryl.petit;

import java.io.Serializable;

public class Hotelmodel implements Serializable{

    private String item_id;
    private String Hotelname;
    private String Hotelcity;
    private String Hotelreigon;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Hotelmodel() {
    }

    public Hotelmodel(String hotelcity, String hotelreigon ,String hotelname, String item_id) {

        this.Hotelname = hotelname;
        this.Hotelcity = hotelcity;
        this.Hotelreigon = hotelreigon;
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
}
