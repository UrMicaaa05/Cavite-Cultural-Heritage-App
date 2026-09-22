package com.example.finalmadexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "register.db";
    private static final String TABLE_NAME = "person";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                "name TEXT, " +
                "dob TEXT, " +
                "aadhar_number TEXT PRIMARY KEY, " +
                "city TEXT, " +
                "state TEXT, " +
                "pincode TEXT, " +
                "phone_number TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean insertData(String name, String dob, String aadhar_number,
                              String city, String state, String pincode, String phone_number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();
        cv.put("name",          name.trim());
        cv.put("aadhar_number", aadhar_number.trim());
        cv.put("dob",           dob.trim());
        cv.put("city",          city.trim());
        cv.put("state",         state.trim());
        cv.put("pincode",       pincode.trim());
        cv.put("phone_number",  phone_number.trim());
        long result = db.insert(TABLE_NAME, null, cv);
        return result != -1;
    }

    public Boolean checkaadhar(String aadhar_number) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE TRIM(aadhar_number) = ?",
                new String[]{aadhar_number.trim()});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public Boolean checkPhone(String phone_number) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE TRIM(phone_number) = ?",
                new String[]{phone_number.trim()});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
}