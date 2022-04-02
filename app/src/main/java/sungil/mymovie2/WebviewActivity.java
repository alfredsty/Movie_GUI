package sungil.mymovie2;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebviewActivity extends AppCompatActivity {

	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);

		Intent intent = getIntent();
		if (null != intent) {
			String url = intent.getStringExtra("url");
			webView = findViewById(R.id.webview_library);
			webView.loadUrl(url);
			webView.setWebViewClient(new WebViewClient());
			webView.getSettings().setJavaScriptEnabled(true);
		}
	}
}






