package com.example.filetypes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Activity2 extends AppCompatActivity {
    //Button to next activity
    private Button moveForward;
    //ImageView object
    ImageView file_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();

        // Function for next activity
        moveForward = findViewById(R.id.buttonInfo);
        moveForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pass the intent to be used to pull the bundle
                Intent intent=new Intent(Activity2.this, Activity3.class);
                intent.putExtra("file_description", b.getString("file_description"));
                startActivity(intent);
            }
        });

        file_picture = findViewById(R.id.imageView2);
        Integer id = Activity2.this.getResources().getIdentifier(b.getString("file_image"), "drawable", Activity2.this.getPackageName());
        file_picture.setImageResource(id);

    }
}