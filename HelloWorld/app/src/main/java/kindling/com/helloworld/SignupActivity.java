package kindling.com.helloworld;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

import helper.StringFunctions;
import model.kindling.Application;

public class SignupActivity extends ActionBarActivity {

    ImageButton kindleButton;
    ImageButton intoMenButton, intoWomenButton, bisexualButton;
    ImageButton maleBtn, femaleBtn;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText nameEditText;
    EditText locationEditText;
    EditText ageEditText;
    Boolean intoMaleSelected; // Used to determine if the male checkbox is checked or not.
    Boolean intoWomenSelected; // Used to determine if the female checkbox is checked or not.
    Boolean bisexualSelected; // Used to determine if the m&w checkbox is checked or not.
    Boolean male, female; // Used to determine the user's sex


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("");

        //Font path
        String fontPath = "fonts/Souses.otf";

        //Text view label
        TextView txtInterestedIn = (TextView) findViewById(R.id.interested_in_text_view);
        TextView txtSex = (TextView) findViewById(R.id.gender_text_view);

        EditText txtUsername = (EditText) findViewById(R.id.username_edit_text);
        EditText txtPassword = (EditText) findViewById(R.id.password_edit_text);
        EditText txtName = (EditText) findViewById(R.id.name_edit_text);
        EditText txtLocation = (EditText) findViewById(R.id.location_edit_text);
        EditText txtAge = (EditText) findViewById(R.id.age_edit_text);

        //Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);

        //Applying font
        txtUsername.setTypeface(tf);
        txtPassword.setTypeface(tf);
        txtName.setTypeface(tf);
        txtLocation.setTypeface(tf);
        txtAge.setTypeface(tf);

        txtInterestedIn.setTypeface(tf);
        txtSex.setTypeface(tf);

        intoMaleSelected = false;
        intoWomenSelected = false;
        bisexualSelected = false;
        male = false;
        female = false;

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
                else {
                    Integer gender = 0; // 0 = male, 1 = female
                    if (female) gender = 1;

                    Integer genderPreference = 0; // 0 = into males, 1 = into females, 2 = into both
                    if (intoWomenSelected) genderPreference = 1;
                    if (intoMaleSelected && genderPreference == 1) genderPreference = 2;

//                    Application.getUser().setName(nameEditText.getText().toString());
//                    Application.getUser().setAge(Integer.parseInt(ageEditText.getText().toString()));
//                    Application.getUser().setUserName(usernameEditText.getText().toString());
//                    Application.getUser().setSex(gender);
//                    Application.getUser().setSexualOrientation(genderPreference);
//                    Application.getUser().setPassword(passwordEditText.getText().toString());

                    Intent intent = new Intent(v.getContext(), MatchingActivity.class);
                    startActivity(intent);
                }
            }
        });

        intoMenButton = (ImageButton) findViewById(R.id.interested_in_male_button);
        intoWomenButton = (ImageButton) findViewById(R.id.interested_in_female_button);
        bisexualButton = (ImageButton) findViewById(R.id.interested_in_both_button);
        maleBtn = (ImageButton) findViewById(R.id.sex_male_button);
        femaleBtn = (ImageButton) findViewById(R.id.sex_female_button);

        maleBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if(!male) {
                    maleBtn.setImageResource(R.drawable.male_btn_selected);
                    male = true;
                    femaleBtn.setImageResource(R.drawable.women_btn);
                    female = false;
                }else{
                    maleBtn.setImageResource(R.drawable.male_btn);
                    male = false;
                }
            }
        });

        femaleBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if(!female) {
                    femaleBtn.setImageResource(R.drawable.female_btn_selected);
                    female = true;
                    maleBtn.setImageResource(R.drawable.male_btn);
                    male = false;
                }else{
                    femaleBtn.setImageResource(R.drawable.women_btn);
                    female = false;
                }
            }
        });

        intoMenButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v)
           {
               if(!intoMaleSelected) {
                   intoMenButton.setImageResource(R.drawable.male_btn_selected);
                   intoMaleSelected = true;
                   intoWomenButton.setImageResource(R.drawable.women_btn);
                   intoWomenSelected = false;
                   bisexualButton.setImageResource(R.drawable.bisexual_btn);
                   bisexualSelected = false;
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
                    bisexualButton.setImageResource(R.drawable.bisexual_btn);
                    bisexualSelected = false;
                    intoMenButton.setImageResource(R.drawable.male_btn);
                    intoMaleSelected = false;
                }else{
                    intoWomenButton.setImageResource(R.drawable.women_btn);
                    intoWomenSelected = false;
                }
            }
        });

        //Modify this section to work for bisexual individuals
        bisexualButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(!bisexualSelected) {
                    bisexualButton.setImageResource(R.drawable.bisexual_btn_selected);
                    bisexualSelected = true;
                    intoMenButton.setImageResource(R.drawable.male_btn);
                    intoMaleSelected = false;
                    intoWomenButton.setImageResource(R.drawable.women_btn);
                    intoWomenSelected = false;
                }else{
                    bisexualButton.setImageResource(R.drawable.bisexual_btn);
                    bisexualSelected = false;
                }
            }
        });

    }

    private boolean invalidInput() {
        if (StringFunctions.isWhiteSpace(usernameEditText.getText().toString()) ||
                passwordEditText.getText().toString().isEmpty() ||
                StringFunctions.isWhiteSpace(locationEditText.getText().toString()) ||
                StringFunctions.isWhiteSpace(nameEditText.getText().toString()) ||
                StringFunctions.isWhiteSpace(ageEditText.getText().toString())
                ) {
            return true;
        }
        if(!male && !female){
            // Debugging System.out.println("SEX ISSUE");
            return true;
        }
        if(!intoWomenSelected && !intoMaleSelected && !bisexualSelected){
            // Debugging System.out.println("SEXUALITY ISSUE");
            return true;
        }

        Integer age = Integer.parseInt(ageEditText.getText().toString());
        if (age < 18) return true;
        return false;
    }
}
