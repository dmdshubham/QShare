package com.karunendu.qshare.std_farg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.manager.RequestManager;
import com.android.volley.manager.RequestMap;
import com.karunendu.qshare.R;

import com.karunendu.qshare.StudentPostAnswer;
import com.karunendu.qshare.adapters.AnsQuestionAdapter;
import com.karunendu.qshare.data.AnswerData;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Freeware Sys on 4/1/2017.
 */

public class GetQuestionFragment extends Fragment implements RequestManager.RequestListener,View.OnClickListener,AdapterView.OnItemClickListener
 {
    ProgressDialog pd;
    ListView listView;
    ArrayList<AnswerData> dataList;
    AnsQuestionAdapter adapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_get_question,container,false);
        listView=(ListView)view.findViewById(R.id.list);
        dataList=new ArrayList<>();
        adapter=new AnsQuestionAdapter(inflater,dataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        String url= ConstantIds.BASE_URL+"get_question.php";
        RequestMap map=new RequestMap();
        map.put("faculty",String.valueOf(GlobalData.id));
        RequestManager.getInstance().post(url,map,this,1);
        return view;
    }
    @Override
    public void onRequest() {
        pd=new ProgressDialog(getActivity());
        pd.setMessage("Please wait...");
        pd.show();
    }
    @Override
    public void onSuccess(String response, Map<String, String> headers, String url, int actionId) {
        pd.dismiss();
       try{
           JSONObject obj=new JSONObject(response);
           int status = obj.getInt("status");
           String msg = obj.getString("message");
                    if(obj.getInt("status")==1)
           {
               JSONArray array=obj.getJSONArray("data");
               for(int i=0;i<array.length();i++)
               {
                   JSONObject item=array.getJSONObject(i);
                   AnswerData ad=new AnswerData();
                   ad.setId(item.getInt("id"));
                   ad.setSid(item.getInt("sid"));
                   ad.setQid(item.getInt("id"));
                   ad.setQuestion(item.getString("question"));
                   ad.setFile(item.getString("file"));
                   ad.setDateTime(item.getString("datetime"));

                   dataList.add(ad);
               }
               adapter.notifyDataSetChanged();
           }
       }
       catch(Exception ex){
       }
    }
    @Override
    public void onError(String errorMsg, String url, int actionId) {
        pd.dismiss();
        AlertDialog.Builder b=new AlertDialog.Builder(getActivity());
        b.setTitle("Error!");
        b.setMessage(errorMsg);
        b.setPositiveButton("OK",null);
        b.show();
    }
    public void queSelect(View v)
    {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("Alert!");
        b.setMessage("Answer the question");
        b.setPositiveButton("OK", null);
        b.show();
    }
    @Override
    public void onClick(View view) {
    }
     @Override
     public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
         TextView question = (TextView) view.findViewById(R.id.item_title);
         long ls=adapterView.getItemIdAtPosition(i);
        String text = question.getText().toString();
         Intent intent = new Intent(getActivity(),StudentPostAnswer.class);
         intent.putExtra("question",text);
         intent.putExtra("Id",ls);
         startActivity(intent);

     }
 }
