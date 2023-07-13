package com.example.shape;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button leave_button , crash_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leave_button=findViewById(R.id.leave_button);
        crash_button=findViewById(R.id.crash_button);

        leave_button.setOnClickListener(view -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Leave the app");
            builder.setMessage("Are you sure you wanna leave the app?");
            builder.setPositiveButton("Yes", (dialogInterface, i) -> finish());
            builder.setNegativeButton("No",null);
            builder.show();
        });
        crash_button.setOnClickListener(view -> {
            try {
                crash_button.setText(null);
            }
            catch (Exception e)
            {
                Log.e("crash button","Error : "+e.getMessage());
            }
        });
    }
}