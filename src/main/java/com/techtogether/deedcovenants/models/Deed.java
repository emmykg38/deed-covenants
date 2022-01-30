package com.techtogether.deedcovenants.models;




import javax.persistence.Entity;
import java.io.File;
import java.sql.Date; //note: this used sql.Date, not java.util.Date -- I don't know which would work. May need to change to java.util



@Entity
public class Deed extends AbstractEntity {


    private String name; //eventually set up a name model to allow admin to login + set up one to many relationship

    private String address;

    private String restriction;

    private Date dateOfDeed;

    private Date dateToday;

    private File file;

    public Deed() {}

    public Deed(String name, String address, String restriction, Date dateOfDeed, Date dateToday, File file) {
        this.name = name;
        this.address = address;
        this.restriction = restriction;
        this.dateOfDeed = dateOfDeed;
        this.dateToday = dateToday;
        this.file = file;
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}