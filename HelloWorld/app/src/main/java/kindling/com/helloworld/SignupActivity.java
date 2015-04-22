package kindling.com.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.ActionBar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import helper.StringFunctions;

public class SignupActivity extends ActionBarActivity {

    ImageButton kindleButton;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText nameEditText;
    EditText locationEditText;
    EditText ageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("");

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
                    Intent intent = new Intent(v.getContext(), MatchingActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    private boolean invalidInput() {
        if (StringFunctions.isWhiteSpace(usernameEditText.getText().toString()) ||
                passwordEditText.getText().toString().isEmpty() ||
                StringFunctions.isWhiteSpace(locationEditText.getText().toString()) ||
                StringFunctions.isWhiteSpace(nameEditText.getText().toString()) ||
                StringFunctions.isWhiteSpace(ageEditText.getText().toString())) {
            return true;
        }
        Integer age = Integer.parseInt(ageEditText.getText().toString());
        if (age < 18) return true;
        return false;
    }
}
