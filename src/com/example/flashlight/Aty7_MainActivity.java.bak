package com.example.flashlight;

import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

/*
 * 
 * 处理所有的点击事件
 * 
 * 
 */



public class Aty7_MainActivity extends Aty6_PoliceLight {

	// 点击手电筒功能按钮事件,需要把View传入，否则安卓就无法找到……不知为何
	public void onClick_ToFlashlight(View view) {
		hideAll();
		if (currentType != UIType.UI_TYPE_FLASHLIGHT) {
			FlashlightUI.setVisibility(View.VISIBLE);
			currentType = UIType.UI_TYPE_FLASHLIGHT;
			lastType = UIType.UI_TYPE_FLASHLIGHT;
		}
	}

	// 进入警告灯功能事件
	public void onClick_ToWarningLight(View view) {
		hideAll();
		if (currentType != UIType.UI_TYPE_WARNINGLIGHT) {
			WarningLightUi.setVisibility(View.VISIBLE);
			currentType = UIType.UI_TYPE_WARNINGLIGHT;
			lastType = UIType.UI_TYPE_WARNINGLIGHT;
			new warningLightThread().start();
			screenBrightness(1f);
		}
	}

	// 进入莫斯电码界面事件
	public void onClick_ToMorse(View view) {
		hideAll();
		if (currentType != UIType.UI_TYPE_MORSE) {
			morseUI.setVisibility(View.VISIBLE);
			currentType = UIType.UI_TYPE_MORSE;
			lastType = UIType.UI_TYPE_MORSE;
		}
	}

	// 进入电灯功能界面事件
	public void onClick_ToBulb(View v) {
		hideAll();
		if (currentType != UIType.UI_TYPE_BLUB) {
			bulbUi.setVisibility(View.VISIBLE);
			hideTextView.hide();// 启动线程，控制自定义组件3s后消失
			currentType = UIType.UI_TYPE_BLUB;
			lastType = UIType.UI_TYPE_BLUB;
		}
	}

	// 进入彩色灯事件
	public void onClick_ToColor(View v) {
		hideAll();
		if (currentType != UIType.UI_TYPE_COLOR) {
			ColorLightUI.setVisibility(View.VISIBLE);
			screenBrightness(1f);
			// hideTextView.hide();//启动线程，控制自定义组件3s后消失
			currentType = UIType.UI_TYPE_COLOR;
			lastType = UIType.UI_TYPE_COLOR;
			ColorLighthideTextView.setTextColor(Color.rgb(
					255 - Color.red(CurrentColorLight),
					255 - Color.green(CurrentColorLight),
					255 - Color.blue(CurrentColorLight)));
		}
	}
	
	//进入警灯事件
	public  void onClick_ToPolice(View v){
		hideAll();
		if (currentType != UIType.UI_TYPE_POLICE) {
			PoliceLightUI.setVisibility(View.VISIBLE);
			currentType = UIType.UI_TYPE_POLICE;
			lastType = UIType.UI_TYPE_POLICE;
			colorLight_hideHideTextView.hide();
			StartPoliceThread();
		}
	}
	
	//进入设置事件
	public void onClick_ToSettings(View v)
	{
		Toast.makeText(this, "待续……", Toast.LENGTH_SHORT).show();
	}
	
	


	// 设置按钮的触发事件！
	public void onClick_Controller(View view) {
		hideAll();
		warningLightFlicker=false;//放置同时两个进程交叉运行，警告灯变化速度快一倍
		policeState=false;
		
		
		
		if (currentType != UIType.UI_TYPE_MAIN) {
			MainControlUi.setVisibility(View.VISIBLE);
			currentType = UIType.UI_TYPE_MAIN;
			lastType=UIType.UI_TYPE_MAIN;//实验
			warningLightState = false;// 控制警告灯线程的布尔量
			policeState=false;//停止警灯的循环
			screenBrightness(ScreenBrightness / 255f);
		} else {
			switch (lastType) {
			case UI_TYPE_FLASHLIGHT:
				FlashlightUI.setVisibility(View.VISIBLE);
				currentType = UIType.UI_TYPE_FLASHLIGHT;

				break;
			case UI_TYPE_WARNINGLIGHT:
				WarningLightUi.setVisibility(View.VISIBLE);
				currentType = UIType.UI_TYPE_WARNINGLIGHT;
				screenBrightness(1f);
				break;

			case UI_TYPE_MORSE:
				morseUI.setVisibility(View.VISIBLE);
				currentType = UIType.UI_TYPE_MORSE;
				break;

			case UI_TYPE_BLUB:
				bulbUi.setVisibility(View.VISIBLE);
				currentType = UIType.UI_TYPE_BLUB;
				break;

			case UI_TYPE_COLOR:
				ColorLightUI.setVisibility(View.VISIBLE);
				currentType = UIType.UI_TYPE_COLOR;
				break;
			case UI_TYPE_POLICE:
				PoliceLightUI.setVisibility(View.VISIBLE);
				currentType = UIType.UI_TYPE_POLICE;
				break;

			default:
				MainControlUi.setVisibility(View.VISIBLE);
				currentType = UIType.UI_TYPE_MAIN;
				break;
			}
		}

	}

}
