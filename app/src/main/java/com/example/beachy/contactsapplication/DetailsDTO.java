package com.example.beachy.contactsapplication;

import java.util.PriorityQueue;

/**
 * Created by Beachy on 2/3/2016.
 */
public class DetailsDTO {
    private int empID;
    private boolean favorite;
    private String lrgImageURL;
    private String email;
    private String website;
    private AddressDTO address;

    public DetailsDTO(int empID, boolean favorite, String lrgImageURL, String email, String website, AddressDTO address) {
        this.empID = empID;
        this.favorite = favorite;
        this.lrgImageURL = lrgImageURL;
        this.email = email;
        this.website = website;
        this.address = address;
    }

    public int getEmpID() {

        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getLrgImageURL() {
        return lrgImageURL;
    }

    public void setLrgImageURL(String lrgImageURL) {
        this.lrgImageURL = lrgImageURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
