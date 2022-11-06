package com.example.filetypes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    //Button to next activity
    private Button moveForward;
    //ImageView object
    TextView file_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        moveForward = findViewById(R.id.buttonLink);
        Bundle b = getIntent().getExtras();

        // Function for next activity
        moveForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pass the intent to be used to pull the bundle
//                Intent intent=new Intent(Activity3.this, Activity4.class);
//                intent.putExtra("file_name", t);
//                startActivity(intent);
            }
        });

        file_text = findViewById(R.id.textView5);
        file_text.setText(b.getString("file_description"));

    }
}