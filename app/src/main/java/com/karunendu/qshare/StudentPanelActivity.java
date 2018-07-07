package com.karunendu.qshare;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.manager.RequestManager;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class StudentPanelActivity extends AppCompatActivity
         {

    TextView textName,titleText;
    CircularImageView profile;
    Uri uri;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_panel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab=getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setDisplayShowCustomEnabled(true);
        ab.setHomeButtonEnabled(false);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));
        LayoutInflater inflater=getLayoutInflater();

        View view=inflater.inflate(R.layout.action_bar_home,null);
        titleText=(TextView)view.findViewById(R.id.titleText);
        titleText.setText("Student Panel");
        ActionBar.LayoutParams lp=new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );
        ab.setCustomView(view,lp);

        textName = (TextView) findViewById(R.id.std_name);
        profile = (CircularImageView) findViewById(R.id.std_profile_image);

        SharedPreferences sp=getSharedPreferences(ConstantIds.APP_PREF, Context.MODE_PRIVATE);
        String url1=sp.getString(ConstantIds.STD_PROFILE_PIC,null);
      if(url1!=null) {
          ImageLoader imageLoader = ImageLoader.getInstance();
          imageLoader.displayImage(url1, profile);
      }
        textName.setText(GlobalData.name);
        uri = null;
    }

    public void onFacCorner(View vc) {
        startActivity(new Intent(this, FacultyCornerActivity.class));
    }

    public void onAskQuestion(View v) {
        startActivity(new Intent(this, StdAskQuestionActivity.class));
    }

    public void onAnswer(View v) {
        startActivity(new Intent(this, StdAnswerActivity.class));
    }

      public void onProfileClick(View v)
             {
                 if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
                 {
                     if(isReadStorageAllowed())
                     {
                         startActivity(new Intent(this,StdProfileActivity.class));
//                         FragmentManager fm = getSupportFragmentManager();
//                         FragmentTransaction ft = fm.beginTransaction();
//                         ft.replace(R.id.container, new FragmentFacEedit());
//                         ft.commit();
//                         titleText.setText("Edit Profile");
//                         drawer.closeDrawer(GravityCompat.START);
                     }
                     else
                     {
                         ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1001);
                     }
                 }
                 else
                 {
                     startActivity(new Intent(this,StdProfileActivity.class));
                 }

             }
             private boolean isReadStorageAllowed() {
                 //Getting the permission status
                 int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

                 //If permission is granted returning true
                 if (result == PackageManager.PERMISSION_GRANTED)
                     return true;

                 //If permission is not granted returning false
                 return false;
             }
             private boolean isReadLoactionAllowed() {
                 //Getting the permission status
                 int result = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

                 //If permission is granted returning true
                 if (result == PackageManager.PERMISSION_GRANTED)
                     return true;

                 //If permission is not granted returning false
                 return false;
             }

    @Override


             public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                 super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                 if(requestCode==1001)
                 {
                     if(isReadStorageAllowed())
                     {
                         new Handler().postDelayed(new Runnable() {
                             @Override
                             public void run() {
                                 startActivity(new Intent(getBaseContext(),StdProfileActivity.class));
                             }
                         },1000);
                     }
                     else
                     {
                         ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1001);
                     }
                 }
                 else if(requestCode==1002)
                 {
                     if(isReadLoactionAllowed())
                     {
                         new Handler().postDelayed(new Runnable() {
                             @Override
                             public void run() {
                                 startActivity(new Intent(getBaseContext(),StdProfileActivity.class));
                             }
                         },1000);
                     }
                     else
                     {
                         ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1002);
                     }
                 }
             }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_panel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void logout() {
        AlertDialog.Builder a = new AlertDialog.Builder(this);
        a.setMessage("Are You Sure,You Want To Logout!!! ");
        a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                SharedPreferences sp = getSharedPreferences(ConstantIds.APP_PREF, MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(StudentPanelActivity.this, UserTypeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        a.setNegativeButton("No", null);
        a.show();
    }
}



