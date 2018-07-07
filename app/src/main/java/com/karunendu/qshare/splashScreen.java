package com.karunendu.qshare;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;
import com.nostra13.universalimageloader.utils.IoUtils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class splashScreen extends AppCompatActivity {
   private GifImageView gifImageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        gifImageView=(GifImageView)findViewById(R.id.GifImageView);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setSystemUiVisibility(progressBar.VISIBLE);
        try{
            InputStream inputstream =getAssets().open("splash_gif.gif");
                    byte[] bytes= IOUtils.toByteArray(inputstream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex)
        {

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            splashScreen.this.startActivity(new Intent(splashScreen.this,MainActivity.class));
                splashScreen.this.finish();
            }
        },3000);

    }
}
