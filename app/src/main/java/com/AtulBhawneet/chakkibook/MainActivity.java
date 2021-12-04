package com.AtulBhawneet.chakkibook;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteBaseHelper liteDatabase = new SQLiteBaseHelper(this);
        SQLiteDatabase simpleBase = liteDatabase.getReadableDatabase();

        Cursor cursor = simpleBase.rawQuery("SELECT name, price FROM PRODUCTS",new String[]{});

        StringBuilder builder = new StringBuilder();

        if(cursor != null){
            cursor.moveToFirst();
        }
        do{
            String nameQ = cursor.getString(0);
            double priceQ = cursor.getDouble(1);
            builder.append("Name -> " + nameQ + " Price -> " + priceQ + "\n");

            TextView textView = (TextView) findViewById(R.id.textID);

            textView.setText(builder.toString());
        }while (cursor.moveToNext());



    }
}