package com.karunendu.qshare.fac_farg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.karunendu.qshare.R;

/**
 * Created by Karunendu Mishra on 11/6/2016.
 */
public class FragmentHome extends Fragment
{
    WebView wv;
    LayoutInflater inflater;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater=inflater;
        View view=inflater.inflate(R.layout.fragment_fac_home,container,false);
        wv=(WebView)view.findViewById(R.id.wv);
        wv.loadUrl("file:///android_asset/Home.html");
        // Enable Javascript
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        wv.setWebViewClient(new WebViewClient());


        return view;
    }
}
