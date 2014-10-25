package com.example.flashlight;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.customeView.HideTextView;

public class Aty6_PoliceLight extends Aty5_ColorLight {
	protected boolean policeState;
	protected HideTextView colorLight_hideHideTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		colorLight_hideHideTextView = (HideTextView) findViewById(R.id.textview_PoliceLight);

	}

	private Handler police_Handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			int color=msg.what;
			PoliceLightUI.setBackgroundColor(color);
		}
	};
	
	
	class PoliceLightThread extends Thread{
		@Override
		public void run() {
			super.run();
			while(policeState)
			{
				try {
					police_Handler.sendEmptyMessage(Color.BLUE);
					Thread.sleep(500);
					police_Handler.sendEmptyMessage(Color.RED);
					Thread.sleep(500);
					police_Handler.sendEmptyMessage(Color.YELLOW);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void StartPoliceThread(){
		policeState=true;
		new PoliceLightThread().start();
	}
	
}
