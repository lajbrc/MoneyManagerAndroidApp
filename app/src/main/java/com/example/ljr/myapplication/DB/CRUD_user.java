package com.example.ljr.myapplication.DB;

/**
 * Created by hment on 4/12/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class CRUD_user {
    private DBHelper2 dbHelper;

    public CRUD_user(Context context){
        dbHelper=new DBHelper2(context);
    }

    //insert
    public int insertUserInfo(Table_UserInfo user){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Table_UserInfo.KEY_Password, user.password);
        values.put(Table_UserInfo.KEY_Uname, user.userName);
        long uid = db.insert(Table_UserInfo.TABLE,null,values);
        db.close();
        return (int)uid;
    }
    //delete
    public void delete(int uid){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.delete(Table_UserInfo.TABLE,Table_UserInfo.KEY_uid + " =?", new String[]{String.valueOf(uid)});
        db.close();
    }
    //select whole list
    public ArrayList<HashMap<String,String>> getAllUsers(){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String selectAll = "SELECT " +
                Table_UserInfo.KEY_uid + "," +
                Table_UserInfo.KEY_Uname + "," +
                Table_UserInfo.KEY_Password + "," +
                "FROM " + Table_UserInfo.TABLE;
        ArrayList<HashMap<String, String>> AllUsers = new ArrayList<HashMap<String, String>>();
        Cursor cursor=db.rawQuery(selectAll,null);

        if(cursor.moveToFirst()) {
            do {
                HashMap<String, String> users = new HashMap<String, String>();
                users.put("uid", cursor.getString(cursor.getColumnIndex(Table_UserInfo.KEY_uid)));
                users.put("username", cursor.getString(cursor.getColumnIndex(Table_UserInfo.KEY_Uname)));
                users.put("password", cursor.getString(cursor.getColumnIndex(Table_UserInfo.KEY_Password)));
                AllUsers.add(users);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return AllUsers;
    }
    //select by PK
    public Table_UserInfo getUserById(int uid) {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String selectUser="SELECT "+
                Table_UserInfo.KEY_uid + "," +
                Table_UserInfo.KEY_Uname + "," +
                Table_UserInfo.KEY_Password +
                " FROM " + Table_UserInfo.TABLE + " WHERE " + Table_UserInfo.KEY_uid + "=?";
        //int iCount = 0;
        Table_UserInfo user = new Table_UserInfo();
        Cursor cursor = db.rawQuery(selectUser, new String[] {String.valueOf(uid)});
        if(cursor.moveToFirst()) {
            do {
                user.uid = cursor.getInt(cursor.getColumnIndex(Table_UserInfo.KEY_uid));
                user.userName = cursor.getString(cursor.getColumnIndex(Table_UserInfo.KEY_Uname));
                user.password = cursor.getString(cursor.getColumnIndex(Table_UserInfo.KEY_Password));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return user;
    }
}
