package com.liketivist.webviewtemplate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends Activity {

	private WebView mWebView;
	private InterstitialAd interstitial;
	private boolean interstitialReady;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		interstitialReady = false;
		// Prepare the Interstitial Ad
		interstitial = new InterstitialAd(MainActivity.this);
		// Insert the Ad Unit ID
		interstitial.setAdUnitId("ca-app-pub-123456789/123456789");

		// Locate the Banner Ad in activity_main.xml
		AdView adView = (AdView) this.findViewById(R.id.adView);

		// Request for Ads
		AdRequest adRequest = new AdRequest.Builder()

				// Add a test device to show Test Ads
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.addTestDevice("7E3A32EF8D471FCC0FCFD3ADA8BEE710").build();

		// Load ads into Banner Ads
		adView.loadAd(adRequest);

		// Load ads into Interstitial Ads
		interstitial.loadAd(adRequest);

		// Prepare an Interstitial Ad Listener
		interstitial.setAdListener(new AdListener() {
			public void onAdLoaded() {
				interstitialReady = true;
				displayInterstitial();
			}
		});

		mWebView = (WebView) findViewById(R.id.wvMain);

		mWebView.setWebViewClient(new WebViewClient());
		mWebView.setWebChromeClient(new WebChromeClient());

		mWebView.setFocusable(true);
		mWebView.setFocusableInTouchMode(true);
		mWebView.getSettings().setJavaScriptEnabled(true);
		// mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
		mWebView.getSettings().setRenderPriority(RenderPriority.HIGH);
		mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
		mWebView.getSettings().setDomStorageEnabled(true);
		mWebView.getSettings().setDatabaseEnabled(true);
		mWebView.getSettings().setAppCacheEnabled(true);
		mWebView.getSettings().setBuiltInZoomControls(false);
		mWebView.getSettings().setSupportZoom(true);

		mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		// mWebView.getSettings().setDatabaseEnabled(true);
		// mWebView.getSettings().setDatabasePath("/data/data/" +
		// getApplicationContext().getPackageName() + "/databases/");

	}

	public void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		if (interstitial.isLoaded()) {
			interstitial.show();
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// mWebView.loadUrl("http://www.othervenues.com/");
		// mWebView.loadUrl("http://html5.litten.com/how-to-drag-and-drop-on-an-html5-canvas/");
		//mWebView.loadUrl("file:///android_asset/test.html");
		mWebView.loadUrl("http://www.liketivist.com/DebtPlanner/planner.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
