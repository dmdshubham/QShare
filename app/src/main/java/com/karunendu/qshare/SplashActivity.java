package com.karunendu.qshare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.manager.RequestManager;
import com.android.volley.manager.RequestMap;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;

import org.w3c.dom.Text;

import java.io.StringReader;
import java.util.Map;

public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences sp=getSharedPreferences(ConstantIds.APP_PREF,MODE_PRIVATE);
        int flag=sp.getInt(ConstantIds.LOGIN_FLAG,0);
        if(flag==ConstantIds.NO_LOGIN)
        {
            Intent intent=new Intent(this,UserTypeActivity.class);
            startActivity(intent);
            finish();
        }
        else if(flag==ConstantIds.FAC_LOGIN)
        {
            GlobalData.id=sp.getInt(ConstantIds.FAC_ID,0);
            GlobalData.userType=ConstantIds.FAC_LOGIN;
            GlobalData.name=sp.getString(ConstantIds.FAC_NAME,"");
            GlobalData.email=sp.getString(ConstantIds.FAC_EMAIL,"");;
            GlobalData.phone=sp.getString(ConstantIds.FAC_PHONE,"");;
            GlobalData.dep=sp.getString(ConstantIds.FAC_DEP,"");;
            GlobalData.dsg=sp.getString(ConstantIds.FAC_DSG,"");;
            GlobalData.depId=sp.getString(ConstantIds.FAC_DEPID,"");;
            GlobalData.dsgId=sp.getString(ConstantIds.FAC_DSGID,"");;
            Intent intent=new Intent(this, FacultyPanelActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        else if(flag==ConstantIds.STD_LOGIN)
        {

            GlobalData.id=sp.getInt(ConstantIds.STD_ID,1);
            GlobalData.std_id=sp.getString(ConstantIds.STUDENT_ID,"");
            GlobalData.roll=sp.getString(ConstantIds.STD_ROLL,"");
            GlobalData.name=sp.getString(ConstantIds.STD_NAME,"");
            GlobalData.phone=sp.getString(ConstantIds.STD_PHONE,"");
            GlobalData.email=sp.getString(ConstantIds.STD_EMAIL,"");
            GlobalData.profile_pic=sp.getString(ConstantIds.STD_PROFILE_PIC,"");
            GlobalData.courseID=sp.getString(ConstantIds.STD_COURSEID,"");
            GlobalData.course=sp.getString(ConstantIds.STD_COURSE,"");
            GlobalData.dob=sp.getString(ConstantIds.STD_DOB,"");
            GlobalData.sem=sp.getString(ConstantIds.STD_SEM,"1");

            Intent intent=new Intent(this, StudentPanelActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }




    }









}
