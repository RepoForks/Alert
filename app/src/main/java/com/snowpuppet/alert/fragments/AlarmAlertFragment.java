package com.snowpuppet.alert.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snowpuppet.alert.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AlarmAlertFragment extends Fragment {

    public AlarmAlertFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alarm_alert, container, false);
    }
}
