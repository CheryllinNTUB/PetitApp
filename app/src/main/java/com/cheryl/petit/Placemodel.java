package com.cheryl.petit;
import java.io.Serializable;

public class Placemodel implements Serializable {

    private String item_id;
    private String Placename;
    private String Placecity;
    private String Placereigon;
    private String Placeimg;
    private String Placephone;
    private String Placefacebook;
    private String Placewebsite;
    private String Placeemail;
    private String Placeabout;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Placemodel() {
    }

    public Placemodel(String placecity, String placereigon , String placename,String placeimg,String placephone,String placefacebook,String placewebsite,String placeemail,String placeabout, String item_id) {

        this.Placename = placename;
        this.Placecity = placecity;
        this.Placereigon = placereigon;
        this.Placeimg = placeimg;
        this.Placephone = placephone;
        this.Placefacebook = placefacebook;
        this.Placewebsite = placewebsite;
        this.Placeemail = placeemail;
        this.Placeabout = placeabout;
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

    public String getPlaceimg() {
        return Placeimg;
    }

    public void setPlaceimg(String placeimg) {
        Placeimg = placeimg;
    }

    public String getPlacephone() {
        return Placephone;
    }

    public void setPlacephone(String placephone) {
        Placephone = placephone;
    }

    public String getPlacefacebook() {
        return Placefacebook;
    }

    public void setPlacefacebook(String placefacebook) {
        Placefacebook = placefacebook;
    }

    public String getPlacewebsite() {
        return Placewebsite;
    }

    public void setPlacewebsite(String placewebsite) {
        Placewebsite = placewebsite;
    }

    public String getPlaceemail() {
        return Placeemail;
    }

    public void setPlaceemail(String placeemail) {
        Placeemail = placeemail;
    }

    public String getPlaceabout() {
        return Placeabout;
    }

    public void setPlaceabout(String placeabout) {
        Placeabout = placeabout;
    }
}
