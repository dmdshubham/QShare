package com.karunendu.qshare.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.karunendu.qshare.R;
import com.karunendu.qshare.data.QuestionData;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Freeware Sys on 3/24/2017.
 */

public class MyQuestionAdapter extends BaseAdapter
{
    ArrayList<QuestionData> dataList;
    LayoutInflater inflater;
    public MyQuestionAdapter(LayoutInflater inflater,ArrayList<QuestionData> dataList)
    {
        this.dataList=dataList;
        this.inflater=inflater;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public QuestionData getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return dataList.get(i).getQid();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null)
        {
            view=inflater.inflate(R.layout.item_ask_question,viewGroup,false);
        }
        TextView tvTitle=(TextView)view.findViewById(R.id.item_title);
        TextView tvCount=(TextView)view.findViewById(R.id.item_count);
        tvTitle.setText(getItem(i).getQuestion());
        tvCount.setText(getItem(i).getCount()+"");
        return view;
    }
}
