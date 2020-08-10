package com.cheryl.petit;

public class ParkData {

    private String item_id;

    private String ParkAddress;
    private String Parkname;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public ParkData() {
    }

    public ParkData(String parkAddress, String parkname, String item_id) {
        this.ParkAddress = parkAddress;
        this.Parkname = parkname;
    }

    public String getParkAddress() {
        return ParkAddress;
    }

    public void setParkAddress(String parkAddress) {
        this.ParkAddress = parkAddress;
    }

    public String getParkname() {
        return Parkname;
    }

    public void setParkname(String parkname) {
        this.Parkname = parkname;
    }
}
