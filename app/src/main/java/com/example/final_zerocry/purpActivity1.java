package com.example.final_zerocry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;




public class purpActivity1 extends AppCompatActivity
{
    Button ins,mod,del,v;
    com.example.final_zerocry.DBHelper1 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purp1);


        EditText mySpinner1=(EditText)findViewById(R.id.change_textView);

        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(purpActivity1.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.resources));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);


        Spinner mySpinner3 = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(purpActivity1.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.city));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);

        ins=(Button)findViewById(R.id.btnIns);
        mod=(Button)findViewById(R.id.btnmod);
        del=(Button)findViewById(R.id.btnDel);
        v=(Button)findViewById(R.id.btnsee);

        DB = new com.example.final_zerocry.DBHelper1(this);
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = mySpinner1.getText().toString();
                String contactTXT = mySpinner2.getSelectedItem().toString();
                String dobTXT = mySpinner3.getSelectedItem().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, contactTXT, dobTXT);
                if(checkinsertdata==true)
                    Toast.makeText(purpActivity1.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(purpActivity1.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });


        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = mySpinner1.getText().toString();
                String contactTXT = mySpinner2.getSelectedItem().toString();
                String dobTXT = mySpinner3.getSelectedItem().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, contactTXT, dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(purpActivity1.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(purpActivity1.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = mySpinner1.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(purpActivity1.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(purpActivity1.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(purpActivity1.this, com.example.final_zerocry.viewn.class));
            }        });


    }
}