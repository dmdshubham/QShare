package com.karunendu.qshare;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserTypeActivity extends AppCompatActivity {
    TextView titleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));
        LayoutInflater inflater=getLayoutInflater();

        View view=inflater.inflate(R.layout.action_bar_home,null);
        titleText=(TextView)view.findViewById(R.id.titleText);
        titleText.setText("Choose Account Type");
        ActionBar.LayoutParams lp=new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );
        ab.setCustomView(view,lp);
        TextView tv1=(TextView)findViewById(R.id.text_for_faculty);
        TextView tv2=(TextView)findViewById(R.id.text_for_student);
        Typeface tf=Typeface.createFromAsset(getAssets(),"font/LHANDW.TTF");
        tv1.setTypeface(tf);
        tv2.setTypeface(tf);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
           onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    public void onStudent(View v)
    {
        Intent intent=new Intent(this,LoginRegStdActivity.class);
        startActivity(intent);
    }
    public void onFaculty(View v)
    {
        Intent intent=new Intent(this,LoginRegActivity.class);
        startActivity(intent);
    }

}