package com.karunendu.qshare;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karunendu.qshare.std_farg.StdAskQuestionFragment;
import com.karunendu.qshare.std_farg.StdAskQuestionListFragment;

public class StdAskQuestionActivity extends AppCompatActivity {
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_ask_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab=getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));
        View view=getLayoutInflater().inflate(R.layout.action_bar_home,null);
        TextView titleText=(TextView)view.findViewById(R.id.titleText);
        titleText.setText("Ask Question");
        ActionBar.LayoutParams lp=new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );
        ab.setCustomView(view,lp);

        pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new QuestionPagerAdapter(getSupportFragmentManager()));
    }
         @Override
         public boolean onOptionsItemSelected(MenuItem item) {
          if(item.getItemId()==android.R.id.home)
            {
               onBackPressed();
             }
          return super.onOptionsItemSelected(item);
       }

    class QuestionPagerAdapter extends FragmentPagerAdapter

    {
        public QuestionPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            if(position==0)
            {
                return new StdAskQuestionFragment();

            }
            else
            {
                return new StdAskQuestionListFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
    public Fragment onAsk(View v)
    {
        AlertDialog.Builder b=new AlertDialog.Builder(getBaseContext());
        b.setTitle("Error!");
        b.setMessage("Ask");
        b.setPositiveButton("OK",null);
        b.show();
        return new StdAskQuestionFragment();
    }
    public Fragment onAsked(View v)
    {
        return new StdAskQuestionListFragment();
    }

}
