package com.karunendu.qshare;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.github.barteksc.pdfviewer.PDFView;
import com.karunendu.qshare.data.AnswerData;
import com.karunendu.qshare.data.MaterialData;
import com.karunendu.qshare.util.ConstantIds;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.BufferedInputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class FacultyCornerDetailsActivity extends AppCompatActivity {
    MaterialData data;
    Button btnText,btnFile;
    TextView text;
    ImageView image;
    WebView pdfView;
    View textContaner,fileContaner;
    ProgressBar pb;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_corner_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        data=(MaterialData) getIntent().getSerializableExtra("data");
        ImageLoader imageLoader = ImageLoader.getInstance();
        if(data==null)
        {
            finish();
            return;
        }
        ActionBar ab=getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));
        View view=getLayoutInflater().inflate(R.layout.action_bar_home,null);
        TextView titleText=(TextView)view.findViewById(R.id.titleText);
        titleText.setText(""+data.getTitle());
        ActionBar.LayoutParams lp=new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );

        ab.setCustomView(view,lp);

        btnText=(Button)findViewById(R.id.text_btn);
        btnFile=(Button)findViewById(R.id.file_btn);

        text=(TextView)findViewById(R.id.text1);
        image=(ImageView)findViewById(R.id.image1);
        pdfView=(WebView) findViewById(R.id.pdfView1);
        fileContaner=findViewById(R.id.file_container);
        textContaner=findViewById(R.id.text_container);
        pb=(ProgressBar)findViewById(R.id.progressBar);
        String url= ConstantIds.BASE_URL+data.getFile();
        text.setText(data.getText());
      //  Toast.makeText(this,url,Toast.LENGTH_LONG).show();
        if(data.getFile().toLowerCase().contains(".pdf"))
        {
            pdfView.setVisibility(View.VISIBLE);
            pb.setVisibility(View.GONE);
            pdfView.getSettings().setJavaScriptEnabled(true);

            pdfView.loadUrl("http://docs.google.com/gview?embedded=true&url=" + url);
        }
        else if(data.getFile().toLowerCase().contains(".png")
                || data.getFile().toLowerCase().contains(".jpg")
                ||data.getFile().toLowerCase().contains(".jpeg"))
        {
              //image.setVisibility(View.VISIBLE);
            // imageLoader.displayImage(url,image);

            pdfView.setVisibility(View.VISIBLE);
            pb.setVisibility(View.GONE);
            pdfView.getSettings().setJavaScriptEnabled(true);
            String link ="www.antennahouse.com/XSLsample/pdf/sample-link_1.pdf";
            pdfView.loadUrl("http://docs.google.com/gview?embedded=true&url=" + url);
        }
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    class FileLoader extends AsyncTask<String,String,File>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected  File doInBackground(String... params) {
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;

            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            File directory = cw.getDir("UserFile", Context.MODE_PRIVATE);
            if (!directory.exists())
                directory.mkdir();
            String filename = params[0].substring(params[0].lastIndexOf("/") + 1);
            File file = new File(directory, filename);

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                int fileLength = connection.getContentLength();
                input = connection.getInputStream();
                output = new FileOutputStream(file);
                byte data[] = new byte[4096];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
                connection.disconnect();
            }
            catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                return null;
            }
            return file;

        }

        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);
            if(file!=null && file.exists())
            {
                // pdfView.fromFile(file);
                pb.setVisibility(View.GONE);
            }
            else
            {
                pb.setVisibility(View.GONE);
            }
        }
    }


}
