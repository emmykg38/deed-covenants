package com.techtogether.deedcovenants.models;

import lombok.Data;
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




}
