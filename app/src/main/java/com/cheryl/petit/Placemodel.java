package com.cheryl.petit;

import java.io.Serializable;

public class Placemodel implements Serializable {

    private String item_id;
    private String Placename;
    private String Placecity;
    private String Placereigon;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Placemodel() {
    }

    public Placemodel(String placecity, String placereigon , String placename, String item_id) {

        this.Placename = placename;
        this.Placecity = placecity;
        this.Placereigon = placereigon;
    }

    public String getPlacename() {
        return Placename;
    }

    public void setPlacename(String placename) {
        Placename = placename;
    }

    public String getPlacecity() {
        return Placecity;
    }

    public void setPlacecity(String placecity) {
        Placecity = placecity;
    }

    public String getPlacereigon() {
        return Placereigon;
    }

    public void setPlacereigon(String placereigon) {
        Placereigon = placereigon;
    }
}
