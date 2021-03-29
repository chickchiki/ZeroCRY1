package com.example.final_zerocry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity
{
    TextView reg,ngo,chatTXT,stories_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg=(TextView)findViewById(R.id.login);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, regActivity.class));
            }
        });
        ngo=(TextView)findViewById(R.id.ngo_reg);

        ngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.example.final_zerocry.ngo_Register1.class));
            }
        });
        chatTXT=(TextView)findViewById(R.id.chat_textView);
        chatTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, com.example.final_zerocry.chatActivity1.class));

            }
        });
        stories_text=(TextView)findViewById(R.id.stories_textView);
        stories_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.example.final_zerocry.story.class));
            }
        });


    }
}