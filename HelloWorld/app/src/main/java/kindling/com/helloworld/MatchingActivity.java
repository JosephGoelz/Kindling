package kindling.com.helloworld;

import android.content.Intent;
import android.content.res.Resources;
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

import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;


public class MatchingActivity extends ActionBarActivity {

    private CardContainer cardContainer;

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

        setupCards();

    }

    private void setupCards() {
        cardContainer = (CardContainer) findViewById(R.id.cardContainer);
        Resources r = getResources();

        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);
        adapter.add(new CardModel("Aaron Cote", "I play Hearthstone", r.getDrawable((R.drawable.aaron_cote))));
        adapter.add(new CardModel("Mark Redekopp", "My kids are adorable", r.getDrawable(R.drawable.mark_redekopp)));
        adapter.add(new CardModel("Dave Pritchard", "Eh???", r.getDrawable(R.drawable.dave_pritchard)));
        CardModel cardModel = new CardModel("David Kempe", "I teach CS at USC", r.getDrawable(R.drawable.david_kempe));
        cardModel.setOnClickListener(new CardModel.OnClickListener() {
            @Override
            public void OnClickListener() {
                System.out.println("I am pressing the card");
            }
        });

        cardModel.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
            @Override
            public void onLike() {
                System.out.println("I like the card");
            }

            @Override
            public void onDislike() {
                System.out.println("I dislike the card");
            }
        });
        adapter.add(cardModel);

        cardContainer.setAdapter(adapter);
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
