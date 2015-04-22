package kindling.com.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import helper.StringFunctions;


public class LoginActivity extends ActionBarActivity {

    // EditText fields
    EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // basic setup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getString(R.string.login));

        // Text Fields
        usernameEditText = (EditText) findViewById(R.id.username_edit_text);
        passwordEditText = (EditText) findViewById(R.id.password_edit_text);

        // Login Button should send us to Matching.
        ImageButton loginButton = (ImageButton) findViewById(R.id.actualLoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the login information is valid.
                if(invalidFields()) {
                    Toast.makeText(getApplicationContext(),
                            R.string.invalid_input, Toast.LENGTH_SHORT).show();
                }
                // TODO Check with the server if the login information is legitimate
                else {
                    // TODO Switch to MatchingActivity instead
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    // Checks if the Fields are filled with invalid text
    private boolean invalidFields() {
        // Input invalid if Username is only whitespace or password is empty
        return StringFunctions.isWhiteSpace(usernameEditText.getText().toString()) ||
                passwordEditText.getText().toString().isEmpty();
    }
}
