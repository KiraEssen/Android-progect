package com.example.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;

    public final static String TXNAME = "txName";
    public final static String TXDATE = "txDate";
    public final static String TXEMAIL = "txEmail";

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

        editActivity.putExtra(TXNAME, tvFullName.getText().toString());
        editActivity.putExtra(TXDATE, tvDateOfBirth.getText().toString());
        editActivity.putExtra(TXEMAIL, tvEmail.getText().toString());

        startActivityForResult(editActivity, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE){
                tvFullName.setText(data.getStringExtra(TXNAME));
                tvDateOfBirth.setText(data.getStringExtra(TXDATE));
                tvEmail.setText(data.getStringExtra(TXEMAIL));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
