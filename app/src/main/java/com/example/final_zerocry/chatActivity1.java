package com.example.final_zerocry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;




public class chatActivity1 extends AppCompatActivity {

    EditText txt_chickchiki, txt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat1);


        txt_message = (EditText) findViewById(R.id.text_message);
        txt_chickchiki = (EditText) findViewById(R.id.text_chickchiki);


    }

    public void btn_send(View View) {

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

            MyMessage();

        } else {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);

        }

    }




    private void MyMessage() {
        String chickchiki = txt_chickchiki.getText().toString().trim();
        String Message = txt_message.getText().toString().trim();

        if (txt_chickchiki.getText().toString().equals("") || !txt_message.getText().toString().equals("")) {

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(chickchiki, null, Message, null, null);
            Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "Please Enter chickchiki or Message", Toast.LENGTH_SHORT).show();

        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){

            case 0:
                if (grantResults.length >= 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                    MyMessage();


                }
                else{
                    Toast.makeText(this,"You don't have Required Permission to make this Action",Toast.LENGTH_SHORT).show();
                }


        }
    }
}