package com.example.flashlight;

import com.customeView.HideTextView;
import com.example.flashlight.R.drawable;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;

public class Aty4_Bulb extends Aty3_Morse {
	protected HideTextView hideTextView;
	protected boolean BulbOnOrOff=false;
	protected TransitionDrawable Drawable;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		hideTextView=(HideTextView) findViewById(R.id.textview_hide_bulb);
		Drawable=(TransitionDrawable) bulbImageView.getDrawable();
		
		
		
	}
	
	public void onClick_BulbCrossFade(View view)
	{
		if(BulbOnOrOff==false)
		{
			Drawable.startTransition(200);
			BulbOnOrOff=true;
			screenBrightness(1f);
		}else {
			Drawable.reverseTransition(200);
			BulbOnOrOff=false;
			screenBrightness(0.2f);
		}
		
	}
	
	

	
}
