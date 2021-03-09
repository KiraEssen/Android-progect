package com.example.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;

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
    }

    public void newActivity(View view) {
        Intent editActivity = new Intent(MainActivity.this, EditActivity2.class);

        editActivity.putExtra("txName", tvFullName.getText().toString());
        editActivity.putExtra("txDate", tvDateOfBirth.getText().toString());
        editActivity.putExtra("txEmail", tvEmail.getText().toString());

        startActivityForResult(editActivity, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE){
                tvFullName.setText(data.getStringExtra("etName"));
                tvDateOfBirth.setText(data.getStringExtra("etDate"));
                tvEmail.setText(data.getStringExtra("etEmail"));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
