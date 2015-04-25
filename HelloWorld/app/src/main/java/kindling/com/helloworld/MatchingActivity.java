package kindling.com.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.graphics.drawable.ColorDrawable;





public class MatchingActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
        setTitle("Matching");

        ImageButton msgBtn;
        msgBtn = (ImageButton) findViewById(R.id.messageButton);
        msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainMessagesActivity.class);
                startActivity(intent);

            }
        });
        ImageButton acceptbtn;
        acceptbtn = (ImageButton) findViewById(R.id.rightButton);
        acceptbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //put boolean variable
                popUp();
            }

        });

    }

    private void popUp() {

            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.its_a_match);

            AlertDialog.Builder picturePopUp = new AlertDialog.Builder(this);
            picturePopUp.setView(image);

            AlertDialog helpDialog = picturePopUp.create();
            helpDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            helpDialog.show();
    }
}
