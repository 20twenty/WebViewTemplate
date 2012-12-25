package com.liketivist.webviewtemplate;

import com.liketivist.webviewtemplate.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
   
   private WebView mWebView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
            
      mWebView = (WebView)findViewById(R.id.wvMain);
      
      mWebView.setWebViewClient(new WebViewClient());
      mWebView.setWebChromeClient(new WebChromeClient());
      
      mWebView.setFocusable(true);
      mWebView.setFocusableInTouchMode(true);
      mWebView.getSettings().setJavaScriptEnabled(true);
      mWebView.getSettings().setPluginsEnabled(true);
      mWebView.getSettings().setRenderPriority(RenderPriority.HIGH);
      mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
      mWebView.getSettings().setDomStorageEnabled(true);
      mWebView.getSettings().setDatabaseEnabled(true);
      mWebView.getSettings().setAppCacheEnabled(true);
      mWebView.getSettings().setBuiltInZoomControls(true);
      mWebView.getSettings().setSupportZoom(true);
      
      mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
      //mWebView.getSettings().setDatabaseEnabled(true);
      //mWebView.getSettings().setDatabasePath("/data/data/" + getApplicationContext().getPackageName() + "/databases/");
      
   }

   @Override
   protected void onResume() {
      // TODO Auto-generated method stub
      super.onResume();
      //mWebView.loadUrl("http://www.html5test.com/");
      //mWebView.loadUrl("http://html5.litten.com/how-to-drag-and-drop-on-an-html5-canvas/");
      mWebView.loadUrl("file:///android_asset/test.html");
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.activity_main, menu);
      return true;
   }

}
