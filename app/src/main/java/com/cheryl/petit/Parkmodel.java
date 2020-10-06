package com.cheryl.petit;

import java.io.Serializable;

public class Parkmodel implements Serializable {

    private String item_id;
    private String ParkAddress;
    private String Parkname;
    private String Parkdetails;
    //private String Parkimg;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Parkmodel() {
    }

    public Parkmodel(String parkAddress, String parkname, String parkdetails,String parkimg, String item_id) {
        this.ParkAddress = parkAddress;
        this.Parkname = parkname;
        this.Parkdetails = parkdetails;
        //this.Parkimg = parkimg;
    }

    public String getParkAddress() {
        return ParkAddress;
    }

    public void setParkAddress(String parkAddress) {
        this.ParkAddress = parkAddress;
    }

    public String getParkname() {
        return Parkname;
    }

    public void setParkname(String parkname) {
        this.Parkname = parkname;
    }

    public String getParkdetails() {
        return Parkdetails;
    }

    public void setParkdetails(String parkdetails) {
        this.Parkdetails = parkdetails;
    }

    /*public String getParkimg() {
        return Parkimg;
    }

    public void setParkimg(String parkimg) {
        this.Parkimg= parkimg;
    }*/
}
