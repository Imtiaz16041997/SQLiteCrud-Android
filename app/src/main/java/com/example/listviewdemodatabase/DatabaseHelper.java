package com.example.listviewdemodatabase;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class DatabaseHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "student_details";

    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String PHONE = "Phone";
    private static final int VERSION_NUMBER = 7;
//," + PHONE + " INTEGER(11) NOT NULL

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + NAME + " VARCHAR(255) NOT NULL,"+PHONE+" VARCHAR(11) NOT NULL)";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;


    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
//            Toast.makeText(context, "onCreate Is Calling", Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);

        } catch (Exception e) {

            Toast.makeText(context, "Exception" + e, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try {

            Toast.makeText(context, "onUpgrade Is Calling", Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        } catch (Exception e) {

            Toast.makeText(context, "Exception" + e, Toast.LENGTH_LONG).show();

        }

    }

    public boolean addData(String fName,String fPhone) {
        //get writable database because we want to write data
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //id will be inserted automatically as we set AUTOINCREMENT in query
        ContentValues contentValues = new ContentValues();
        //insert data
        contentValues.put("NAME", fName);
        contentValues.put("PHONE", fPhone);
        //insert row , it will return record id of saved record
        long rowNumber = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
//        return rowNumber;
        if(rowNumber == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getListContents(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor data = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return data;
    }


//    public Cursor displayAllData() {
//
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL, null);
//        return cursor;
//
//    }



//    public Boolean updateData(String name, String phone) {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("NAME", name);
//        contentValues.put("PHONE", phone);
//        sqLiteDatabase.update(TABLE_NAME, contentValues,ID + " =? ",new String[]{name,phone});
//        return true;
//
//    }

//    public Integer deleteData(String id) {
//
//            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//            int value = sqLiteDatabase.delete(TABLE_NAME, ID + " =? ", new String[]{id});
//            return value;
//        }

    public Cursor getItemId(String name){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT " +ID + "FROM"
                +TABLE_NAME + "WHERE" +NAME+ "=" +name+ "";
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        return cursor;


    }

    //updates the name

//public void updateName(String newName,int id, String oldName){
//
//    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//    String query = "UPDATE"+TABLE_NAME+"SET"+NAME+"="+newName+" WHERE"+ID+"=?"+id+" "+"AND"+NAME+"="+oldName+" ";
//    Log.d(TAG,"updateName: query"+query);
//    Log.d(TAG,"updateName: String name to "+newName);
//    sqLiteDatabase.execSQL(query);
//}

//delete

//    public void deleteName(int id, String name){
//
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        String query = "DELETE FROM" +TABLE_NAME+"WHERE"+ID+ "=?"+id+" "+"AND"+NAME+" ="+name+ " ";
//        Log.d(TAG,"deleteName: query"+query);
//        Log.d(TAG,"deleteName:Deleting "+name+"from database");
//        sqLiteDatabase.execSQL(query);
//
//
//
//
//    }






}
