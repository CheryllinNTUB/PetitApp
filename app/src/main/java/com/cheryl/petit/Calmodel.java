package com.cheryl.petit;

public class Calmodel {
    String petname,foodtype,foodname,eattotalcal,mealkind,dated,recal;


    public Calmodel(){}
    public Calmodel(String petname,String foodtype,String foodname,String eattotalcal,String mealkind,String dated,String recal){

        this.petname = petname;
        this.foodtype = foodtype;
        this.foodname = foodname;
        this.eattotalcal = eattotalcal;
        this.mealkind = mealkind;
        this.dated = dated;
        this.recal = recal;
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

    public String getMealkind() {
        return mealkind;
    }

    public void setMeal(String mealkind) {
        this.mealkind = mealkind;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getRecal() {
        return recal;
    }

    public void setRecal(String recal) {
        this.recal = recal;
    }
}
