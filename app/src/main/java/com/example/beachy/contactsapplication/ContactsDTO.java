package com.example.beachy.contactsapplication;

import java.io.Serializable;

/**
 * Created by Beachy on 2/3/2016.
 */
public class ContactsDTO implements Serializable {
    private String name;
    private int employeeid;
    private String company;
    private DetailsDTO details;
    private String smallImageUrl;
    private String birthdate;
    private NumberDTO numbers;

    public ContactsDTO(String name, int employeeid, String company, DetailsDTO details, String smallImageUrl, String birthdate, NumberDTO numbers) {
        this.name = name;
        this.employeeid = employeeid;
        this.company = company;
        this.details = details;
        this.smallImageUrl = smallImageUrl;
        this.birthdate = birthdate;
        this.numbers = numbers;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public DetailsDTO getDetails() {
        return details;
    }

    public void setDetails(DetailsDTO details) {
        this.details = details;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getWorknumber() {
        return numbers.getWorknumber();
    }

    public void setWorknumber(String worknumber) {
        numbers.setWorknumber(worknumber);
    }

    public String getHomenumber() {
        return numbers.getHomenumber();
    }

    public void setHomenumber(String homenumber) {
        numbers.setHomenumber(homenumber);
    }

    public String getCellnumber() {
        return numbers.getMobilenumber();
    }

    public void setCellnumber(String cellnumber) {
        numbers.setMobilenumber(cellnumber);
    }

}
