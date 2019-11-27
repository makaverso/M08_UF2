package com.example.pacdesuf2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(this, "VictorMartinGil", Toast.LENGTH_LONG);
        toast.show();

        //Otra forma de darle acciones a los botones

        /*Button b1 = findViewById(R.id.button_toServices);
        b1.setOnClickListener(new View.OnClickListener(){
             @Override
            public void onClick (View view){
                 Intent intent = new Intent (MainActivity.this, Main3Activity.class);
                 startActivity(intent);
             }
        });*/
    }

    public void toTable(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    public void toServices(View view) {
        Intent intent = new Intent(MainActivity.this, Main3Activity.class);
        startActivity(intent);
    }
}
