package com.example.beachy.contactsapplication;

/**
 * Created by Beachy on 2/3/2016.
 */
public class NumberDTO {
    String worknumber;
    String homenumber;
    String mobilenumber;

    public NumberDTO(String worknumber, String homenumber, String mobilenumber) {
        this.worknumber = worknumber;
        this.homenumber = homenumber;
        this.mobilenumber = mobilenumber;
    }

    public String getWorknumber() {
        return worknumber;
    }

    public void setWorknumber(String worknumber) {
        this.worknumber = worknumber;
    }

    public String getHomenumber() {
        return homenumber;
    }

    public void setHomenumber(String homenumber) {
        this.homenumber = homenumber;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
}
