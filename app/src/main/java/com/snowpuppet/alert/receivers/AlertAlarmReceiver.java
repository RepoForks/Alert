package com.snowpuppet.alert.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.snowpuppet.alert.activities.AlarmAlert;

/**
 * Created by snowpuppet on 13/10/16.
 */
public class AlertAlarmReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AlarmAlert.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
