package com.example.singh.brainee;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView pointsTextView;
    TextView resultTextView;
    TextView timerTextView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button startButton;
    Button playAgainButton;
    TextView sumTextView;
    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    int score=0;
    int numberOfquestions = 0;
    public void playAgain(View view){
        generateQuestion();
        score=0;
        numberOfquestions=0;
        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        pointsTextView.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                timerTextView.setVisibility(View.INVISIBLE);
                sumTextView.setVisibility(View.INVISIBLE);
                pointsTextView.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Score: "+Integer.toString(score)+"/"+Integer.toString(numberOfquestions));
            }
        }.start();

    }
    public void generateQuestion(){
        Random rand = new Random();
        int a = rand.nextInt(51);
        int b = rand.nextInt(51);
        sumTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));
        locationOfCorrectAnswer = rand.nextInt(4);
        answers.clear();
        int incorrectAnswer;
        for(int i=0;i<4;i++){
            if(i==locationOfCorrectAnswer){
                answers.add(a+b);
            } else {
                incorrectAnswer = rand.nextInt(101);
                if(incorrectAnswer==a+b){
                    incorrectAnswer += rand.nextInt(31);
                }
                answers.add(incorrectAnswer);
            }
        }
        button1.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));
    }

    public void viewAnswer(View view){
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            score++;
            resultTextView.setText("CORRECT!");
        } else {
            resultTextView.setText("WRONG!");
        }
        numberOfquestions++;
        pointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfquestions));
        generateQuestion();
    }
    public void start(View view) {
        playAgain(playAgainButton);
        timerTextView.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        pointsTextView.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        view.setVisibility(view.INVISIBLE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.startButton);
         button1 = (Button)findViewById(R.id.button1);
         button2 = (Button)findViewById(R.id.button2);
         button3 = (Button)findViewById(R.id.button3);
         button4 = (Button)findViewById(R.id.button4);
         startButton = (Button)findViewById(R.id.startButton);
         playAgainButton = (Button)findViewById(R.id.playAgainButton);
         sumTextView = (TextView)findViewById(R.id.sumTextView);
        resultTextView = (TextView)findViewById(R.id.resultTextView);
        pointsTextView = (TextView)findViewById(R.id.pointsTextView);
        timerTextView = (TextView)findViewById(R.id.timerTextView);

    }
}
