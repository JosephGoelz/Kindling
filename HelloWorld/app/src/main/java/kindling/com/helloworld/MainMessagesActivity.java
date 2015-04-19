package kindling.com.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainMessagesActivity extends ActionBarActivity {

    ImageButton backButton;
    ImageButton chattingButton1, chattingButton2, chattingButton3, chattingButton4, chattingButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_messages);
        setTitle("Messages");


        backButton = (ImageButton) findViewById(R.id.backIcon);
        chattingButton1 = (ImageButton) findViewById(R.id.user_chatting_Icon1);
        chattingButton2 = (ImageButton) findViewById(R.id.user_chatting_Icon1);
        chattingButton3 = (ImageButton) findViewById(R.id.user_chatting_Icon1);
        chattingButton4 = (ImageButton) findViewById(R.id.user_chatting_Icon1);
        chattingButton5 = (ImageButton) findViewById(R.id.user_chatting_Icon1);

        //When the backbutton is clicked.
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here when the first button clicked.
            }
        });



        //When each chattingButton is clicked
        chattingButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here when the first button clicked.
            }
        });
        chattingButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here when the second button clicked.
            }
        });
        chattingButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here when the third button clicked.
            }
        });
        chattingButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here when the forth button clicked.
            }
        });
        chattingButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add functions here when the fifth button clicked.
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main_messages, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
