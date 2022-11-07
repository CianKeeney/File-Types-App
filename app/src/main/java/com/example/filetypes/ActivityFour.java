package com.example.filetypes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityFour extends AppCompatActivity {
    WebView filewebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        File file_web = (File) getIntent().getExtras().getString("file_url");
        Bundle b = getIntent().getExtras();

        filewebView = findViewById(R.id.web);

//        WebSettings settings = filewebView.getSettings();
//        settings.setJavaScriptEnabled(true);
//        settings.setAllowContentAccess(true);
//        settings.setDomStorageEnabled(true);
//        filewebView.setWebViewClient(new WebViewClient());
        System.out.println(b.getString("file_url"));
        filewebView.loadUrl(b.getString("file_url"));

    }

}