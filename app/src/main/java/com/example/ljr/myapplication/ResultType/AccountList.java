package com.example.ljr.myapplication.ResultType;

import com.example.ljr.myapplication.DB.Table_account;

/**
 * Created by LJR on 4/16/17.
 */

public class AccountList {

    public int cardId;
    public String cardName;
    public double money;

//    public AccountList (Table_account account) {
//        cardName = account.accountName;
//        money = account.money;
//    }

    public AccountList (int cardId, String cardName, double money) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.money = money;
    }

}
