package com.karunendu.qshare.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.karunendu.qshare.R;
import com.karunendu.qshare.data.AnswerData;

import java.util.ArrayList;

/**
 * Created by Freeware Sys on 4/1/2017.
 */

public class AnsQuestionAdapter extends BaseAdapter {
    ArrayList<AnswerData> datalist;
    LayoutInflater inflater;

    public AnsQuestionAdapter(LayoutInflater inflater,ArrayList<AnswerData> datalist)
    {
        this.datalist=datalist;
        this.inflater=inflater;
    }


    @Override
    public int getCount() {
        return  datalist.size();
    }

    @Override
    public AnswerData getItem(int i) {
        return datalist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return datalist.get(i).getQid();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        if(view==null)
        {
            view=inflater.inflate(R.layout.item_get_question,viewGroup,false);
        }
        TextView tvTitle=(TextView)view.findViewById(R.id.item_title);
        TextView tvCount=(TextView)view.findViewById(R.id.item_count);
        tvTitle.setText(getItem(i).getQuestion());
      // tvCount.setText(getItem(i).getCount()+"");
        return view;
    }
}
