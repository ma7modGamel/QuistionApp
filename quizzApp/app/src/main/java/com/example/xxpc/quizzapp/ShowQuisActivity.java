package com.example.xxpc.quizzapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ShowQuisActivity extends AppCompatActivity {
    TextView typeQuis;
    ImageView imgQuz;
    EditText ed_value;
    RadioButton rA
            , rB
            , rC;
    LinearLayout ch_layout;
    RadioGroup radio_layout;
    int degree;
    char s;
    CheckBox checkA;
    CheckBox checkB;
    CheckBox checkC;
    CheckBox checkD;
    modelQuestions ImodelQuestions;
    String sumValueOfCheck;
    String[] valueOfChek = new String[4];
    String valueOfRadioButton = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_quis);
        imgQuz = findViewById(R.id.img);
        ed_value = findViewById(R.id.EditLayout);
        ch_layout = findViewById(R.id.checkLayout);
        radio_layout = findViewById(R.id.radioLayout);
        typeQuis = findViewById(R.id.typeOfQuis);
        rA = findViewById(R.id.radio_A);
        rB = findViewById(R.id.radio_B);
        rC = findViewById(R.id.radio_C);
        checkA = findViewById(R.id.check_A);
        checkB = findViewById(R.id.check_B);
        checkC = findViewById(R.id.check_C);
        checkD = findViewById(R.id.check_D);
        Intent intent = getIntent();
        ImodelQuestions = intent.getParcelableExtra("modelQuestions");

        int photoQuez = ImodelQuestions.photoQuez;
        imgQuz.setImageResource(photoQuez);

        s = ImodelQuestions.getTypeQ();
        if (s == 'c') {
            ch_layout.setVisibility(View.VISIBLE);
        } else if (s == 'e') {
            ed_value.setVisibility(View.VISIBLE);
        } else if (s == 'r') {
            radio_layout.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
        }

    }

    public void saveValue(View view) {


        if (ed_value.getVisibility() == View.VISIBLE) {
            degree = toCheckedEditText(ImodelQuestions.answers, ed_value.getText().toString());

        } else if (ch_layout.getVisibility() == View.VISIBLE) {
            if (checkA.isChecked() == true) {
                valueOfChek[0] = "a";
                Log.e("a", valueOfChek[0] + "");
            }
            if (checkB.isChecked() == true) {
                valueOfChek[1] = "b";
                Log.e("a", valueOfChek[1] + "");
            }
            if (checkC.isChecked() == true) {
                valueOfChek[2] = "c";
                Log.e("a", valueOfChek[2] + "");
            }
            if (checkD.isChecked() == true) {
                valueOfChek[3] = "d";
            }

            sumValueOfCheck = valueOfChek.toString();
            sumValueOfCheck = "";
            for (int t = 0; t < valueOfChek.length; t++) {
                sumValueOfCheck += valueOfChek[t];
            }

            if (sumValueOfCheck.equals(ImodelQuestions.answers)) {
                degree = 1;
            } else {
                degree = 0;
            }

        } else if (radio_layout.getVisibility() == View.VISIBLE) {


            if (rA.isChecked() == true) {
                valueOfRadioButton = "a";

            }
            if (rB.isChecked() == true) {
                valueOfRadioButton = "b";

            }
            if (rC.isChecked() == true) {
                valueOfRadioButton = "c";

            }

            if (valueOfRadioButton.equals(ImodelQuestions.answers.toString())) {
                degree = 1;
            } else {
                degree = 0;
            }
        }
        Toast.makeText(this, "" + degree, Toast.LENGTH_SHORT).show();

        Intent intentforRsult = new Intent();
        intentforRsult.putExtra("degree", degree);
        setResult(Activity.RESULT_OK, intentforRsult);
        super.onBackPressed();
        finish();
    }

    private int toCheckedEditText(String answers, String value) {

        if (value.equals(answers)) {
            return 1;
        } else {
            return 0;
        }
    }
}

