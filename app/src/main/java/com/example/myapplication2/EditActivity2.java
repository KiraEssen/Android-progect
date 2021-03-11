package com.example.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity2 extends AppCompatActivity {
    public final static String TXNAME = "txName";
    public final static String TXDATE = "txDate";
    public final static String TXEMAIL = "txEmail";

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
            etName.setText(arguments.get(TXNAME).toString());
            etDate.setText(arguments.get(TXDATE).toString());
            etEmail.setText(arguments.get(TXEMAIL).toString());
        }
    }

    public void saveChange(View view) {
        Intent saveChange = new Intent();

        saveChange.putExtra(TXNAME, etName.getText().toString());
        saveChange.putExtra(TXDATE, etDate.getText().toString());
        saveChange.putExtra(TXEMAIL, etEmail.getText().toString());

        setResult(RESULT_OK, saveChange);
        finish();
    }

}