package kindling.com.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.ActionBar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignupActivity extends ActionBarActivity {

    ImageButton kindleButton;
    ImageButton intoMenButton, intoWomenButton, bisexualButton;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText nameEditText;
    EditText locationEditText;
    EditText ageEditText;
    Boolean intoMaleSelected; // Used to determine if the male checkbox is checked or not.
    Boolean intoWomenSelected; // Used to determine if the female checkbox is checked or not.
    Boolean bisexualSelected; // Used to determine if the m&w checkbox is checked or not.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("");

        intoMaleSelected = false;
        intoWomenSelected = false;

        usernameEditText = (EditText) findViewById(R.id.username_edit_text);
        passwordEditText = (EditText) findViewById(R.id.password_edit_text);
        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        locationEditText = (EditText) findViewById(R.id.location_edit_text);
        ageEditText = (EditText) findViewById(R.id.age_edit_text);

        kindleButton = (ImageButton) findViewById(R.id.actualSignupButton);
        kindleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (invalidInput()) {
                    Toast.makeText(getApplicationContext(), R.string.invalid_input, Toast.LENGTH_SHORT).show();
                }
            }
        });

        intoMenButton = (ImageButton) findViewById(R.id.interested_in_male_button);
        intoWomenButton = (ImageButton) findViewById(R.id.interested_in_female_button);
        bisexualButton = (ImageButton) findViewById(R.id.interested_in_both_button);

        intoMenButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v)
           {
               if(!intoMaleSelected) {
                   intoMenButton.setImageResource(R.drawable.male_btn_selected);
                   intoMaleSelected = true;
               }else{
                   intoMenButton.setImageResource(R.drawable.male_btn);
                   intoMaleSelected = false;
               }
           }
        });

        intoWomenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(!intoWomenSelected) {
                    intoWomenButton.setImageResource(R.drawable.female_btn_selected);
                    intoWomenSelected = true;
                }else{
                    intoWomenButton.setImageResource(R.drawable.women_btn);
                    intoWomenSelected = false;
                }
            }
        });

        //Modify this section to work for bisexual individuals
        /*bisexualButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(!intoMaleSelected) {
                    intoMenButton.setImageResource(R.drawable.male_btn_selected);
                    intoMaleSelected = true;
                }else{
                    intoMenButton.setImageResource(R.drawable.male_btn);
                    intoMaleSelected = false;
                }
            }
        });*/

    }

    private boolean invalidInput() {
        if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("") ||
                locationEditText.getText().toString().matches("") || nameEditText.getText().toString().matches("") ||
                ageEditText.getText().toString().matches("")) {
            return true;
        }
        Integer age = Integer.parseInt(ageEditText.getText().toString());
        if (age < 18) return true;
        return false;
    }
}
