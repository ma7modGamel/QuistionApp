package com.example.xxpc.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;

    TextView tvYourDegree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner1);
        tvYourDegree = findViewById(R.id.yourDegree);
        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Select Age");
        spinnerArray.add("16 : 20 ");
        spinnerArray.add("21 : 32 ");
        spinnerArray.add("32 : 45 ");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        Intent intent = getIntent();
        String yourDegree = intent.getStringExtra("tvAnswer");
        tvYourDegree.setText("Last Degree : " + yourDegree);
    }

    int numOfQuestion;
    String valueOfString;

    public void clickOnTest(View view) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                valueOfString = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        Intent i = new Intent(this, QuesActivity.class);
        valueOfString = spinner.getSelectedItem().toString();
        if (valueOfString == "Select Age") {
            Toast.makeText(MainActivity.this, "please Select your Age !!", Toast.LENGTH_LONG).show();
        } else if (valueOfString == "16 : 20 ") {
            numOfQuestion = 5;
            i.putExtra("numOfQuestion", numOfQuestion);
            startActivity(i);
        } else if (valueOfString == "21 : 32 ") {
            numOfQuestion = 6;
            i.putExtra("numOfQuestion", numOfQuestion);
            startActivity(i);
        } else if (valueOfString == "32 : 45 ") {
            numOfQuestion = 7;
            i.putExtra("numOfQuestion", numOfQuestion);
            startActivity(i);
        }


    }
}
