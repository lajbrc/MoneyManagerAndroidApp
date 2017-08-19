package com.example.ljr.myapplication.SpinnerHelper;

/**
 * Created by hment on 4/14/2017.
 */

public class Account_Spinner {
    private String accountName;
    private int accountID;
    private double money;

    public Account_Spinner(){
    }

    public int getAccountID(){
        return accountID;
    }
    public String getAccountName(){
        return accountName;
    }
    public double getMoney(){
        return money;
    }
    public void setAccountID(int accountID){
        this.accountID = accountID;
    }
    public void setAccountName(String accountName){
        this.accountName = accountName;
    }
    public void setMoney(double money){this.money = money;}
    //to display object as a string in spinner
    @Override
    public String toString() {
        return accountName;
    }
}
