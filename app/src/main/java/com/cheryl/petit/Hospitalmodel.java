package com.cheryl.petit;

import java.io.Serializable;

public class Hospitalmodel implements Serializable {

    private String item_id;
    private String Hospitalname;
    private String Hospitalcity;
    private String Hospitalreigon;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Hospitalmodel() {
    }

    public Hospitalmodel(String hospitalcity, String hospitalreigon ,String hospitalname, String item_id) {

        this.Hospitalname = hospitalname;
        this.Hospitalcity = hospitalcity;
        this.Hospitalreigon = hospitalreigon;
    }

    public String getHospitalname() {
        return Hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        Hospitalname = hospitalname;
    }

    public String getHospitalcity() {
        return Hospitalcity;
    }

    public void setHospitalcity(String hospitalcity) {
        Hospitalcity = hospitalcity;
    }

    public String getHospitalreigon() {
        return Hospitalreigon;
    }

    public void setHospitalreigon(String hospitalreigon) {
        Hospitalreigon = hospitalreigon;
    }
}
