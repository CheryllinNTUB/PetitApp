package com.cheryl.petit;

public class Weightmodel {
    String petname,petweight,pettype,day_cal;


    public Weightmodel(){}
    public Weightmodel(String petname, String weight, String petkind, String daycal){

        this.petname = petname;
        this.petweight = weight;
        this.pettype = petkind;
        this.day_cal = daycal;

    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getPetweight() {
        return petweight;
    }

    public void setPetweight(String petweight) {
        this.petweight = petweight;
    }

    public String getPettype() {
        return pettype;
    }

    public void setPettype(String pettype) {
        this.pettype = pettype;
    }

    public String getDay_cal() {
        return day_cal;
    }

    public void setDay_cal(String day_cal) {
        this.day_cal = day_cal;
    }
}
