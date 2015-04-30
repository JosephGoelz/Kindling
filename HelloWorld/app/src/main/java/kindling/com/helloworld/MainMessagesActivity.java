package kindling.com.helloworld;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import chat.MessageSendThread;
import model.kindling.Application;


public class MainMessagesActivity extends ActionBarActivity {

    EditText chatEditText;
    Button sendButton;
    Thread chatUpdate;
    TextView [] chatTextArray = new TextView[6];
    TextView chat_1, chat_2, chat_3, chat_4, chat_5, chat_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_messages);
        setTitle("Messages");


        String fontPath = "fonts/Souses.otf";

        chat_1 = (TextView) findViewById(R.id.chat_text1);
        chat_2 = (TextView) findViewById(R.id.chat_text2);
        chat_3 = (TextView) findViewById(R.id.chat_text3);
        chat_4 = (TextView) findViewById(R.id.chat_text4);
        chat_5 = (TextView) findViewById(R.id.chat_text5);
        chat_6 = (TextView) findViewById(R.id.chat_text6);

        //Loading Font Face

        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);


        chat_1.setTypeface(tf);
        chat_2.setTypeface(tf);
        chat_3.setTypeface(tf);
        chat_4.setTypeface(tf);
        chat_5.setTypeface(tf);
        chat_6.setTypeface(tf);

        //Hiding grey title bar at the top of the screen.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Application.getChatList();
        // Get the text edittor and the send button for chat
        chatEditText = (EditText) findViewById(R.id.chat_edit_text);
        sendButton = (Button) findViewById(R.id.send_button);
        //text update in gui

        chatTextArray[5] = (TextView) findViewById(R.id.chat_text1);
        chatTextArray[4] = (TextView) findViewById(R.id.chat_text2);
        chatTextArray[3] = (TextView) findViewById(R.id.chat_text3);
        chatTextArray[2] = (TextView) findViewById(R.id.chat_text4);
        chatTextArray[1] = (TextView) findViewById(R.id.chat_text5);
        chatTextArray[0] = (TextView) findViewById(R.id.chat_text6);

        updateChat();
        // Send button should send out a message and clear the edit text
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sends a message
                new MessageSendThread(chatEditText.getText().toString()).start();
                // Clears the chatbox for the next message
                chatEditText.getText().clear();
                //update chat
                //updateChat();
                //System.out.println(Application.getChatList().get(Application.getChatList().size()-1));

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
    public void updateChat() {
        chatUpdate = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                        runOnUiThread(new Runnable() {
                            public void run() {
                                //update chat here!
                                int count = 0;
                                while (count != 6) {
                                    try {
                                        chatTextArray[count].setText(Application.getChatList().get(Application.getChatList().size() - (count + 1)));
                                        count++;
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        break;
                                    }
                                }
                                //chatText6.setText(Application.getChatList().get(0));
                                //System.out.println(Application.getChatList().get(Application.getChatList().size()-1));
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }

        };
        chatUpdate.start();
    }
}
