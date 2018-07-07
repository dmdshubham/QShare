package com.karunendu.qshare.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Karunendu Mishra on 10/23/2016.
 */
public class SpinnersAdapter extends BaseAdapter {

    ArrayList<String> values;
    LayoutInflater inflater;
    public SpinnersAdapter(ArrayList<String> values,LayoutInflater inflater)
    {
        this.values=values;
        this.inflater=inflater;
    }
    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public String getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=inflater.inflate(android.R.layout.simple_spinner_item,null);
        }
        TextView tv=(TextView)convertView;
        tv.setText(values.get(position));

        return convertView;
    }
}
