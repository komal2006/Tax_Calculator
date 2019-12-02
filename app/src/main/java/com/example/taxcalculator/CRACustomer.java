package com.example.taxcalculator;


import android.os.Parcelable;

public class CRACustomer implements Parcelable
{
    private String sinNumber,age;
    String fName,lName;
    String fullName;
    String gender;

    public String getGender()
    {
        return gender;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public CRACustomer(String sinNumber, String age, String fName, String lName, String gender)
    {
        this.sinNumber = sinNumber;
        this.age = age;
        this.fName = fName;
        this.lName = lName;
        this.fullName = fullName;
        this.gender = gender;
    }

}
