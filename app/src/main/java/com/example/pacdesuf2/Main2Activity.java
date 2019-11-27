package com.example.pacdesuf2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    BaseDatos bd;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bd = new BaseDatos(this, "m08", null, 1);
        Toast toast = Toast.makeText(this, "BD y tabla creadas", Toast.LENGTH_LONG);
        toast.show();

        textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

    }

    public void insertarDatos(View view) {
        //bd.insertData("Victor", "Martin", 31,this);
        EditText n = findViewById(R.id.editTextNombre);
        String nombre = n.getText().toString();
        EditText a = findViewById(R.id.editTextApellido);
        String apellido = a.getText().toString();
        EditText e = findViewById(R.id.editTextEdad);
        int edad = Integer.parseInt(e.getText().toString());

        bd.insertData(nombre,apellido,edad, this);

        Toast toast = Toast.makeText(this, "Inserción correcta",Toast.LENGTH_LONG);
        toast.show();
    }

    public void mostrarTabla(View view) {
        TextView t = findViewById(R.id.textView);
        String data = bd.selectData();
        bd.close();
        t.setText(data);
    }

    public void borrarTabla(View view){
        bd.deleteTable();
        TextView t = findViewById(R.id.textView);
        t.setText("");
    }

    public void returnMain(View view) {
        finish();
    }


}


