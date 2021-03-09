package com.example.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity2 extends AppCompatActivity {

    private EditText etName;
    private EditText etDate;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit2);

        Bundle arguments = getIntent().getExtras();

        etName = findViewById(R.id.editTextFullName);
        etDate = findViewById(R.id.editTextDateOfBirth);
        etEmail = findViewById(R.id.editTextEmail);

        if(arguments!=null){
            etName.setText(arguments.get("txName").toString());
            etDate.setText(arguments.get("txDate").toString());
            etEmail.setText(arguments.get("txEmail").toString());
        }
    }

    public void saveChange(View view) {
        Intent saveChange = new Intent();

        saveChange.putExtra("etName", etName.getText().toString());
        saveChange.putExtra("etDate", etDate.getText().toString());
        saveChange.putExtra("etEmail", etEmail.getText().toString());

        setResult(RESULT_OK, saveChange);
        finish();
    }

}