package com.example.flashlight;

import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

/*
 * 
 * �������еĵ���¼�
 * 
 * 
 */



public class Aty7_MainActivity extends Aty6_PoliceLight {

	// ����ֵ�Ͳ���ܰ�ť�¼�,��Ҫ��View���룬����׿���޷��ҵ�������֪Ϊ��
	public void onClick_ToFlashlight(View view) {
		hideAll();
		if (currentType != UIType.UI_TYPE_FLASHLIGHT) {
			FlashlightUI.setVisibility(View.VISIBLE);
			currentType = UIType.UI_TYPE_FLASHLIGHT;
			lastType = UIType.UI_TYPE_FLASHLIGHT;
		}
	}

	// ���뾯��ƹ����¼�
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

	// ����Ī˹��������¼�
	public void onClick_ToMorse(View view) {
		hideAll();
		if (currentType != UIType.UI_TYPE_MORSE) {
			morseUI.setVisibility(View.VISIBLE);
			currentType = UIType.UI_TYPE_MORSE;
			lastType = UIType.UI_TYPE_MORSE;
		}
	}

	// �����ƹ��ܽ����¼�
	public void onClick_ToBulb(View v) {
		hideAll();
		if (currentType != UIType.UI_TYPE_BLUB) {
			bulbUi.setVisibility(View.VISIBLE);
			hideTextView.hide();// �����̣߳������Զ������3s����ʧ
			currentType = UIType.UI_TYPE_BLUB;
			lastType = UIType.UI_TYPE_BLUB;
		}
	}

	// �����ɫ���¼�
	public void onClick_ToColor(View v) {
		hideAll();
		if (currentType != UIType.UI_TYPE_COLOR) {
			ColorLightUI.setVisibility(View.VISIBLE);
			screenBrightness(1f);
			// hideTextView.hide();//�����̣߳������Զ������3s����ʧ
			currentType = UIType.UI_TYPE_COLOR;
			lastType = UIType.UI_TYPE_COLOR;
			ColorLighthideTextView.setTextColor(Color.rgb(
					255 - Color.red(CurrentColorLight),
					255 - Color.green(CurrentColorLight),
					255 - Color.blue(CurrentColorLight)));
		}
	}
	
	//���뾯���¼�
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
	
	//���������¼�
	public void onClick_ToSettings(View v)
	{
		Toast.makeText(this, "��������", Toast.LENGTH_SHORT).show();
	}
	
	


	// ���ð�ť�Ĵ����¼���
	public void onClick_Controller(View view) {
		hideAll();
		warningLightFlicker=false;//����ͬʱ�������̽������У�����Ʊ仯�ٶȿ�һ��
		policeState=false;
		
		
		
		if (currentType != UIType.UI_TYPE_MAIN) {
			MainControlUi.setVisibility(View.VISIBLE);
			currentType = UIType.UI_TYPE_MAIN;
			lastType=UIType.UI_TYPE_MAIN;//ʵ��
			warningLightState = false;// ���ƾ�����̵߳Ĳ�����
			policeState=false;//ֹͣ���Ƶ�ѭ��
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
