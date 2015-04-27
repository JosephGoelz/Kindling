package kindling.com.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import helper.RangeSeekBar;
import model.kindling.Application;
import model.kindling.Range;

public class SettingsActivity extends ActionBarActivity {

    private RangeSeekBar<Integer> ageSeekBar;
    private RangeSeekBar<Integer> intelligenceSeekBar;
    private TextView ageTextView;
    private TextView intelligenceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Settings");

        setupSeekbars();
    }

    private void setupSeekbars() {
        ageTextView = (TextView) findViewById(R.id.ageTextView);
        intelligenceTextView = (TextView) findViewById(R.id.intelligenceTextView);
        ageTextView.setText("19 - 24"); // TODO do this dynamically
        intelligenceTextView.setText("80-100");

        // set up age range seek bar
        ageSeekBar = new RangeSeekBar<Integer>(this);
        ageSeekBar.setRangeValues(18, 60);
        ageSeekBar.setSelectedMinValue(19); // TODO do this dynamically
        ageSeekBar.setSelectedMaxValue(24);
        RelativeLayout ageLayout = (RelativeLayout) findViewById(R.id.ageRelativeLayout);
        ageLayout.addView(ageSeekBar);
        ageSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
//                Range ageRange = new Range(minValue, maxValue); TODO uncomment and actually alter data
//                Application.getUser().setAgeRange(ageRange);
                ageTextView.setText(String.valueOf(minValue) + " - " + String.valueOf(maxValue));
                if (maxValue == 60) {
                    ageTextView.setText(String.valueOf(minValue) + " - 60+");
                }
            }
        });

        // set up intelligence range seek bar
        intelligenceSeekBar = new RangeSeekBar<Integer>(this);
        intelligenceSeekBar.setRangeValues(0, 100);
        intelligenceSeekBar.setSelectedMinValue(80); // TODO do this dynamically
        intelligenceSeekBar.setSelectedMaxValue(100);
        RelativeLayout intelligenceLayout = (RelativeLayout) findViewById(R.id.intelligenceRelativeLayout);
        intelligenceLayout.addView(intelligenceSeekBar);
        intelligenceSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
//                Range intelligenceRange = new Range(minValue, maxValue); TODO uncomment and actually alter data
//                Application.getUser().setIntelRange(intelligenceRange);
                intelligenceTextView.setText(String.valueOf(minValue) + " - " + String.valueOf(maxValue));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_settings, menu);
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
