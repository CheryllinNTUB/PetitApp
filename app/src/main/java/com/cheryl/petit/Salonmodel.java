package com.cheryl.petit;

import java.io.Serializable;

public class Salonmodel implements Serializable {

    private String item_id;
    private String Salonname;
    private String Saloncity;
    private String Salonreigon;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Salonmodel() {
    }

    public Salonmodel(String saloncity, String salonreigon , String salonname, String item_id) {

        this.Salonname = salonname;
        this.Saloncity = saloncity;
        this.Salonreigon = salonreigon;
    }

    public String getSalonname() {
        return Salonname;
    }

    public void setSalonname(String salonname) {
        Salonname = salonname;
    }

    public String getSaloncity() {
        return Saloncity;
    }

    public void setSaloncity(String saloncity) {
        Saloncity = saloncity;
    }

    public String getSalonreigon() {
        return Salonreigon;
    }

    public void setSalonreigon(String salonreigon) {
        Salonreigon = salonreigon;
    }
}
