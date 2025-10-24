package com.example.androiduitesting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView cityNameView = findViewById(R.id.text_city_name);
        Button backButton = findViewById(R.id.button_back);

        Intent intent = getIntent();
        String cityName = intent.getStringExtra("city_name");

        cityNameView.setText(cityName);

        backButton.setOnClickListener(v -> finish());
    }
}
