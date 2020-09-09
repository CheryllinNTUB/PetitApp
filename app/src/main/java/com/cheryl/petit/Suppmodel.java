package com.cheryl.petit;



public class Suppmodel {
    private String suppbrand,suppname,supptype,date,supptime;

    public Suppmodel(){}
    public Suppmodel(String suppbrand,String suppname,String supptype, String date, String supptime){

        this.suppbrand = suppbrand;
        this.suppname = suppname;
        this.supptype = supptype;
        this.date = date;
        this.supptime = supptime;
    }

    public String getSuppbrand() {
        return suppbrand;
    }

    public void setSuppbrand(String suppbrand) {
        this.suppbrand = suppbrand;
    }

    public String getSuppname() {
        return suppname;
    }

    public void setSuppname(String suppname) {
        this.suppname = suppname;
    }

    public String getSupptype() {
        return supptype;
    }

    public void setSupptype(String supptype) {
        this.supptype = supptype;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSupptime() {
        return supptime;
    }

    public void setSupptime(String supptime) {
        this.supptime = supptime;
    }
}
