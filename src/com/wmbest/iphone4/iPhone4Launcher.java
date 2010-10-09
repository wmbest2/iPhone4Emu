package com.wmbest.iphone4;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

public class iPhone4Launcher extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button on = (Button) findViewById(R.id.on);
        Button off = (Button) findViewById(R.id.off);

		on.setOnClickListener(new View.OnClickListener() {
            public void onClick(View aView) {
                Intent intent = new Intent("com.wmbest.iphone4.toggle_on");
				iPhone4Launcher.this.sendBroadcast(intent);
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            public void onClick(View aView) {
               Intent intent = new Intent("com.wmbest.iphone4.toggle_off");
				iPhone4Launcher.this.sendBroadcast(intent);
            }
        });
		
		
	}

}
