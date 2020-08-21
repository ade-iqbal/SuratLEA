package com.example.suratlea.Menu.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.suratlea.R;

import java.sql.Date;

public class UpdateOutbox extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_outbox);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById((R.id.editText1));
        text2 = (EditText) findViewById((R.id.editText2));
        text3 = (EditText) findViewById((R.id.editText3));
        text4 = (EditText) findViewById((R.id.editText4));
        text5 = (EditText) findViewById((R.id.editText5));
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM outbox WHERE no_surat = '" + getIntent().getStringExtra("no_surat") + "",null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        ton1= (Button) findViewById(R.id.button1);
        ton2= (Button) findViewById(R.id.button2);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE outbox set no_surat=''"+
                        text2.getText().toString() +"', hal='"+
                                text3.getText().toString() +"', pengirim='"+
                                text4.getText().toString() +"', penerima='"+
                                text5.getText().toString() +"', tgl='"+
                                text1.getText().toString() +"''"
                        );
                Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

    }

    public Updatetask() {
    }
}
