package com.example.dan.yorktownlogo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        final ImageView iv = (ImageView)findViewById(R.id.imageView);   //Access Picture
        final int width=iv.getWidth();                                  //Captures initial width of picture
        final int height=iv.getHeight();                                //Captures initial height of picture
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                int tempWidth= width + progress;        //Changes width when slider moves
                int tempHeight = height + progress;     //Changes height when slider moves
                TextView t = (TextView)findViewById(R.id.textView);
                t.setText("width = " + tempWidth + " height = " + tempHeight);  //Display new width and height

                // iv.setX(width);  MOVES THE PICTURE
                // iv.setY(height); MOVES THE PICTURE


                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(tempWidth,
                        tempHeight);    //update the parameters of the image
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);  //center image with new width and height
                iv.setLayoutParams(layoutParams);                       //apply new layout


            }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
