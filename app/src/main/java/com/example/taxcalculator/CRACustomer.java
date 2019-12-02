package com.example.taxcalculator;




import java.util.Date;

public class CRACustomer
{
    String sinNumber, firstName, lastName, fullName, gender;
    Date birthDate,filingDate;
    int age;
    double grossIncome, federalTax, provicialTax, empInsurance;
    double rrspContri, rrspCarryForward, taxableIncome, taxPaid;


    public CRACustomer(String sinNumber, String firstName,
                       String lastName, String gender, double grossIncome, double rrspContri)
    {
        this.sinNumber = sinNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.rrspContri = rrspContri;
    }
}
