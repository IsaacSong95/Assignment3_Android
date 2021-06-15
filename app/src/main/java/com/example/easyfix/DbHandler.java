package com.example.easyfix;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION =1;
    private static final String DB_NAME = "userdatabase";
    private static final String TABLE_Users ="userdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_FNAME = "fullname";
    private static final String KEY_UNAME = "username";
    private static final String KEY_PAS = "password";
    private static final String KEY_EMA ="email";



    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = " CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_FNAME + " TEXT,"
                + KEY_UNAME + " TEXT,"
                + KEY_PAS + " TEXT,"
                + KEY_EMA + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_Users);
        onCreate(db);

    }

    public int updateUser(String username, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(KEY_EMA,email);
        int result = db.update(TABLE_Users,contentvalues, "username = ?", new String[]{username});
        String strSQL = "UPDATE " + TABLE_Users + " SET " + KEY_EMA + " = \'" + email + "\' WHERE username = \'"+ username + "\'";

        db.execSQL(strSQL);
        return result;
    }
    public void insertUserDetails(String fullname, String username, String password, String email){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(KEY_FNAME,fullname);
        contentvalues.put(KEY_UNAME,username);
        contentvalues.put(KEY_PAS,password);
        contentvalues.put(KEY_EMA,email);

        long newRoWId = db.insert(TABLE_Users, null, contentvalues);
        db.close();
    }


    public ArrayList<HashMap<String, String>> getUsers() {

        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<HashMap<String, String>> userList = new ArrayList<>();

        String query = "SELECT fullname, username, password, email FROM " + TABLE_Users;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("fullname", cursor.getString(cursor.getColumnIndex(KEY_FNAME)));
            user.put("username", cursor.getString(cursor.getColumnIndex(KEY_UNAME)));
            user.put("password", cursor.getString(cursor.getColumnIndex(KEY_PAS)));
            user.put("email", cursor.getString(cursor.getColumnIndex(KEY_EMA)));

            userList.add(user);


        }

        return userList;
    }


    public boolean checkUserExist(String username, String password){
        String[] columns = {"username"};
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = "username=? and password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_Users, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }
    public void delete(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_Users + " WHERE username = \'"+ username + "\'");
    }

}
