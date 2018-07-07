package com.karunendu.qshare.std_farg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.manager.RequestManager;
import com.android.volley.manager.RequestMap;
import com.karunendu.qshare.FacultyCornerDetailsActivity;
import com.karunendu.qshare.R;
import com.karunendu.qshare.StdShowAns;
import com.karunendu.qshare.adapters.MyQuestionAdapter;
import com.karunendu.qshare.data.QuestionData;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Freeware Sys on 3/6/2017.
 */

public class StdAskQuestionListFragment extends Fragment implements RequestManager.RequestListener,AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<QuestionData> dataList;
    MyQuestionAdapter adapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_std_ask_question_list,container,false);
        listView=(ListView)view.findViewById(R.id.list);
        dataList=new ArrayList<>();
        adapter=new MyQuestionAdapter(inflater,dataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);




        String url = ConstantIds.BASE_URL + "get_my_question.php";
        RequestMap map = new RequestMap();
        map.put("sid", String.valueOf(GlobalData.id));
        RequestManager.getInstance().post(url, map, this, 1);
        return view;
    }

    @Override
    public void onRequest() {

    }

    @Override
    public void onSuccess(String response, Map<String, String> headers, String url, int actionId)
    {
        try
        {
            JSONObject obj=new JSONObject(response);
            if(obj.getInt("status")==1)
            {
                JSONArray array=obj.getJSONArray("data");
                for(int i=0;i<array.length();i++)
                {
                    JSONObject item=array.getJSONObject(i);
                    QuestionData data=new QuestionData();
                    data.setQid(item.getInt("id"));
                    data.setSid(item.getInt("sid"));

                    data.setQuestion(item.getString("question"));
                    data.setFile(item.getString("file"));
                    data.setDateTime(item.getString("datetime"));
                    data.setCourse(item.getInt("course"));
                    data.setSem(item.getInt("sem"));
                    data.setCount(item.getInt("count"));
                    dataList.add(data);
                }
                adapter.notifyDataSetChanged();
            }
        }
        catch (Exception ex)
        {

        }
    }

    @Override
    public void onError(String errorMsg, String url, int actionId) {

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

   int a;


        Intent intent=new Intent(getContext(),StdShowAns.class);
        QuestionData data=dataList.get(position);

        a=data.getQid();
        intent.putExtra("QData",String.valueOf(a));
        intent.putExtra("file",data.getFile());

       // Toast.makeText(getContext(),"Iteam Called="+a,Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
