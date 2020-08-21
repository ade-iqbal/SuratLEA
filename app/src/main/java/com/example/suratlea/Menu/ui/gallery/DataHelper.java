package com.example.suratlea.Menu.ui.gallery;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "suratlea.db";
    private static final int DATABASE_VERTSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERTSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table outbox(no_surat integer primary key, hal text null, pengirim text null," +
                " penerima text null, tgl text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);
        String sqll = "create table inbox(no_surat integer primary key, hal text null, pengirim text null," +
                " penerima text null, tgl text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sqll);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

}