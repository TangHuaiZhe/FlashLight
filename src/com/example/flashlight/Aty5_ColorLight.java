package com.example.flashlight;

import com.customeView.HideTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Aty5_ColorLight extends Aty4_Bulb {
	protected int CurrentColorLight = Color.RED;
	protected HideTextView ColorLighthideTextView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ColorLighthideTextView=(HideTextView) findViewById(R.id.textview_ColorLight);
	}
	
	public void OnClick_ColorLight(View v){
		Toast.makeText(this, "需要自定义调色板控件，未完待续……………………", Toast.LENGTH_SHORT).show();
	}
}
