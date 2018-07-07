package com.karunendu.qshare.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Freeware Sys on 7/5/2017.
 */

public class FacultyNameAdapter extends BaseAdapter {

    ArrayList<String> values;
    LayoutInflater inflater;

    public FacultyNameAdapter(ArrayList<String> values, LayoutInflater inflater) {
        this.values = values;
        this.inflater = inflater;
    }


    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return  values.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view=inflater.inflate(android.R.layout.simple_spinner_item,null);
        }
        TextView tv=(TextView)view;
        tv.setText(values.get(i));
        return view;
    }
}

