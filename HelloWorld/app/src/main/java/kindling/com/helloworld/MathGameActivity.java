package kindling.com.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;

public class MathGameActivity extends ActionBarActivity {

    Button answer_one, answer_two, answer_three, answer_four;
    TextView question_text;

    public static final String question = "Question";
    public static final String answer1 = "Answer1";
    public static final String answer2 = "Answer2";
    public static final String answer3 = "Answer3";
    public static final String answer4 = "Answer4";


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathgame);
        setTitle("Math Game");

        question_text = (TextView) findViewById(R.id.mathGame_questionText);

        answer_one = (Button) findViewById(R.id.mathGame_AnswerButton1);
        answer_two = (Button) findViewById(R.id.mathGame_AnswerButton1);
        answer_three = (Button) findViewById(R.id.mathGame_AnswerButton1);
        answer_four = (Button) findViewById(R.id.mathGame_AnswerButton1);

        // update question and choice
        question_text.setText(question);
        answer_one.setText(answer1);
        answer_one.setText(answer2);
        answer_one.setText(answer3);
        answer_one.setText(answer4);

        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the first button clicked.
            }
        });
        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the second button clicked.
            }
        });
        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the third button clicked.
            }
        });
        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here for the  button clicked.
            }
        });
    }




}
