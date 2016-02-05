package com.example.beachy.contactsapplication;

/**
 * Created by Beachy on 2/4/2016.
 */

public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String zip;
    private long lat;
    private long longitude;

    public AddressDTO(String street, String city, String state, String zip, long lat, long longitude) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.lat = lat;
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
