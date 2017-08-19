package com.example.ljr.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hment on 4/3/2017.
 */

public class ListConverter {
    private Context context;
    private List<detail_item> data;


    public ListConverter(@NonNull Context context, @NonNull List<detail_item> data){
        this.context = context;
        this.data = data;
    }

    public View getView(int position){
        View view = LayoutInflater.from(context).inflate(R.layout.detail_item,null);
        detail_item detail = data.get(position);
        TextView test = (TextView)view.findViewById(R.id.account_name);
        ((TextView)view.findViewById(R.id.account_name)).setText(detail.account_name);
        ((TextView)view.findViewById(R.id.type)).setText(detail.type);
        ((TextView)view.findViewById(R.id.income_or_expense)).setText(detail.in_or_out);
        ((TextView)view.findViewById(R.id.num)).setText(String.valueOf(detail.num));

        return view;
    }
}
