package com.cheryl.petit;

import java.io.Serializable;

public class Salonmodel implements Serializable {

    private String item_id;
    private String Salnname;
    private String Salncity;
    private String Salnreigon;
    private String Salnimg;
    private String Salntel;
    private String SalnOffiweb;
    private String Salnabout;
    private String Salnfacebook;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Salonmodel() {
    }

    public Salonmodel(String salncity, String salnreigon , String salnname,String salnimg,String salntel, String salnOffiweb, String salnabout, String salnfacebook, String item_id) {

        this.Salnname = salnname;
        this.Salncity = salncity;
        this.Salnreigon = salnreigon;
        this.Salnimg = salnimg;
        this.Salntel = salntel;
        this.Salnabout = salnabout;
        this.Salnfacebook = salnfacebook;
        this.SalnOffiweb = salnOffiweb;
    }

    public String getSalnname() {
        return Salnname;
    }

    public void setSalnname(String salnname) {
        Salnname = salnname;
    }

    public String getSalncity() {
        return Salncity;
    }

    public void setSalncity(String salncity) {
        Salncity = salncity;
    }

    public String getSalnreigon() {
        return Salnreigon;
    }

    public void setSalnreigon(String salnreigon) {
        Salnreigon = salnreigon;
    }

    public String getSalnimg() {
        return Salnimg;
    }

    public void setSalnimg(String salnimg) {
        Salnimg = salnimg;
    }

    public String getSalntel() {
        return Salntel;
    }

    public void setSalntel(String salntel) {
        Salntel = salntel;
    }

    public String getSalnOffiweb() {
        return SalnOffiweb;
    }

    public void setSalnOffiweb(String salnOffiweb) {
        SalnOffiweb = salnOffiweb;
    }

    public String getSalnabout() {
        return Salnabout;
    }

    public void setSalnabout(String salnabout) {
        Salnabout = salnabout;
    }

    public String getSalnfacebook() {
        return Salnfacebook;
    }

    public void setSalnfacebook(String salnfacebook) {
        Salnfacebook = salnfacebook;
    }
}
