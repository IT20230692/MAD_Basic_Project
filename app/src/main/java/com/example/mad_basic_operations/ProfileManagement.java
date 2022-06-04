package com.example.mad_basic_operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mad_basic_operations.Database.DBHandler;

public class ProfileManagement extends AppCompatActivity {

    EditText username, dob, password;
    Button add, updateProfile;
    RadioButton male, female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        username = findViewById(R.id.editTextTextPersonName);
        dob = findViewById(R.id.editTextDate);
        password = findViewById(R.id.editTextTextPassword);
        add = findViewById(R.id.button_add_PM);
        updateProfile = findViewById(R.id.button2_add_PM);
        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);

        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileManagement.this, EditProfile.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(male.isChecked()){
                    gender = "Male";
                }else {
                    gender = "Female";
                }

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newID = dbHandler.addInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(ProfileManagement.this, "User Added. User ID: "+ newID, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ProfileManagement.this, EditProfile.class);
                startActivity(intent);
            }
        });


    }
}