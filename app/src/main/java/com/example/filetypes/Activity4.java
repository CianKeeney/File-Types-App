package com.example.filetypes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Activity4 extends AppCompatActivity {
    WebView filewebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        File file_web = (File) getIntent().getExtras().getSerializable("file_name");
        file_web.getUrl();


        filewebView = findViewById(R.id.fileWebView);
        filewebView.loadUrl(file_web.getUrl());

    }

}