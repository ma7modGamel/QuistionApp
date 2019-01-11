package com.example.xxpc.quizzapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    int numOfQuestion;
    String[] answerArray = {"a", "a", "abc" + null, "a", "16", "a", "a", "abc" + null, "a", "16"};
    String text;
    LinearLayout radioLayout;
    LinearLayout checkLayout;
    int degree;
    TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclyOfQuestions);
        tvAnswer = findViewById(R.id.tv_answer);

        tvAnswer.setVisibility(View.INVISIBLE);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        int[] photoQuizArray = {(R.drawable.q1), (R.drawable.q6), (R.drawable.q4), (R.drawable.q3), (R.drawable.q5), (R.drawable.q1), (R.drawable.q6), (R.drawable.q4), (R.drawable.q3), (R.drawable.q5)};
        recyclerView.setLayoutManager(manager);
        char[] typeQues = {'r', 'r', 'c', 'r', 'e', 'r', 'r', 'c', 'r', 'e'};
        numOfQuestion = getIntent().getIntExtra("numOfQuestion", 1);
        ArrayList<modelQuestions> arrayListOfQuestions = new ArrayList<>();
        for (int i = 0; i < numOfQuestion; i++) {
            arrayListOfQuestions.add(new modelQuestions(photoQuizArray[i], answerArray[i], typeQues[i]));
        }
        recyclerView.setAdapter(new quezAdabter(this, arrayListOfQuestions));

        tvAnswer.setText((degree + " " + "/" + " " + numOfQuestion));

    }

    public void sendAns(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("tvAnswer", tvAnswer.getText().toString());
        startActivity(intent);
        this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);
        if ((requestCode == 1) && (resultCode == Activity.RESULT_OK)) {
            degree = degree + dataIntent.getIntExtra("degree", 0);
            tvAnswer.setText((degree + " " + "/" + " " + numOfQuestion));
        }
    }

}

