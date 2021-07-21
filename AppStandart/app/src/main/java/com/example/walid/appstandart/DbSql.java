package com.example.walid.appstandart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbSql extends SQLiteOpenHelper {

    public static final String dbName = "dataB.db";
    public DbSql(Context context) {

        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS menu(id integer primary key, name text,price real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS menu");
        onCreate(db);
    }


    //---------------Add---------------------------
    public boolean insertMenuItem (String name, Float price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues CTV = new ContentValues();
        CTV.put("name", name);
        CTV.put("price", price);

        long result = db.insert("menu", null, CTV);

        if(result == -1)return false;
        else return true;

    }


    //---------------show---------------------------
    public ArrayList getAllMenuItems() {
        ArrayList array_list = new ArrayList();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from menu", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString( res.getColumnIndex("name") ) + " - Prix: " + res.getString(res.getColumnIndex("price")) );
            res.moveToNext();
        }

        return array_list;
    }



    //---------------Update---------------------------
    public boolean updateMenuItem (Integer id, String name, float price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues CTV = new ContentValues();
        CTV.put("name", name);
        CTV.put("price", price);
        db.update("menu", CTV, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    //---------------delete---------------------------
    public Integer deleteMenuItem (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("menu",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    //---------------------------------------------------------------

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from menu where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, dbName);
        return numRows;
    }
}
