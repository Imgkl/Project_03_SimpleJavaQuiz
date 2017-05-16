package com.example.android.simplejavaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String ANSWER_5 = "int";

    private RadioButton ans1;
    private RadioButton ans2;
    private CheckBox ans3a;
    private CheckBox ans3b;
    private CheckBox ans3c;
    private RadioButton ans4;
    private EditText ans5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ans1 = (RadioButton) findViewById(R.id.answer1a);
        ans2 = (RadioButton) findViewById(R.id.answer2b);
        ans3a = (CheckBox) findViewById(R.id.answer3b);
        ans3b = (CheckBox) findViewById(R.id.answer3c);
        ans3c = (CheckBox) findViewById(R.id.answer3a);
        ans4 = (RadioButton) findViewById(R.id.answer4a);
        ans5 = (EditText) findViewById(R.id.question5);
    }

    public void answerChecker(View view) {

        String noOfQuestions = getString(R.string.no_of_questions);
        String correctAll = getString(R.string.answers_correctAll);
        String correctMoreThanHalf = getString(R.string.answers_correctMoreThanHalf);
        String correctLessThanHalf = getString(R.string.answers_correctLessThanHalf);
        int correctAnswers = 0;

        //Check for the correctAnswers answers
        boolean answer1 = ans1.isChecked();
        boolean answer2 = ans2.isChecked();
        boolean answer3a = ans3a.isChecked();
        boolean answer3b = ans3b.isChecked();
        boolean answer3c = ans3c.isChecked();
        boolean answer4 = ans4.isChecked();
        String answer5 = ans5.getText().toString();

        if (answer1) {
            correctAnswers += 1;
        }

        if (answer2) {
            correctAnswers += 1;
        }

        if (answer3b && answer3c && !answer3a) {
            correctAnswers += 1;
        }

        if (answer4) {
            correctAnswers += 1;
        }

        if (answer5.trim().equals(ANSWER_5)) {
            correctAnswers += 1;
        }

        if (correctAnswers == 5) {
            displayToast(correctAll + correctAnswers + noOfQuestions);

        } else if (correctAnswers >= 3) {
            displayToast(correctMoreThanHalf + correctAnswers + noOfQuestions);

        } else {
            displayToast(correctLessThanHalf + correctAnswers + noOfQuestions);
        }
    }

    private void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
