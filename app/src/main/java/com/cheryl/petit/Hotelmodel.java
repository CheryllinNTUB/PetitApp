package com.cheryl.petit;

public class Hotelmodel {

    private String item_id;
    private String address;
    private String name;

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Hotelmodel() {
    }

    public Hotelmodel(String Address, String Name, String item_id) {
        this.address = Address;
        this.name = Name;
    }

    public String getHotelname() {
        return name ;
    }

    public void setHotelname(String Name) {
        this.name = Name;
    }

    public String getHotelAddress() {
        return address;
    }

    public void setHotelAddress(String Address) {
        this.address = Address;
    }


}
