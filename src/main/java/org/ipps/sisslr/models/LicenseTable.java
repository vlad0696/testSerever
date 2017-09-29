package org.ipps.sisslr.models;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by Gramovich_V on 11.09.2017.
 */
public class LicenseTable implements Serializable {

    private BigInteger id;

    private String NumberForm;

    private String Desiction;

    private String Activities;

    private String name;

    private  BigInteger UNP;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNumberForm() {
        return NumberForm;
    }

    public void setNumberForm(String numberForm) {
        NumberForm = numberForm;
    }

    public String getDesiction() {
        return Desiction;
    }

    public void setDesiction(String desiction) {
        Desiction = desiction;
    }

    public String getActivities() {
        return Activities;
    }

    public void setActivities(String activities) {
        Activities = activities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getUNP() {
        return UNP;
    }

    public void setUNP(BigInteger UNP) {
        this.UNP = UNP;
    }
}
