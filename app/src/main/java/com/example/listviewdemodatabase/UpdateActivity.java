package com.example.listviewdemodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText nameUpdateEditText,phoneUpdateEditText;
    Button updateButton,deleteButton;
    private DatabaseHelper databaseHelper;
    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        nameUpdateEditText = findViewById(R.id.updateNameId);
        phoneUpdateEditText = findViewById(R.id.updatePhoneId);
        updateButton = findViewById(R.id.updatebuttonId);
        deleteButton = findViewById(R.id.deletebuttonId);


        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Intent receiveIntent = getIntent();

        selectedID = receiveIntent.getIntExtra("id",-1);

        selectedName = receiveIntent.getStringExtra("name");


        nameUpdateEditText.setText(selectedName);

//        updateButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                String item = nameUpdateEditText.getText().toString();
//                if(!item.equals("")){
//                    databaseHelper.updateName(item,selectedID,selectedName);
//
//                }else{
//                    Toast.makeText(getApplicationContext(),"enter your name",Toast.LENGTH_LONG).show();
//                }
//            }
//        });


//        deleteButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                databaseHelper.deleteName(selectedID,selectedName);
//                nameUpdateEditText.setText("");
//                Toast.makeText(getApplicationContext(),"remove from database",Toast.LENGTH_LONG).show();
//            }
//        });














//        updateButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                if(view.getId()==R.id.updatebuttonId) {
//
//                    Boolean isUpdated = databaseHelper.updateData(
//                            nameUpdateEditText.getText().toString(),
//                            phoneUpdateEditText.getText().toString());
//
//                    if(isUpdated == true){
//                        Toast.makeText(getApplicationContext(), "Successfully Updated", Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(getApplicationContext(),ListDataActivity.class );
//                        startActivity(intent);
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

//
//        deleteButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//                if(view.getId()==R.id.deletebuttonId){
//                    int value = databaseHelper.deleteData(nameUpdateEditText.getText().toString());
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