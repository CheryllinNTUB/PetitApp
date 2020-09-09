package com.cheryl.petit;


//寵物資料顯示
public class Petmodel {

    private String pethead,userID,petname,petkind,petvariety,petsex,petbirthday;

    public Petmodel(){}
    public Petmodel(String userID, String pethead, String petname, String petkind, String petvariety, String petsex, String petbirthday) {

        this.userID = userID;
        this.pethead = pethead;
        this.petname = petname;
        this.petkind = petkind;
        this.petvariety = petvariety;
        this.petsex = petsex;
        this.petbirthday = petbirthday;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }


   public String getPethead() {
        return pethead;
    }

    public void setPethead(String pethead) {
        this.pethead = pethead;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getPetkind() {
        return petkind;
    }

    public void setPetkind(String petkind) {
        this.petkind = petkind;
    }

    public String getPetvariety() {
        return petvariety;
    }

    public void setPetvariety(String petvariety) {
        this.petvariety = petvariety;
    }

    public String getPetsex() {
        return petsex;
    }

    public void setPetsex(String petsex) {
        this.petsex = petsex;
    }

    public String getPetbirthday() {
        return petbirthday;
    }

    public void setPetbirthday(String petbirthday) {
        this.petbirthday = petbirthday;
    }
}
