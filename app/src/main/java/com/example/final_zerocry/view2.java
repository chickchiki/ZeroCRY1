package com.example.final_zerocry;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.final_zerocry.DataBaseHelper1;
import com.example.final_zerocry.ThreeColumnAdapter;

import java.util.ArrayList;
import java.util.List;

public class view2 extends AppCompatActivity
{
    DataBaseHelper1 db;
    ArrayList<User> userList;
    ListView listview;
    User user;
    ThreeColumnAdapter adapter;
    EditText find;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        userList=new ArrayList<User>();
        db=new com.example.final_zerocry.DataBaseHelper1(this);

        Cursor data=db.getdata1();
        int num_rows=data.getCount();
        if(num_rows==0)
        {
            Toast.makeText(view2.this,"Sorry,no data entry",Toast.LENGTH_SHORT).show();
        }
        else

        {
            while(data.moveToNext())
            {

                user = new User(data.getString(0),data.getString(1),data.getString(2));
                userList.add(user);
            }
            adapter =new com.example.final_zerocry.ThreeColumnAdapter(this,R.layout.content_layout,userList);
            listview=(ListView)findViewById(R.id.ngo_listView);
            listview.setAdapter(adapter);

        }


    }

}