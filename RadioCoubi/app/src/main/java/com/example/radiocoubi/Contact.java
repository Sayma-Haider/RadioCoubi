package com.example.radiokoubi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void onBackPressed()
    {
        startActivity(new Intent(Contact.this,MainActivity.class));
        finish();
    }
}
