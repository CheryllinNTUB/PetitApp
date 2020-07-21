package com.cheryl.petit;

public class ParkData {

    private String parkName;
    private String parkDescription;

    public ParkData(String parkname,String parkDescription){
        this.parkName = parkname;
        this.parkDescription = parkDescription;
    }

    public String getParkname(){
        return parkName;
    }

    public String getParkDescription(){
        return parkDescription;
    }
}
