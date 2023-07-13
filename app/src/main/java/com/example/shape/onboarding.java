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
    private TextView textView1;
    private TextView textView2;
    private Button button;
    public static final String SharedPreferences="shared_preferences";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding);
        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        button=findViewById(R.id.button);


        SharedPreferences pref= getBaseContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();
        Boolean bol = pref.getBoolean("my_boolean_key",false);
        if(bol==true)
        {

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean("my_boolean_key",true);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}