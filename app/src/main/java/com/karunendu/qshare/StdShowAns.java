package com.karunendu.qshare;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.manager.RequestManager;
import com.android.volley.manager.RequestMap;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class StdShowAns extends AppCompatActivity implements RequestManager.RequestListener{

    Button btnText,btnFile;
    TextView text;
    ImageView image;
    WebView pdfView;
    View textContaner,fileContaner;
    ProgressBar pb;
    ProgressDialog pd;
    String  data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_show_ans);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab=getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));


        View view=getLayoutInflater().inflate(R.layout.action_bar_home,null);
        TextView titleText=(TextView)view.findViewById(R.id.titleText);
        titleText.setText("Answer");
        ActionBar.LayoutParams lp=new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );

        ab.setCustomView(view,lp);

        data=getIntent().getStringExtra("QData");
        btnText=(Button)findViewById(R.id.text_btn);
        btnFile=(Button)findViewById(R.id.file_btn);

        text=(TextView)findViewById(R.id.text1);
        image=(ImageView)findViewById(R.id.image1);
        pdfView=(WebView) findViewById(R.id.pdfView1);
        fileContaner=findViewById(R.id.file_container);
        textContaner=findViewById(R.id.text_container);
        pb=(ProgressBar)findViewById(R.id.progressBar);

        String url = ConstantIds.BASE_URL + "std_get_my_answer.php";
        RequestMap map = new RequestMap();
        map.put("sid",data);
        RequestManager.getInstance().post(url, map, this, 1);
         }

    @Override
    public void onRequest() {
        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.setCancelable(false);
        pd.show();
    }



    @Override
    public void onSuccess(String response, Map<String, String> headers, String url, int actionId) {
        pd.dismiss();
        String ans;
        try {

            JSONObject obj=new JSONObject(response);
            if(obj.getInt("status")==1)
            {
                JSONArray array=obj.getJSONArray("data");
                for(int i=0;i<array.length();i++)
                {
                    JSONObject item=array.getJSONObject(i);
                     ans=item.getString("answer");
                    text.setText(ans);
                }

            }

        }
        catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    @Override
    public void onError(String errorMsg, String url, int actionId) {
        pd.dismiss();
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle("Error!");
        b.setMessage(errorMsg);
        b.setPositiveButton("OK",null);
        b.show();
    }

    public void onFile(View v)
    {
        fileContaner.setVisibility(View.VISIBLE);
        textContaner.setVisibility(View.GONE);
        btnFile.setBackgroundResource(R.color.colorAccent);
        btnText.setBackgroundResource(R.color.colorPrimary);
    }
    public void onText(View v)
    {
        fileContaner.setVisibility(View.GONE);
        textContaner.setVisibility(View.VISIBLE);
        btnText.setBackgroundResource(R.color.colorAccent);
        btnFile.setBackgroundResource(R.color.colorPrimary);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
