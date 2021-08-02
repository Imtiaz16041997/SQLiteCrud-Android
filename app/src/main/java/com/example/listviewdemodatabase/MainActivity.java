package com.example.listviewdemodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextname,editTextphone;
    Button saveButton,showButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


        editTextname = findViewById(R.id.editName);
        editTextphone = findViewById(R.id.editPhone);

        saveButton = findViewById(R.id.savebuttonId);
        showButton = findViewById(R.id.showbuttonId);



        showButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
                startActivity(intent);



            }
        });

        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String fName = editTextname.getText().toString();
                String fPhone = editTextphone.getText().toString();

                if(fName.length() !=0 && fPhone.length() !=0){
                    AddData(fName, fPhone);
                    editTextname.setText("");
                    editTextphone.setText("");

                }else{

                    Toast.makeText(MainActivity.this,"You must put something in the text field",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void AddData(String firstName,String lastPhone) {

        boolean insertData = databaseHelper.addData(firstName,lastPhone);
        if(insertData ==true){
            Toast.makeText(getApplicationContext(), "Successfully Data Inserted", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }


}