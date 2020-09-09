package com.cheryl.petit;

public class Calmodel {
    String petname,foodtype,foodname,eattotalcal;


    public Calmodel(){}
    public Calmodel(String petname,String foodtype,String foodname,String eattotalcal){

        this.petname = petname;
        this.foodtype = foodtype;
        this.foodname = foodname;
        this.eattotalcal = eattotalcal;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getEattotalcal() {
        return eattotalcal;
    }

    public void setEattotalcal(String eattotalcal) {
        this.eattotalcal = eattotalcal;
    }
}
