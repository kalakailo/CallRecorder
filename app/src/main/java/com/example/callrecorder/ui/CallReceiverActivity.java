package com.example.callrecorder.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.provider.CallLog;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.example.callrecorder.domain.entities.History;

/**
 * Created by Михайлик on 01.12.2015.
 */
@SuppressLint("SimpleDateFormat")
public class CallReceiverActivity extends BroadcastReceiver {

    @Override
    public void onReceive(Context c, Intent intent) {
        SharedPreferences sharedPreferences=c.getSharedPreferences(
                "ZnSoftech", Activity.MODE_PRIVATE);

        String s = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);

        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {

            String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            sharedPreferences.edit().putString("number", number).apply();

        } else {
            if ((intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                    TelephonyManager.EXTRA_STATE_RINGING))) {

                String incomingNumber = intent.getStringExtra(
                        TelephonyManager.EXTRA_INCOMING_NUMBER);
                sharedPreferences.edit().putString("number", incomingNumber).apply();


            }
            History h = new History(new Handler(), c);
            c.getContentResolver().registerContentObserver(
                    CallLog.Calls.CONTENT_URI, true, h);
        }
    }
}
