package com.karunendu.qshare.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.karunendu.qshare.R;
import com.karunendu.qshare.data.MaterialData;

import java.util.ArrayList;

/**
 * Created by SpecPC on 1/29/2017.
 */

public class StdMaterialAdapter extends BaseAdapter {
    ArrayList<MaterialData> dataList;
    LayoutInflater inflater;
    View.OnClickListener listener;
    public StdMaterialAdapter(ArrayList<MaterialData> dataList,
            LayoutInflater inflater,
            View.OnClickListener listener) {

        this.dataList=dataList;
        this.inflater=inflater;
        this.listener=listener;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public MaterialData getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.item_std_material,null);
        }
        TextView tvTitle=(TextView)convertView.findViewById(R.id.item_title);
        TextView tvSubject=(TextView)convertView.findViewById(R.id.item_subject);
        TextView tvName=(TextView)convertView.findViewById(R.id.item_name);
        TextView tvEmail=(TextView)convertView.findViewById(R.id.item_email);
        TextView tvPhone=(TextView)convertView.findViewById(R.id.item_phone);
        ImageView ivIcon=(ImageView)convertView.findViewById(R.id.item_image);
        ImageView ivExp=(ImageView)convertView.findViewById(R.id.item_expand);
        ivExp.setOnClickListener(listener);
        MaterialData data=getItem(position);
        String title=data.getTitle();
        tvTitle.setText(data.getTitle());
        tvName.setText(data.getFacName());
        tvEmail.setText(data.getFacEmail());
        tvSubject.setText(data.getSubject());
        tvPhone.setText(data.getFacPhone());
        if(data.getFile().contains("pdf"))
        {
            ivIcon.setImageResource(R.drawable.icn_pdf);
        }
        else if(data.getFile().contains("png") || data.getFile().contains("jpg") || data.getFile().contains("jpeg") || data.getFile().contains("bmp"))
        {
            ivIcon.setImageResource(R.drawable.icn_image);
        }
        else
        {
            ivIcon.setImageResource(R.drawable.icn_text);
        }
        if(data.isopen())
        {
            convertView.findViewById(R.id.item_fac).setVisibility(View.VISIBLE);
        }
        else
        {
            convertView.findViewById(R.id.item_fac).setVisibility(View.GONE);
        }


        return convertView;
    }
}
