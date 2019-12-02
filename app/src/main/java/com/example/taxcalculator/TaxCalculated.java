package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TaxCalculated extends AppCompatActivity {

    CRACustomer customer;
    TextView txtDsin, txtDfullName, txtDgender, txtDgrossIncome,
            txtDtaxFilingDate, txtDfederalTax, txtDprovincialTax, lblcpp,
            lblEmpInsurance, lblRRSPcontri, lblCfRRSP,
            lblTaxableIncome, lblTaxPaid;
    double cpp = 0, ei = 0;  double rrsp = 0, rrspCf = 0, taxableIncome, federalTax,
            provincialTax, totalTaxPaid;
}
