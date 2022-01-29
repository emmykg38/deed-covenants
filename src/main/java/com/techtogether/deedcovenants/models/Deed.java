package com.techtogether.deedcovenants.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.sql.Date; //note: this used sql.Date, not java.util.Date -- I don't know which would work. May need to change to java.util


@Data
@Entity
public class Deed extends AbstractEntity {

    private String name; //eventually set up a name model to allow admin to login + set up one to many relationship

    private String address;

    private String restriction;

    private Date dateOfDeed;

    private Date dateToday;

    // will need a document here, but I imagine a class will need to be created for it

    public Deed() {}

    public Deed(String name, String address, String restriction, Date dateOfDeed, Date dateToday) {
        this.name = name;
        this.address = address;
        this.restriction = restriction;
        this.dateOfDeed = dateOfDeed;
        this.dateToday = dateToday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public Date getDateOfDeed() {
        return dateOfDeed;
    }

    public void setDateOfDeed(Date dateOfDeed) {
        this.dateOfDeed = dateOfDeed;
    }

    public Date getDateToday() {
        return dateToday;
    }

    public void setDateToday(Date dateToday) {
        this.dateToday = dateToday;
    }
}
