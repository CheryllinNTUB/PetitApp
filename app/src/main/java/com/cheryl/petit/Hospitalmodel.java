package com.cheryl.petit;

import java.io.Serializable;

public class Hospitalmodel implements Serializable {

    private String item_id;
    private String Hospitalname;
    private String Hospitalcity;
    private String Hospitalreigon;
    private String Hospitalimg;
    private String Hospitalfacebook;
    private String Hospitalwebsite;
    private String Hospitalphone;
    private String Hospitalemail;


    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Hospitalmodel() {
    }

    public Hospitalmodel(String hospitalcity, String hospitalreigon ,String hospitalname, String hospitalimg,String hospitalfacebook,String hospitalwebsite,String hospitalphone,String hospitalemail, String item_id) {

        this.Hospitalname = hospitalname;
        this.Hospitalcity = hospitalcity;
        this.Hospitalreigon = hospitalreigon;
        this.Hospitalimg = hospitalimg;
        this.Hospitalfacebook = hospitalfacebook;
        this.Hospitalwebsite = hospitalwebsite;
        this.Hospitalphone = hospitalphone;
        this.Hospitalemail = hospitalemail;
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

    public String getHospitalimg() {
        return Hospitalimg;
    }
    
    public void setHospitalimg(String hospitalimg) {
        Hospitalimg = hospitalimg;
    }

    public String getHospitalfacebook() {
        return Hospitalfacebook;
    }

    public void setHospitalfacebook(String hospitalfacebook) {
        Hospitalfacebook = hospitalfacebook;
    }

    public String getHospitalwebsite() {
        return Hospitalwebsite;
    }

    public void setHospitalwebsite(String hospitalwebsite) {
        Hospitalwebsite = hospitalwebsite;
    }

    public String getHospitalphone() {
        return Hospitalphone;
    }

    public void setHospitalphone(String hospitalphone) {
        Hospitalphone = hospitalphone;
    }

    public String getHospitalemail() {
        return Hospitalemail;
    }

    public void setHospitalemail(String hospitalemail) {
        Hospitalemail = hospitalemail;
    }
}
