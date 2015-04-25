package kindling.com.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MathGameActivity extends ActionBarActivity {

    Button answer_one, answer_two, answer_three, answer_four;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathgame);
        setTitle("Math Game");

        answer_one = (Button) findViewById(R.id.mathGame_AnswerButton1);
        answer_two = (Button) findViewById(R.id.mathGame_AnswerButton1);
        answer_three = (Button) findViewById(R.id.mathGame_AnswerButton1);
        answer_four = (Button) findViewById(R.id.mathGame_AnswerButton1);

        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here when the first button clicked.
            }
        });
        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here when the second button clicked.
            }
        });
        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here when the third button clicked.
            }
        });
        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here when the  button clicked.
            }
        });
    }




}
