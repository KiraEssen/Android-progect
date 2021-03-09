package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvFullName;
    private TextView tvDateOfBirth;
    private TextView tvEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFullName = findViewById(R.id.fullName);
        tvDateOfBirth = findViewById(R.id.dateOfBirth);
        tvEmail = findViewById(R.id.email);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            tvFullName.setText(arguments.get("etName").toString());
            tvDateOfBirth.setText(arguments.get("etDate").toString());
            tvEmail.setText(arguments.get("etEmail").toString());
        }
    }

    public void newActivity(View view) {
        Intent editActivity = new Intent(MainActivity.this, EditActivity2.class);

        editActivity.putExtra("txName", tvFullName.getText().toString());
        editActivity.putExtra("txDate", tvDateOfBirth.getText().toString());
        editActivity.putExtra("txEmail", tvEmail.getText().toString());

        startActivity(editActivity);
    }
}
