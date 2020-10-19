package com.cheryl.petit;

import java.io.Serializable;

public class Parkmodel implements Serializable {

    private String item_id;
    private String Parkcity;
    private String Parkreigon;
    private String Parkname;
    private String Park_details;
    private String Parkimg;
    private String Park_search;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Parkmodel() {
    }


    public Parkmodel(String parkcity, String parkreigon,String parkname, String parkdetails, String parkimg, String park_search, String item_id) {

        this.Parkname = parkname;
        this.Parkcity = parkcity;
        this.Parkreigon = parkreigon;
        this.Park_details = parkdetails;
        this.Parkimg = parkimg;
        this.Park_search = park_search;
    }

    public String getParkcity() {
        return Parkcity;
    }

    public void setParkcity(String parkcity) {
        Parkcity = parkcity;
    }

    public String getParkreigon() {
        return Parkreigon;
    }

    public void setParkreigon(String parkreigon) {
        Parkreigon = parkreigon;
    }

    public String getParkname() {
        return Parkname;
    }

    public void setParkname(String parkname) {
        this.Parkname = parkname;
    }

    public String getParkdetails() {
        return Park_details;
    }

    public void setParkdetails(String parkdetails) {
        this.Park_details = parkdetails;
    }

    public String getParkimg() {
        return Parkimg;
    }

    public void setParkimg(String parkimg) {
        this.Parkimg= parkimg;
    }

    public String getPark_search() {
        return Park_search;
    }

    public void setPark_search(String park_search) {
        Park_search = park_search;
    }
}
