package com.karunendu.qshare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.manager.RequestManager;
import com.android.volley.manager.RequestMap;
import com.karunendu.qshare.adapters.StdMaterialAdapter;
import com.karunendu.qshare.data.MaterialData;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class FacultyCornerActivity extends AppCompatActivity implements RequestManager.RequestListener,
        View.OnClickListener,AdapterView.OnItemClickListener{

    ProgressDialog pd;
    ArrayList<MaterialData> dataList;
    ListView listView;
    StdMaterialAdapter adapter;
    int lastopen=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_corner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));


        View view=getLayoutInflater().inflate(R.layout.action_bar_home,null);
        TextView titleText=(TextView)view.findViewById(R.id.titleText);
        titleText.setText("Faculty Corner");
        ActionBar.LayoutParams lp=new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );

        ab.setCustomView(view,lp);
        dataList=new ArrayList<>();
        adapter=new StdMaterialAdapter(dataList,getLayoutInflater(),this);
        listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        RequestMap map=new RequestMap();
        map.put("sem",GlobalData.sem);
        map.put("course",GlobalData.courseID);
        String url= ConstantIds.BASE_URL+"std_get_material.php";
        RequestManager.getInstance().post(url,map,this,1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequest() {
        pd=new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.setCancelable(false);
        pd.show();
    }

    @Override
    public void onSuccess(String response, Map<String, String> headers, String url, int actionId) {
        if(pd!=null)
        {
            pd.dismiss();
            pd=null;
        }
        try
        {
            JSONObject obj=new JSONObject(response);
            int status=obj.getInt("status");
            String message=obj.getString("message");
            if(status==1)
            {
                JSONArray array=obj.getJSONArray("data");
                for(int i=0;i<array.length();i++)
                {
                    JSONObject subObj=array.getJSONObject(i);
                    MaterialData data=new MaterialData();
                    data.setId(subObj.getString("id"));
                    data.setFid(subObj.getString("fid"));
                    data.setTitle(subObj.getString("title"));
                    data.setSubject(subObj.getString("subject"));
                    data.setFile(subObj.getString("file"));
                    data.setText(subObj.getString("text"));
                    data.setCourse(subObj.getString("course"));
                    data.setSem(subObj.getString("sem"));
                    data.setDatetime(subObj.getString("datetime"));
                    data.setFacName(subObj.getString("fac_name"));
                    data.setFacEmail(subObj.getString("fac_email"));
                    data.setFacPhone(subObj.getString("fac_phone"));
                    dataList.add(data);
                }
                adapter.notifyDataSetChanged();
            }
            else
            {
                AlertDialog.Builder b=new AlertDialog.Builder(this);
                b.setMessage(message);
                b.setPositiveButton("Ok",null);
                b.show();
            }
        }
        catch (Exception ex){}
    }

    @Override
    public void onError(String errorMsg, String url, int actionId) {
        if(pd!=null)
        {
            pd.dismiss();
            pd=null;
        }
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.item_expand)
        {
            int postion=listView.getPositionForView(v);
            if(lastopen==-1)
            {
                lastopen=postion;
                dataList.get(postion).setIsopen(true);
                adapter.notifyDataSetChanged();
            }
            else if(postion==lastopen)
            {
                lastopen=-1;
                dataList.get(postion).setIsopen(false);
                adapter.notifyDataSetChanged();
            }
            else
            {
                dataList.get(lastopen).setIsopen(false);
                lastopen=postion;
                dataList.get(postion).setIsopen(true);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(this,FacultyCornerDetailsActivity.class);
        MaterialData data=dataList.get(position);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
