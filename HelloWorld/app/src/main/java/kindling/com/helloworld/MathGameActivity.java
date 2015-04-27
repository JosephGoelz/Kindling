package kindling.com.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;
import java.util.TimerTask;
import java.util.Timer;

import model.kindling.Application;
import model.kindling.Question;
import model.kindling.MathQuestion;

public class MathGameActivity extends ActionBarActivity {

    Button answer_one, answer_two, answer_three, answer_four;
    TextView question_text;
    int counter = 20;
    String string_Counter;
    TextView timerUpdate;

    //here is where we create the question
    MathQuestion mq;

    public static final String question = "Question";
    public static final String answer1 = "Answer1";
    public static final String answer2 = "Answer2";
    public static final String answer3 = "Answer3";
    public static final String answer4 = "Answer4";


    protected void onCreate(Bundle savedInstanceState) {
        mq = new MathQuestion();
        mq.populateAnswers();
        mq.generateQuestionText();
        mq.setCorrectAnswer( mq.correctAnswer);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathgame);
        setTitle("Math Game");

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        question_text = (TextView) findViewById(R.id.mathGame_questionText);
        timerUpdate = (TextView) findViewById(R.id.mathGame_counter);

        answer_one = (Button) findViewById(R.id.mathGame_AnswerButton1);
        answer_two = (Button) findViewById(R.id.mathGame_AnswerButton2);
        answer_three = (Button) findViewById(R.id.mathGame_AnswerButton3);
        answer_four = (Button) findViewById(R.id.mathGame_AnswerButton4);

        // update question and choice
        question_text.setText(mq.questionText);
        answer_one.setText(mq.aAnswer);
        answer_two.setText(mq.bAnswer);
        answer_three.setText(mq.cAnswer);
        answer_four.setText(mq.dAnswer);

        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the first button clicked.
                if(mq.correctAnswerIndex == 0){
                    mq.correctAnswer();
                }
                else{
                    mq.incorrectAnswer();
                }
            }
        });
        answer_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the second button clicked.
                if(mq.correctAnswerIndex == 1){
                    mq.correctAnswer();
                }
                else{
                    mq.incorrectAnswer();
                }
            }
        });
        answer_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the third button clicked.
                if(mq.correctAnswerIndex == 2){
                    mq.correctAnswer();
                }
                else{
                    mq.incorrectAnswer();
                }
            }
        });
        answer_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the  button clicked.
                if(mq.correctAnswerIndex == 3){
                    mq.correctAnswer();
                }
                else{
                    mq.incorrectAnswer();
                }
            }
        });
        timeCounter();

    }
    // when the game is started, call this function, then count starts
    public void timeCounter() {
        Timer time = new Timer();
        TimerTask task = new TimerTask(){
            public void run() {

                string_Counter = String.valueOf(counter);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(counter < 9)
                        {
                            timerUpdate.setText("0:0"+string_Counter);
                        }
                        else {
                            timerUpdate.setText("0:"+string_Counter);
                        }


                    }
                });
                counter--;
                if(counter == 0) {
                    //when counter is 0, then next game pops up
                    mq.incorrectAnswer();
                    counter = 20;
                }

            }
        };
        time.schedule(task, 1000,1000);
    }

}
