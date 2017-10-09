package com.example.praful.restfulapiclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class CreateUserActivity extends AppCompatActivity {

    EditText etfirstName, etLastName, etUsername, etPassword;
    Button btnCreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

    }
}
