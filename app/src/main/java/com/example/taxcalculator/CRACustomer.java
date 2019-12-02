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

    public String getSinNumber() {
        return sinNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {

        return lastName.toUpperCase() + ", " +
                firstName.substring(0,1).toUpperCase() + firstName.substring(1);
    }

    public String getGender(){
        return  gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public Date getFilingDate() {
        return filingDate;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public double getEmpInsurance() {
        return empInsurance;
    }

    public double getRrspContri() {
        return rrspContri;
    }

    public double getRrspCarryForward() {
        return rrspCarryForward;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public double getTaxPaid() {
        return taxPaid;
    }

    public double getFederalTax() {
        return federalTax;
    }

    public double getProvicialTax() {
        return provicialTax;
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
