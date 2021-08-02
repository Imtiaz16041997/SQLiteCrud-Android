package com.example.listviewdemodatabase;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
    private ListView listView;
    private DatabaseHelper databaseHelper;
    ArrayList<User> userList ;
    User user;
    Cursor data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        databaseHelper = new DatabaseHelper(this);
        listView = findViewById(R.id.listViewId);

        userList = new ArrayList<User>();
        data = databaseHelper.getListContents();


        if(data.getCount() == 0){
            Toast.makeText(getApplicationContext(), "the database was empty", Toast.LENGTH_LONG).show();

        }else{

            while(data.moveToNext()){
            user = new User(data.getString(1),data.getString(2));
            userList.add(user);
        }

        ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this,R.layout.list_item,userList);
        listView.setAdapter(adapter);
        }

      }

    }
