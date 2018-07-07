package com.karunendu.qshare.fac_farg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.karunendu.qshare.MainActivity;
import com.karunendu.qshare.R;

/**
 * Created by Freeware Sys on 9/18/2017.
 */

public class FragmentCCEAMS extends Fragment {
        WebView wv;
    ProgressDialog dialog;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
        {
            View view=inflater.inflate(R.layout.fragmentcceams,container,false);
            final ProgressDialog dialog = ProgressDialog.show(getActivity(), "", "Please wait, Loading Page...", true);
           wv=(WebView)view.findViewById(R.id.ams);
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
            wv.loadUrl("http://app.allduniv-ips.in/cceams/mindex.php");
            return view;
        }



}
