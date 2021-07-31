package com.example.listviewdemodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextId,editTextname,editTextphone;
    private Button savebutton,showbutton,updatebutton,deletebutton;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        editTextId = findViewById(R.id.editId);
        editTextname = findViewById(R.id.editName);
        editTextphone = findViewById(R.id.editPhone);

        savebutton = findViewById(R.id.savebuttonId);
        showbutton = findViewById(R.id.showbuttonId);
        updatebutton = findViewById(R.id.updatebuttonId);
        deletebutton = findViewById(R.id.deletebuttonId);


        savebutton.setOnClickListener(this);
        showbutton.setOnClickListener(this);
        updatebutton.setOnClickListener(this);
        deletebutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        String name = editTextname.getText().toString();
        String phone = editTextphone.getText().toString();
        String id = editTextId.getText().toString();

        if(view.getId()==R.id.savebuttonId){

            if(name.equals("") && phone.equals("")) {

                Toast.makeText(getApplicationContext(), "Please Enter All The Data",Toast.LENGTH_LONG).show();
            }else{

                long rowNumber= databaseHelper.saveData(name,phone);

                if (rowNumber == -1) {
                    Toast.makeText(getApplicationContext(), "Unsuccessfull", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Successfully " + rowNumber + " inserted", Toast.LENGTH_LONG).show();
                    editTextname.setText("");
                    editTextphone.setText("");
                }



            }





        }else if(view.getId()==R.id.showbuttonId){

            Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
            startActivity(intent);


        }else if(view.getId()==R.id.updatebuttonId){





        }else if(view.getId()==R.id.deletebuttonId){



        }
    }
}