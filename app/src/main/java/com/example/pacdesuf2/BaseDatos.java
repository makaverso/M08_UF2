package com.example.pacdesuf2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;


    public BaseDatos (@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createTable = "CREATE TABLE alumno" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "apellido TEXT, " +
                "edad INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int ondVersion, int newVersion) {
    }

    public void insertData(String nombre, String apellido, int edad, Context context){
        SQLiteDatabase escritura = getWritableDatabase(); //objeto para INSERT, UPDATE O DELETE
        String insert = "INSERT INTO alumno (nombre, apellido, edad) VALUES (\""+nombre+"\",\""+apellido+"\","+edad+")";
        //La consulta SQL sería: INSERT INTO alumno (nombre, apellido, edad) VALUES ("nombre","apellido",edad)
        escritura.execSQL(insert);
        escritura.close();

        Toast toast = Toast.makeText(context,"Inserción correcta", Toast.LENGTH_LONG);
        toast.show();
    }

    public String selectData () {
        ArrayList <String> dbArrayList = new ArrayList<String>();
        SQLiteDatabase lectura = this.getReadableDatabase();
        String select = "SELECT * FROM ALUMNO;";
        Cursor cursor = lectura.rawQuery(select, null);
        if (cursor.moveToFirst()){
            do{
                String nombre = cursor.getString(1);
                String apellido = cursor.getString(2);
                String edad = cursor.getString(3);

                dbArrayList.add(nombre + " " + apellido + " --- Edad = " + edad+" años.\n");

            } while (cursor.moveToNext());
        }
        cursor.close();
        String mostrar = dbArrayList.toString();

        return mostrar;
    }

    public void deleteTable(){
        String deleteT = "DELETE FROM alumno;";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(deleteT);

    }

}
