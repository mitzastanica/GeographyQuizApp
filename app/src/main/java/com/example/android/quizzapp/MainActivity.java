package com.example.android.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    EditText answerQ1;
    RadioButton answerQ2;
    CheckBox answerQ3A;
    CheckBox answerQ3C;
    CheckBox answerQ3D;
    CheckBox answerQ3B;
    EditText answerQ4;
    RadioButton answerQ5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerQ1 = findViewById(R.id.edit_text_q1);
        answerQ2 = findViewById(R.id.rupee_radio_button);
        answerQ3A = findViewById(R.id.paraguay_checkbox);
        answerQ3B = findViewById(R.id.singapore_checkbox);
        answerQ3C = findViewById(R.id.cambodia_checkbox);
        answerQ3D = findViewById(R.id.zambia_checkbox);
        answerQ4 = findViewById(R.id.edit_text_q4);
        answerQ5 = findViewById(R.id.greenland_radio_button);
    }

    /**
     * This method calculates the score of the quiz.
     * This method is called when the button result is clicked.
     */
    public void showResult(View view) {
        String answer1 = answerQ1.getText().toString();
        if (answer1.equals("Asia")) {
            score += 1;
        }
        if (answerQ2.isChecked()) {
            score += 1;
        }
        if ((answerQ3A.isChecked() && (answerQ3C.isChecked())) && (answerQ3D.isChecked() && !answerQ3B.isChecked())) {
            score += 1;
        }

        String answer4 = answerQ4.getText().toString();
        if (answer4.equals("Ukraine")) {
            score += 1;
        }

        if (answerQ5.isChecked()) {
            score += 1;
        }

        /**
         * This method displays the score on the screen.
         */
        if (score == 5)
            // Show message as a toast
            Toast.makeText(this, "Congratulations!!! You scored " + score + " points out of 5!!!", Toast.LENGTH_LONG).show();
        else if (score < 5)
            // Show message as a toast
            Toast.makeText(this, "Congratulations!!! You scored only " + score + " points out of 5!!!" + "\nTry again!!!", Toast.LENGTH_LONG).show();

    }

    /**
     * Resets the score of the quiz to 0.
     * Clears all RadioGroups and CheckBoxes.
     */
    public void resetScore(View view) {

        EditText nameField = (EditText) findViewById(R.id.edit_text_name);
        nameField.setText(null);

        EditText question1 = (EditText) findViewById(R.id.edit_text_q1);
        question1.setText(null);

        RadioGroup question2 = (RadioGroup) findViewById(R.id.radio_group1);
        question2.clearCheck();

        CheckBox question3A = (CheckBox) findViewById(R.id.paraguay_checkbox);
        question3A.setChecked(false);

        CheckBox question3B = (CheckBox) findViewById(R.id.singapore_checkbox);
        question3B.setChecked(false);

        CheckBox question3C = (CheckBox) findViewById(R.id.cambodia_checkbox);
        question3C.setChecked(false);

        CheckBox question3D = (CheckBox) findViewById(R.id.zambia_checkbox);
        question3D.setChecked(false);

        EditText question4 = (EditText) findViewById(R.id.edit_text_q4);
        question4.setText(null);

        RadioGroup question5 = (RadioGroup) findViewById(R.id.radio_group2);
        question5.clearCheck();

    }
}
