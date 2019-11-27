package com.example.pacdesuf2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Toast toast = Toast.makeText(this, "Activity 3", Toast.LENGTH_LONG);
        toast.show();


    }

    public void startService(View view){
        Intent intent = new Intent(this, MiServicio.class);
        startService(intent);
    }

    public void stopService(View view){
        Intent intent = new Intent(this, MiServicio.class);
        stopService(intent);
    }

    public void returnMain(View view){
        finish();
    }
}