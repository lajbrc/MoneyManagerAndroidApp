package com.example.ljr.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ljr.myapplication.DB.CRUD_account;
import com.example.ljr.myapplication.DB.Table_account;
import com.example.ljr.myapplication.ResultType.AccountList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Account extends Fragment {

    private static final int REQ_CODE_EDIT_ACCOUNT = 100;
    private ImageButton addAccountBtn;
    ArrayList<AccountList> accountLists;
    AccountAdapter aAdapter;

    public Account() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View accountView = inflater.inflate(R.layout.fragment_account, container, false);

        //Click "+" button, go to account edit page
        addAccountBtn = (ImageButton) accountView.findViewById(R.id.add_account);
        addAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AccountEditActivity.class);
                startActivityForResult(intent, REQ_CODE_EDIT_ACCOUNT);
            }
        });

        //Fake accounts
//        ArrayList<AccountList> alist = new ArrayList<>();
//        AccountAdapter aAdapter = new AccountAdapter(getActivity(), alist);
//        ListView lv = (ListView) accountView.findViewById(R.id.account_list);
//        lv.setAdapter(aAdapter);
//        AccountList newAccount1 = new AccountList("aaa", 204.0);
//        AccountList newAccount2 = new AccountList("bbb", 2011);
//        aAdapter.add(newAccount1);
//        aAdapter.add(newAccount2);

//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.detach(this).attach(this).commit();

        setUpAccounts(accountView);

        // Inflate the layout for this fragment
        return accountView;
    }

    private void setUpAccounts(View accountView) {
        Session session = new Session(getContext());
        int uid = session.getUid();

        CRUD_account setUpAccount = new CRUD_account(getActivity());
        accountLists = setUpAccount.getAccountList2(uid);
        aAdapter = new AccountAdapter(getActivity(), accountLists);
        ListView lv = (ListView) accountView.findViewById(R.id.account_list);
        aAdapter.notifyDataSetChanged();
        if (accountLists.size() != 0) {
            lv.setAdapter(aAdapter);
        } else {
            Toast.makeText(getActivity(), "No accounts!", Toast.LENGTH_LONG);
        }

    }

//    private void setUpAccount(View accountView, AccountList account) {
//        ImageButton editAccountBtn = (ImageButton) accountView.findViewById(R.id.edit_account_btn);
//        editAccountBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), AccountEditActivity.class);
//                startActivityForResult(intent, REQ_CODE_EDIT_ACCOUNT);
//            }
//        });
//    }

//    private void deleteAccount (int accountId) {
//
//        CRUD_account deleteAccount = new CRUD_account(getActivity());
//        for (int i=0; i < accountLists.size(); i++) {
//            AccountList account = accountLists.get(i);
//            if (account.cardId == accountId) {
//                accountLists.remove(i);
//                deleteAccount.deleteAccountByAid(accountId);
//                break;
//            }
//        }
//
//    }

}
