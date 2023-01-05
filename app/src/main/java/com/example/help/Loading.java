package com.example.help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.help.R.id;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setIndeterminate(true);
        TextView text = findViewById(R.id.btnVoltar);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loading.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}