package com.karunendu.qshare;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.karunendu.qshare.fac_farg.FragmentCCEAMS;
import com.karunendu.qshare.fac_farg.FragmentFacEedit;
import com.karunendu.qshare.fac_farg.FragmentHome;
import com.karunendu.qshare.fac_farg.FragmentSchedule;
import com.karunendu.qshare.fac_farg.FragmentSetting;
import com.karunendu.qshare.fac_farg.FragmentUpload;
import com.karunendu.qshare.std_farg.GetQuestionFragment;
import com.karunendu.qshare.util.ConstantIds;
import com.karunendu.qshare.util.GlobalData;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class FacultyPanelActivity extends AppCompatActivity {
    WebView wv;
    TextView titleText;
    DrawerLayout drawer;
    CircularImageView profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_panel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab=getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));
        LayoutInflater inflater=getLayoutInflater();

      //  wv=(WebView)findViewById(R.id.ams);
      //  wb.loadUrl("file:///android_asset/AboutUs.html");

        View view=inflater.inflate(R.layout.action_bar_home,null);
        titleText=(TextView)view.findViewById(R.id.titleText);

        profile=(CircularImageView)findViewById(R.id.slide_profile_image);
        SharedPreferences sp=getSharedPreferences(ConstantIds.APP_PREF, Context.MODE_PRIVATE);
        String url1=sp.getString(ConstantIds.FAC_PROFILE,null);

        //sp url
        //String url=ConstantIds.FAC_PROFILE;
        if(url1!=null) {
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(url1, profile);
        }
        titleText.setText("Home");
        ActionBar.LayoutParams lp=new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );
        ab.setCustomView(view,lp);
        TextView tvName=(TextView)findViewById(R.id.slide_profile_name);
        TextView tvEmail=(TextView)findViewById(R.id.slide_profile_email);
        tvEmail.setText(GlobalData.email);
        tvName.setText(GlobalData.name);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new FragmentHome());
        ft.commit();
        titleText.setText("Home");
    }

    private void replaceFragment(Fragment frg)
    {
        FragmentManager manager =getSupportFragmentManager();
        FragmentTransaction ft=manager.beginTransaction();

        ft.replace(R.id.container,frg);
        ft.commit();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void onEdit(View vc)
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            if(isReadStorageAllowed())
            {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new FragmentFacEedit());
                ft.addToBackStack(null);
                ft.commit();
                titleText.setText("Edit Profile");
                drawer.closeDrawer(GravityCompat.START);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1001);
            }
        }
        else {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container, new FragmentFacEedit());
            ft.addToBackStack(null);
            ft.commit();
            titleText.setText("Edit Profile");
            drawer.closeDrawer(GravityCompat.START);
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
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.container, new FragmentFacEedit());
                        ft.commit();
                        titleText.setText("Edit Profile");
                        drawer.closeDrawer(GravityCompat.START);
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
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.container, new FragmentHome());
                        ft.commit();
                        titleText.setText("Settings");
                        drawer.closeDrawer(GravityCompat.START);
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
        getMenuInflater().inflate(R.menu.faculty_panel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id==R.id.action_logout)
        {
            processLogout();
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void processLogout()
    {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setMessage("Are you sure, you want to logout?");
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences sp=getSharedPreferences(ConstantIds.APP_PREF,MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.clear();
                editor.commit();
                Intent intent=new Intent(FacultyPanelActivity.this, UserTypeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
        b.setNegativeButton("No",null);
        b.show();
    }


    public void onHome(View v)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new FragmentHome());
        ft.commit();
        titleText.setText("Home");
        drawer.closeDrawers();
    }
    public void onSchedule(View v)
    {
        FragmentSchedule frg=new FragmentSchedule();
        replaceFragment(frg);
        drawer.closeDrawers();
    }

    public void onCCEAMS(View v)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,new FragmentCCEAMS());
        ft.addToBackStack(null);
        ft.commit();
        titleText.setText("CCEAMS");
        drawer.closeDrawer(GravityCompat.START);
    }
    public void onNotify(View v)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new GetQuestionFragment());
        ft.addToBackStack(null);
        ft.commit();
        titleText.setText("Give Answer");

        drawer.closeDrawer(GravityCompat.START);}
    public void onUpload(View v)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new FragmentUpload());
        ft.addToBackStack(null);
        ft.commit();
        titleText.setText("Share Study Material");

        drawer.closeDrawer(GravityCompat.START);
    }
    public void onSetting(View v)
    {
        drawer.closeDrawers();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            if(isReadLoactionAllowed())
            {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new FragmentHome());
                ft.commit();
                titleText.setText("Settings");

            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1002);
            }

        }
        else {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container,new FragmentHome());
            ft.addToBackStack(null);
            ft.commit();
            titleText.setText("Settings");
        }


    }
    public void onLogout(View v)
    {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setMessage("Are you sure, you want to logout?");
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences sp=getSharedPreferences(ConstantIds.APP_PREF,MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.clear();
                editor.commit();
                Intent intent=new Intent(FacultyPanelActivity.this, UserTypeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
        b.setNegativeButton("No",null);
        b.show();
        drawer.closeDrawers();
    }

}
