package com.karunendu.qshare;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karunendu.qshare.fragments.FragmentFacLogin;
import com.karunendu.qshare.fragments.FragmentFacReg;
import com.karunendu.qshare.fragments.FragmentForgotPassword;
import com.karunendu.qshare.fragments.FragmentStdLogin;
import com.karunendu.qshare.fragments.FragmentStdReg;

public class LoginRegStdActivity extends AppCompatActivity {

    private TextView titleText;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab=getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));
        LayoutInflater inflater=getLayoutInflater();

        View view=inflater.inflate(R.layout.action_bar_home,null);
        titleText=(TextView)view.findViewById(R.id.titleText);
        titleText.setText("Student Login");
        ActionBar.LayoutParams lp=new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );
        ab.setCustomView(view,lp);
        fab=(FloatingActionButton)findViewById(R.id.fab);



        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction ft= manager.beginTransaction();
        FragmentStdLogin frament=new FragmentStdLogin();
        ft.add(R.id.container,frament);
        ft.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void frogotPasswordClicked()
    {
        titleText.setText("Reset Password");
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction ft= manager.beginTransaction();
        FragmentForgotPassword frament=new FragmentForgotPassword();
        ft.replace(R.id.container,frament);
        ft.commit();
        fab.setVisibility(View.GONE);
    }

    public void BTLClicked()
    {
        titleText.setText("Student Login");
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction ft= manager.beginTransaction();
        FragmentFacLogin frament=new FragmentFacLogin();
        ft.replace(R.id.container,frament);
        ft.commit();
        fab.setVisibility(View.VISIBLE);
    }
    public void onChange(View v)
    {
        String text=titleText.getText().toString();
        if(text.equals("Create Account"))
        {
            titleText.setText("Student Login");
            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction ft= manager.beginTransaction();
            FragmentStdLogin frament=new FragmentStdLogin();
            ft.replace(R.id.container,frament);
            ft.commit();
        }
        else
        {
            titleText.setText("Create Account");
            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction ft= manager.beginTransaction();
            FragmentStdReg frament=new FragmentStdReg();
            ft.replace(R.id.container,frament);
            ft.commit();
        }

    }

}
