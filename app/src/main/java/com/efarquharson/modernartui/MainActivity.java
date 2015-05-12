package com.efarquharson.modernartui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.parseColor;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView topLeft = (TextView) findViewById(R.id.topLeft);
        final TextView bottomLeft = (TextView) findViewById(R.id.bottomLeft);
        final TextView topRight = (TextView) findViewById(R.id.topRight);
        final TextView middleRight = (TextView) findViewById(R.id.middleRight);
        final TextView bottomRight = (TextView) findViewById(R.id.bottomRight);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        // Set bgcolour of the TextViews
        final int topLeftColour = parseColor("#16a085");
        final int bottomLeftColour = parseColor("#f1c40f");
        final int topRightColour = parseColor("#e74c3c") + 50;
        final int middleRightColour = parseColor("#bdc3c7");
        final int bottomRightColour = parseColor("#2980b9") - 30;

        topLeft.setBackgroundColor(topLeftColour);
        bottomLeft.setBackgroundColor(bottomLeftColour);
        topRight.setBackgroundColor(topRightColour);
        middleRight.setBackgroundColor(middleRightColour);
        bottomRight.setBackgroundColor(bottomRightColour);

        // Create listener for seekBar, and link the progress to the bgcolour of the textViews

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Change the bgcolours of the TextViews by int progress
                topLeft.setBackgroundColor(topLeftColour - (2 * progress));
                bottomLeft.setBackgroundColor(bottomLeftColour + (3 * progress));
                topRight.setBackgroundColor(topRightColour - (2 * progress));
                bottomRight.setBackgroundColor(bottomRightColour + (3 * progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            new AlertDialog.Builder(this)
                    .setMessage("Inspired by the works of artists such as Sgt. Pepper and his lonely heart club band.")
                    .setPositiveButton("Visit MOMA", visitMoma)
                    .setNegativeButton("Not Now", notNow)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    DialogInterface.OnClickListener visitMoma = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Uri momaUri = Uri.parse("http://www.moma.org/");
            Intent momaIntent = new Intent(Intent.ACTION_VIEW, momaUri);
            startActivity(momaIntent);
        }
    };
    DialogInterface.OnClickListener notNow = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            return;
        }
    };
}
