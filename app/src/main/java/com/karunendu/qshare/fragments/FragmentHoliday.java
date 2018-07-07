package com.karunendu.qshare.fragments;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.karunendu.qshare.R;

/**
 * Created by Freeware Sys on 9/20/2017.
 */

public class FragmentHoliday extends Fragment {

    WebView wv;
    ProgressDialog dialog;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_holiday,container,false);
         dialog = ProgressDialog.show(getActivity(), "", "Please wait, Loading Page...", true);
        wv=(WebView)view.findViewById(R.id.hwebview);
        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setAppCacheEnabled(true);
        wv.getSettings().setSupportZoom(true);
        wv.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {}

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                view.setVisibility(View.GONE);
                dialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url){
                dialog.dismiss();
                view.setVisibility(View.VISIBLE);
                String webUrl = wv.getUrl();
            }


        });
        wv.setWebChromeClient(new WebChromeClient());
        // wv.setOnKeyListener(new View.OnKeyListener()
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=http://www.allduniv.ac.in/upload/155722727357f1f9335debd.pdf");
        return view;
    }

}
