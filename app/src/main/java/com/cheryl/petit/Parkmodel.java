package com.cheryl.petit;
import java.io.Serializable;

public class Parkmodel implements Serializable{

    private String item_id;
    private String Parkcity;
    private String Parkreigon;
    private String Parkname;
    private String Parkabout;
    private String Parkimg;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Parkmodel() {
    }


    public Parkmodel(String parkcity, String parkreigon,String parkname, String parkabout, String parkimg, String item_id) {

        this.Parkname = parkname;
        this.Parkcity = parkcity;
        this.Parkreigon = parkreigon;
        this.Parkabout = parkabout;
        this.Parkimg = parkimg;
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

    public String getParkabout() {
        return Parkabout;
    }

    public void setParkabout(String parkabout) {
        Parkabout = parkabout;
    }

    public String getParkimg() {
        return Parkimg;
    }

    public void setParkimg(String parkimg) {
        this.Parkimg= parkimg;
    }

}
