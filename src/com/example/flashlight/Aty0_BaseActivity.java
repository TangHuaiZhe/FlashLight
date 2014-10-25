package com.example.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

//链表设计模式……每个功能一个结点
//此Activity为根Activity,定义一些基本的属性和方法，应用与每个功能类

public class Aty0_BaseActivity extends Activity {
	ImageView FlashlghtImageView;
	ImageView FlashlightController;
	Camera camera;
	Parameters parameters;//Camera service setting
	protected EditText editText;//莫斯电码界面的EditText
	ImageView bulbImageView;//电灯界面中的电灯
	int  count;
	
	
	//枚举功能界面
	protected enum UIType {
		UI_TYPE_MAIN, UI_TYPE_FLASHLIGHT, UI_TYPE_WARNINGLIGHT, 
		UI_TYPE_MORSE, UI_TYPE_BLUB, UI_TYPE_COLOR, UI_TYPE_POLICE, 
		UI_TYPE_SETTINGS
	}
	
	//记录当前界面和上次界面,默认是在手电筒
	protected UIType currentType=UIType.UI_TYPE_MAIN;
	protected UIType lastType=UIType.UI_TYPE_MAIN;
	
	
	//定义所有的视图
	protected FrameLayout FlashlightUI;
	protected LinearLayout MainControlUi;
	//警告灯视图
	protected LinearLayout WarningLightUi;
	//莫斯视图
	protected LinearLayout morseUI;
	//电灯视图
	protected FrameLayout bulbUi;
	//彩色灯视图
	protected FrameLayout ColorLightUI;
	//警灯视图
	protected FrameLayout PoliceLightUI;
	
	//定义两个图像框
	protected ImageView warningLightUp;
	protected ImageView warningLightDown;
	
	//系统的默认亮度
	protected int ScreenBrightness;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//显示视图
		//视图获取，注意是用ID获取，不是用layout
		FlashlightUI=(FrameLayout)findViewById(R.id.FlashlightUI);
		MainControlUi=(LinearLayout)findViewById(R.id.MainControlUi);
		WarningLightUi=(LinearLayout) findViewById(R.id.WarningLightUi);
		morseUI=(LinearLayout) findViewById(R.id.morseUi);
		bulbUi=(FrameLayout) findViewById(R.id.bulbUI);
		ColorLightUI=(FrameLayout) findViewById(R.id.ColorLightUI);
		PoliceLightUI=(FrameLayout) findViewById(R.id.PoliceLightUi);
		
		//图片的获取，手电筒图片，透明的点击区域图片
		FlashlghtImageView = (ImageView) findViewById(R.id.imageView_falshlight);
		FlashlightController = (ImageView) findViewById(R.id.imageView_clickArea);
		
		//警告灯图片的获取
		warningLightUp=(ImageView) findViewById(R.id.warningLightUp);
		warningLightDown=(ImageView) findViewById(R.id.warningLightDown);
		
		ScreenBrightness=getScreenBrightness();
		
		//莫斯电码界面的EditText
		editText=(EditText) findViewById(R.id.editext_morse_code);
		bulbImageView=(ImageView) findViewById(R.id.imageview_bulb);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		//实现连续两次退出按钮才会让程序退出
		count=0;//拦截触摸事件，侦测到屏幕触摸事件，把之前记录的返回事件计算清零。
		return super.dispatchTouchEvent(ev);
	}
	
	@Override
	public void finish() {
		count++;
		if(count==1){
			Toast.makeText(this, "再按一次返回键退出应用程序", Toast.LENGTH_SHORT).show();
		}
		if(count>1)
		{
			super.finish();
		}
		
	}
	
	
	
	//隐藏所有UI方法
	protected void   hideAll() {
		FlashlightUI.setVisibility(View.GONE);
		MainControlUi.setVisibility(View.GONE);
		WarningLightUi.setVisibility(View.GONE);
		morseUI.setVisibility(View.GONE);
		bulbUi.setVisibility(View.GONE);
		ColorLightUI.setVisibility(View.GONE);
		PoliceLightUI.setVisibility(View.GONE);
	}
	
	protected void screenBrightness(float value)
	{
		try {
			WindowManager.LayoutParams layoutParams=getWindow().getAttributes();
			layoutParams.screenBrightness=value;// 0~1
			getWindow().setAttributes(layoutParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected int getScreenBrightness() {
		int value=0;
		try {
			//获取系统默认亮度
			value=Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
}
