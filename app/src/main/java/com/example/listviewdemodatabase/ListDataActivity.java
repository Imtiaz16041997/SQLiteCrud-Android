package com.example.listviewdemodatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
    private ListView listView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        databaseHelper = new DatabaseHelper(this);
        listView = findViewById(R.id.listViewId);

        loadData();

    }

    public  void loadData() {

        ArrayList<String> listData = new ArrayList<>();

        Cursor cursor =  databaseHelper.displayAllData();

        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"no data is available",Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                listData.add(cursor.getString(0)+" \t "+cursor.getString(1)+" \t"+cursor.getString(2));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,R.layout.list_item,R.id.textViewId,listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedValue = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),"Selected Value : "+selectedValue,Toast.LENGTH_LONG).show();








//                AlertDialog.Builder alert = new AlertDialog.Builder(ListDataActivity.this);
//                alert.setTitle("Delete");
//                alert.setMessage("Do you want to delete this item from list?");
//                alert.setCancelable(false);
//
//                alert.setNegativeButton("No", new DialogInterface.OnClickListener(){
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//
//                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        listData.remove(i);
//                        adapter.notifyDataSetChanged();
//
//                    }
//                });
//
//                AlertDialog alertDialog = alert.create();
//                alertDialog.show();


            }
        });




    }



}