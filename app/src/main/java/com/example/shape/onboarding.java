package com.example.shape;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class onboarding extends AppCompatActivity {
    public static final String SharedPreferences="shared_preferences";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding);
        TextView textView1 = findViewById(R.id.text1);
        TextView textView2 = findViewById(R.id.text2);
        Button button = findViewById(R.id.button);


        SharedPreferences pref= getBaseContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();
        Boolean bol = pref.getBoolean("my_boolean_key",false);
        if(bol==true)
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        button.setOnClickListener(view -> {
            editor.putBoolean("my_boolean_key",true);
            editor.apply();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            onboarding.this.finish();
        });
    }
}