package com.example.final_zerocry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class loginActivity1 extends AppCompatActivity
{
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        EditText memail=(EditText)findViewById(R.id.email_login);
        EditText mpass=(EditText)findViewById(R.id.password_login);
        Button login_btn=(Button)findViewById(R.id.login_btn);
        ProgressBar pbr=(ProgressBar)findViewById(R.id.progressBar2);
        TextView createview=(TextView)findViewById(R.id.create);

        auth=FirebaseAuth.getInstance();

        

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String mail=memail.getText().toString().trim();
                String password=mpass.getText().toString().trim();

                if(TextUtils.isEmpty(mail))
                {
                    memail.setError("Email is necessary!!!");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    mpass.setError("Password is necessary!!!");
                    return;
                }
                if(password.length()<6)
                {
                    mpass.setError("Password must be more than 6 characters");
                    return;
                }
                pbr.setVisibility(View.VISIBLE);
                auth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(loginActivity1.this, com.example.final_zerocry.purpActivity1.class));
                            Toast.makeText(loginActivity1.this,"You logged in successfully!",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(loginActivity1.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });

        createview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(loginActivity1.this, com.example.final_zerocry.regActivity.class));
            }
        });

    }
}