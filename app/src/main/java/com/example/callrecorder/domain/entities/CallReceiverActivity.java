package com.example.callrecorder.domain.entities;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import com.example.callrecorder.data.base.Repository;

import java.util.Date;

/**
 * Created by Михайлик on 01.12.2015.
 */
@SuppressLint("SimpleDateFormat")
public class CallReceiverActivity extends BroadcastReceiver {
    Repository repository;

    @Override
    public void onReceive(Context c, Intent intent) {
        Date date1 = new Date();
        date1.getTime();

        repository = new Repository(c);



            if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
            String out = "Вихідний Дзвінок";
            String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            repository.insertCalls(new Calls(0,out,number,date1.toString()));

        } else {
                if ((intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                        TelephonyManager.EXTRA_STATE_RINGING))) {
                    String incoming = "Вихідний Дзвінок";
                    String incomingNumber = intent.getStringExtra(
                            TelephonyManager.EXTRA_INCOMING_NUMBER);
                    repository.insertCalls(new Calls(0,incoming,incomingNumber,date1.toString()));


                }
            }
    }
}
