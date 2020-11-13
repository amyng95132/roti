package com.example.thk347.neilmed;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            WebView htmlWebView = (WebView)findViewById(R.id.webView);
            htmlWebView.setWebViewClient(new CustomWebViewClient(){
                public void onReceivedSslError (WebView view, SslErrorHandler handler, SslError error) {
                    handler.proceed() ;
                }
            });
            WebSettings webSetting = htmlWebView.getSettings();

//            webSetting.setUserAgentString("Android Webview");
            webSetting.setJavaScriptEnabled(true);
//            webSetting.setDisplayZoomControls(true);
//            webSetting.setLoadWithOverviewMode(true);
//            webSetting.setUseWideViewPort(true);
//            webSetting.getAllowContentAccess();
            webSetting.setDomStorageEnabled(true);
           htmlWebView.loadUrl("https://drive.google.com/drive/folders/1A9fLFkZcywCHZJ6qqFmOBqusqMbvOU_j");
//          htmlWebView.loadUrl("https://neilmed.hje.cloud:82/");
//            htmlWebView.loadUrl("https://www.google.com/");
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
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

            return super.onOptionsItemSelected(item);
        }

        private class CustomWebViewClient extends WebViewClient{
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }


}
