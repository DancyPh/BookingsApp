package com.example.bookingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.bookingsapp.DB.DBHelper;

public class MainActivity extends AppCompatActivity {

    private EditText edtusername, edtpassword;
    private RadioGroup rgtype;
    private Button btnlogin;

    DBHelper dbHelper = new DBHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtusername = findViewById(R.id.edtUsername);
        edtpassword = findViewById(R.id.edtPassword);
        rgtype = findViewById(R.id.radioGroupUserType);
        btnlogin = findViewById(R.id.btnLogin);
    }



    private void login(){

    }
}