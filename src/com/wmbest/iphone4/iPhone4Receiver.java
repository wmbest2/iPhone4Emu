package com.wmbest.iphone4;

import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.provider.Settings;

public class iPhone4Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context aContext, Intent aIntent) {

        if (aIntent.getAction().equals("com.wmbest.iphone4.toggle_on")) {
            aContext.startService(new Intent().setClass(
                aContext, iPhone4.class));
        } else {
            aContext.stopService(new Intent().setClass(
                aContext, iPhone4.class));

        }
    }
}

