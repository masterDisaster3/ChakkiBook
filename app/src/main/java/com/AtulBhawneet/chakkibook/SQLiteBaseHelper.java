package com.AtulBhawneet.chakkibook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteBaseHelper extends SQLiteOpenHelper {

    private static final String dbName = "MyDB";
    private static final int version = 1;

    public SQLiteBaseHelper(Context context){
        super(context, dbName, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE PRODUCTS(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, description TEXT, price REAL)";
        db.execSQL(createTable);

        insertData("Chocolate", "Manforce Chocolate dotted condom", 25,db);
        insertData("Mango", "Kamasutra dotted condom", 30,db);
        insertData("Strawberry", "Durex dotted condom", 60,db);

    }


    public void insertData(String name, String description, double price, SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("description", description);
        values.put("price", price);
        db.insert("PRODUCTS", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
