package com.example.ljr.myapplication;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ljr.myapplication.DB.CRUD_transaction;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Detail extends Fragment {

    private void  setupUI(@NonNull List<detail_item> detail_items){
        ListView listview = (ListView)getView().findViewById(R.id.list);
        listview.setAdapter(new DetailAdapter(getActivity(),detail_items));
    }
    public Detail() {
    }

    private void detailList(){
    }

    public void goRecord(View view){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView t1 = (TextView)view.findViewById(R.id.test1);

        //get uid
        Session session = new Session(getContext());
        int uid = session.getUid();


        CRUD_transaction trans = new CRUD_transaction(getContext());
        ArrayList<detail_item> detailslist = new ArrayList<>();
        detailslist = trans.getDetailsList(uid);
        ListView listview = (ListView)view.findViewById(R.id.list);
        listview.setAdapter(new DetailAdapter(getActivity(),detailslist));


        return view;
    }

}
