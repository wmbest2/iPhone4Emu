package com.wmbest.iphone4;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.IntentFilter;
import android.app.Service;
import android.os.IBinder;
import android.util.Log;
import android.content.Context;
import android.provider.Settings;
import android.hardware.SensorManager;
import android.hardware.SensorListener;



public class iPhone4 extends Service
{

	SensorManager sm;

	SensorListener sl;

	@Override
	public void onCreate() {

		sl = new SensorListener() {
			public void onSensorChanged(int sensor, float[] values) {

				float pitch = values[1];

				Log.d("IPhone4", Float.toString(pitch));

				boolean isEnabled = Settings.System.getInt(
			      iPhone4.this.getContentResolver(), 
	    		  Settings.System.AIRPLANE_MODE_ON, 0) == 1;

				if (pitch <= 60 && pitch >= -60) {
					// mostly vertical
					
					// toggle airplane mode
					Settings.System.putInt(
				      iPhone4.this.getContentResolver(),
		    		  Settings.System.AIRPLANE_MODE_ON, 0);

				}
				else {
					// mostly vertical
					
					// toggle airplane mode
					Settings.System.putInt(
				      iPhone4.this.getContentResolver(),
		    		  Settings.System.AIRPLANE_MODE_ON,  1);

				}

				// Post an intent to reload
				Intent intent_broadcast = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
					intent_broadcast.putExtra("state", !isEnabled);

				iPhone4.this.sendBroadcast(intent_broadcast);
		
			}
 
			public void onAccuracyChanged(int sensor, int accuracy) {
			}		
		};


		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
 
		// Register your SensorListener
		sm.registerListener(sl, SensorManager.SENSOR_ORIENTATION, SensorManager.SENSOR_DELAY_NORMAL);
		
		
    }


	@Override
    public void onDestroy() {
		sm.unregisterListener(sl);    

		Settings.System.putInt(
				      iPhone4.this.getContentResolver(),
		    		  Settings.System.AIRPLANE_MODE_ON, 0);

		Intent intent_broadcast = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
					intent_broadcast.putExtra("state", false);

				iPhone4.this.sendBroadcast(intent_broadcast);

	}


	@Override
	public IBinder onBind(Intent intent) {
	  return null;
	}
	
	
}
