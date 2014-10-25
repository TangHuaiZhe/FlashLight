package com.example.flashlight;

import android.os.Bundle;
import android.os.Handler;

public class Aty2_WarningLight extends Aty1_Flashlight {

	protected boolean warningLightFlicker; // true …¡À∏£¨∑Ò‘ÚÕ£÷π…¡À∏
	protected boolean warningLightState; // TRUE£∫on-off£¨false£∫off-on

	private Handler warningHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 0x123) {
				if (warningLightState == true) {
					warningLightUp.setImageResource(R.drawable.warning_light_on);
					warningLightDown.setImageResource(R.drawable.warning_light_off);
					warningLightState = false;
				} else {
					warningLightUp.setImageResource(R.drawable.warning_light_off);
					warningLightDown.setImageResource(R.drawable.warning_light_on);
					warningLightState = true;
				}
			}

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


	}

	class warningLightThread extends Thread {
		@Override
		public void run() {
			super.run();
			warningLightFlicker = true;
			while (warningLightFlicker)
				try {

					Thread.sleep(500);
					warningHandler.sendEmptyMessage(0x123);

				} catch (Exception e) {
					e.printStackTrace();
				}

		}
	}

}
