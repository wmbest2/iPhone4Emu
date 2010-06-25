package com.wmbest.iphone4;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class iPhone4Launcher extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		startService(new Intent().setClass(this, iPhone4.class));
	}

}
