package com.example.verygoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ListElement0Quiz extends AppCompatActivity {

    private Question mQuestionLibrary = new Question();

    private TextView tvScore;
    private TextView tvQuestions;
    private TextView tvTimer;
    private Button btnStart;
    private Button btnAns1;
    private Button btnAns2;
    private Button btnAns3;
    private Button btnAns4;
    ProgressBar progressBar;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    Button btnList;
    Button btnMain;

    int secondsRemaining = 40;

    CountDownTimer timer = new CountDownTimer(40000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            tvTimer.setText(Integer.toString(secondsRemaining) + " sec");
            progressBar.setProgress(40 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            Toast.makeText(ListElement0Quiz.this, "Time's Up! Your Score: " + mScore, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ListElement0Quiz.this, ListElement0.class));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_element0_quiz);

        tvScore = (TextView) findViewById(R.id.tvScore);
        tvQuestions = (TextView) findViewById(R.id.tvQuestions);
        tvTimer = (TextView) findViewById(R.id.tvTimer);
        btnAns1 = (Button) findViewById(R.id.btnAns1);
        btnAns2 = (Button) findViewById(R.id.btnAns2);
        btnAns3 = (Button) findViewById(R.id.btnAns3);
        btnAns4 = (Button) findViewById(R.id.btnAns4);
        btnStart = (Button) findViewById(R.id.btnStart);
        progressBar = findViewById(R.id.progressBar);

        btnList = (Button) findViewById(R.id.btnList2);
        btnMain = (Button) findViewById(R.id.btnMain2);

        tvTimer.setText("0 sec");
        tvScore.setText("0 pts");
        tvQuestions.setText("");
        progressBar.setProgress(0);

        updateQuestion();

        btnAns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnAns1.getText() == mAnswer){
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(ListElement0Quiz.this, "Super!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ListElement0Quiz.this, "Poćwicz ;)", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        btnAns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnAns2.getText() == mAnswer){
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(ListElement0Quiz.this, "Super!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ListElement0Quiz.this, "Poćwicz ;)", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        btnAns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnAns3.getText() == mAnswer){
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(ListElement0Quiz.this, "Super!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ListElement0Quiz.this, "Poćwicz ;)", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        btnAns4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnAns4.getText() == mAnswer){
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(ListElement0Quiz.this, "Super!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ListElement0Quiz.this, "Poćwicz ;)", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart.setVisibility(View.INVISIBLE);
                timer.start();
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                Animation animation = AnimationUtils.loadAnimation(ListElement0Quiz.this, R.anim.bounce);
                btnList.startAnimation(animation);
                startActivity(new Intent(ListElement0Quiz.this, MainActivity.class));
            }
        });

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                Animation animation = AnimationUtils.loadAnimation(ListElement0Quiz.this, R.anim.bounce);
                btnMain.startAnimation(animation);
                finish();
            }
        });

    }
    private void updateQuestion(){
        tvQuestions.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        btnAns1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        btnAns2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        btnAns3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        btnAns4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;

        if (mQuestionNumber == 7) {
            timer.cancel();
            Toast.makeText(ListElement0Quiz.this, "Your Score: " + mScore, Toast.LENGTH_SHORT).show();
            finish();
        }

    }


    private void updateScore(int point) {
        tvScore.setText("" + mScore);
    }
}