package com.example.listviewdemodatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DatabaseHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "student_details";

    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String PHONE = "Phone";
    private static final int VERSION_NUMBER = 2;


    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+NAME+" VARCHAR(255) NOT NULL,"+PHONE+" INTEGER(11) NOT NULL )";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    private static final String SELECT_ALL = "SELECT * FROM "+TABLE_NAME;



    private Context context;

    public DatabaseHelper( Context context ) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{
            Toast.makeText(context,"onCreate Is Calling",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);

        }catch(Exception e){

            Toast.makeText(context,"Exception"+e,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{

            Toast.makeText(context,"onUpgrade Is Calling",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        }catch(Exception e){

            Toast.makeText(context,"Exception"+e,Toast.LENGTH_LONG).show();

        }

    }

    public long saveData(String name, String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("PHONE",phone);

        long rowNumber = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowNumber;
    }

    public Cursor displayAllData(){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;

    }
}
