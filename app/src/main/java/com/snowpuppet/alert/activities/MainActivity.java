package com.snowpuppet.alert.activities;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.snowpuppet.alert.R;
import com.snowpuppet.alert.fragments.TimePickerFragment;
import com.snowpuppet.alert.helpers.Constants;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class MainActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    FloatingActionButton fab;
    MaterialTapTargetPrompt fabPrompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences
                (getApplicationContext());

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TimePickerFragment mTimePickerFragment = new TimePickerFragment();
//                mTimePickerFragment.show(getSupportFragmentManager(),
//                        "timePicker");


            }
        });

        // if the user does not know how to go to settings page show prompt
        if(sharedPreferences.getBoolean(Constants.SETTINGS_PREF,false)) {
            showFabPrompt();
        }

    }


    private void showFabPrompt() {

        // build a prompt to be shown to user
        fabPrompt = new MaterialTapTargetPrompt.Builder(this)
                .setTarget(R.id.fab)
                .setBackgroundColour(getColorFromRes(getApplicationContext(),
                        R.color.promptBg))
                .setFocalColourFromRes(R.color.clockBg)
                .setPrimaryText("Advanced Settings")
                .setSecondaryText("long press to go to alarm settings")
                .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {

                    @Override
                    public void onHidePrompt(MotionEvent event, boolean
                            tappedTarget) {

                        // user has tapped inside the ring
                        if(tappedTarget) {
                            editor = sharedPreferences.edit();
                            editor.putBoolean(Constants.SETTINGS_PREF, true);
                            editor.apply();
                        }
                    }

                    @Override
                    public void onHidePromptComplete() {

                    }
                }).create();
        fabPrompt.show();
    }


    private int getColorFromRes(Context context, int id) {
        return ContextCompat.getColor(context,id);
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
