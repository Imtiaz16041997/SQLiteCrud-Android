package com.example.listviewdemodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextId,editTextname,editTextphone;
    private Button savebutton,showbutton,updatebutton,deletebutton;

    private DatabaseHelper databaseHelper;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

//        editTextId = findViewById(R.id.editId);
        editTextname = findViewById(R.id.editName);
        editTextphone = findViewById(R.id.editPhone);

        savebutton = findViewById(R.id.savebuttonId);
        showbutton = findViewById(R.id.showbuttonId);
        updatebutton = findViewById(R.id.updatebuttonId);
        deletebutton = findViewById(R.id.deletebuttonId);

        savebutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String name = editTextname.getText().toString();
                String phone = editTextphone.getText().toString();


                if(view.getId()==R.id.savebuttonId) {

                    if (name.isEmpty() || phone.isEmpty()) {

                        Toast.makeText(getApplicationContext(), "Please Enter All The Data", Toast.LENGTH_LONG).show();
                    } else {

                        long rowNumber = databaseHelper.saveData(name, phone);

                        if (rowNumber == -1) {
                            Toast.makeText(getApplicationContext(), "Unsuccessfull", Toast.LENGTH_LONG).show();

                        } else {

                            Toast.makeText(getApplicationContext(), "Successfully " + rowNumber + " inserted", Toast.LENGTH_LONG).show();
                            editTextname.setText("");
                            editTextphone.setText("");
                        }
                    }
                }

            }
        });

        showbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
                startActivity(intent);
            }
        });

//        updatebutton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                if(view.getId()==R.id.updatebuttonId) {
//
//                    boolean isUpdated = databaseHelper.updateData(
//                            editTextname.getText().toString(),
//                            editTextphone.getText().toString());
//
//                    if(isUpdated == true){
//                        Toast.makeText(getApplicationContext(), "Successfully Updated", Toast.LENGTH_LONG).show();
//                    }
//                    else{
//                        Toast.makeText(getApplicationContext(),"not updated",Toast.LENGTH_LONG).show();
//                    }
//
//
//
//                }
//
//            }
//        });


//        deletebutton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//                if(view.getId()==R.id.deletebuttonId){
//                    int value = databaseHelper.deleteData(editTextname.getText().toString());
//                    if(value>0){
//                        Toast.makeText(getApplicationContext(), "Data is not Deleted", Toast.LENGTH_LONG).show();
//                    }else{
//                        Toast.makeText(getApplicationContext(), "Successfully Deleted", Toast.LENGTH_LONG).show();
//                    }
//                }
//
//
//            }
//        });










    }
}