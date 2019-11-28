package com.example.onlineshopproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DB_NAME = "UserRecord";
    private static final int DB_VERSION = 1;
    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_User(u_id INTEGER PRIMARY KEY AUTOINCREMENT, u_name TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean register(UserModel model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("u_name", model.getU_name());
        cv.put("password", model.getPassword());

        try {
            db.insert("tbl_User", null, cv);
            db.close();
            return true;
        }catch (Exception e){
            db.close();
            return false;
        }
    }
}