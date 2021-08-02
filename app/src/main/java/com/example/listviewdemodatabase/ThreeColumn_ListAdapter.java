package com.example.listviewdemodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater inflater;
    private ArrayList<User> users;
    private int mViewResourceId;


    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<User> users){
        super(context,textViewResourceId,users);
        this.users = users;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents){

        convertView = inflater.inflate(mViewResourceId,null);

        User user = users.get(position);

        if(user != null){
           TextView firstName = (TextView) convertView.findViewById(R.id.textViewId);
           TextView lastPhone = (TextView) convertView.findViewById(R.id.textViewId2);

           if(firstName !=null){
               firstName.setText((user.getFirstName()));

           }if(lastPhone!=null){
                lastPhone.setText((user.getLastPhone()));
            }
        }

        return convertView;


    }

}
