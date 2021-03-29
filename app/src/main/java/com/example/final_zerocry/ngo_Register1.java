package com.example.final_zerocry;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




import java.util.ArrayList;

public class ngo_Register1 extends AppCompatActivity {
    EditText name1, contact1, dob1;
    Button insert1, update1, delete1, view1;
    com.example.final_zerocry.DataBaseHelper1 DB1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo__register1);
        name1 = findViewById(R.id.name_ngo2);
        contact1 = findViewById(R.id.contact_ngo2);
        dob1 = findViewById(R.id.add_ngo2);
        insert1 = findViewById(R.id.btnInsert_ngo2);
        update1 = findViewById(R.id.btnUpdate_ngo2);
        delete1 = findViewById(R.id.btnDelete_ngo2);
        view1 = findViewById(R.id.btnView_ngo2);
        DB1 = new com.example.final_zerocry.DataBaseHelper1(this);



        insert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name1.getText().toString();
                String contactTXT = contact1.getText().toString();
                String dobTXT = dob1.getText().toString();

                Boolean checkinsertdata = DB1.insertuserdata1(nameTXT, contactTXT, dobTXT);
                if(checkinsertdata==true)
                    Toast.makeText(ngo_Register1.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ngo_Register1.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
        update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name1.getText().toString();
                String contactTXT = contact1.getText().toString();
                String dobTXT = dob1.getText().toString();

                Boolean checkupdatedata = DB1.updateuserdata1(nameTXT, contactTXT, dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(ngo_Register1.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ngo_Register1.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name1.getText().toString();
                Boolean checkudeletedata = DB1.deletedata1(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(ngo_Register1.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ngo_Register1.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(ngo_Register1.this, com.example.final_zerocry.view2.class));

            }        });

    }}