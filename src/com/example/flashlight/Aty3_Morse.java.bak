package com.example.flashlight;

import java.util.HashMap;
import java.util.Map;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Aty3_Morse extends Aty2_WarningLight {

	private final int Dian_Time = 200; // 200ms,点的时间
	private final int Line_Time = Dian_Time * 3;// 线的时间
	private final int DianAndLine_Time = Dian_Time; // 点线之间的时间间隔

	private final int CharAndChar_Time = Dian_Time * 3;// 单词和单词之间的间隔时间
	private final int SentenAndSentence_Time = Dian_Time * 7;// 句子和句子之间的间隔时间

	private String MorseCode;

	private Map<Character, String> MorseCodeMap = new HashMap<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MorseCodeMap.put('a', ".-");
		MorseCodeMap.put('b', "-...");
		MorseCodeMap.put('c', "-.-.");
		MorseCodeMap.put('d', "-..");
		MorseCodeMap.put('e', ".");
		MorseCodeMap.put('f', "..-.");
		MorseCodeMap.put('g', "--.");
		MorseCodeMap.put('h', "....");
		MorseCodeMap.put('i', "..");
		MorseCodeMap.put('j', ".---");
		MorseCodeMap.put('k', "-.-");
		MorseCodeMap.put('l', ".-..");
		MorseCodeMap.put('m', "--");
		MorseCodeMap.put('n', "-.");
		MorseCodeMap.put('o', "---");
		MorseCodeMap.put('p', ".--.");
		MorseCodeMap.put('q', "--.-");
		MorseCodeMap.put('r', ".-.");
		MorseCodeMap.put('s', "...");
		MorseCodeMap.put('t', "-");
		MorseCodeMap.put('u', "..-");
		MorseCodeMap.put('v', "...-");
		MorseCodeMap.put('w', ".--");
		MorseCodeMap.put('x', "-..-");
		MorseCodeMap.put('y', "-.--");
		MorseCodeMap.put('z', "--..");

		MorseCodeMap.put('0', "-----");
		MorseCodeMap.put('1', ".----");
		MorseCodeMap.put('2', "..---");
		MorseCodeMap.put('3', "...--");
		MorseCodeMap.put('4', "....-");
		MorseCodeMap.put('5', ".....");
		MorseCodeMap.put('6', "-....");
		MorseCodeMap.put('7', "--...");
		MorseCodeMap.put('8', "---..");
		MorseCodeMap.put('9', "----.");

	}

	public void onClick_SendMorseCode(View v) {
		if (!getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_CAMERA_FLASH)) {
			Toast.makeText(this, "当前设备没有闪光灯", Toast.LENGTH_LONG).show();
			return;
		}
		if (verifyMorseCode()) {
			sendSentence(MorseCode);
		}

	}

	private void sleep(long t) {
		try {
			Thread.sleep(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendDian() {
		try {
			openFlash();
			sleep(Dian_Time);
			closeFlash();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendLine() {
		try {
			openFlash();
			sleep(Line_Time);
			closeFlash();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendChar(char c) {
		String morseCode = MorseCodeMap.get(c);// 取得对应字符的莫斯电码
		// 然后遍历
		if (morseCode != null) {
			String lastString = null;
			for (int i = 0; i < morseCode.length(); i++) {
				switch (morseCode.charAt(i)) {
				case '.':
					sendDian();
					lastString = ".";

					break;
				case '-':
					if (lastString == ".") {
						sleep(DianAndLine_Time);
					}
					sendLine();
					lastString = "-";
					break;

				default:
					break;
				}
			}
		}

	}

	private void sendString(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			sendChar(c);
			sleep(CharAndChar_Time);

		}
	}

	private void sendSentence(String s) {
		String[] wordsStrings = s.split(" +");// 根据给定 正则表达式 的匹配拆分此字符串
		System.out.println(wordsStrings);
		for (int i = 0; i < wordsStrings.length; i++) {
			sendString(wordsStrings[i]);
			if (i < wordsStrings.length - 1) {
				sleep(SentenAndSentence_Time);
			}
		}

		Toast.makeText(this, "莫斯电码已经发送完成", Toast.LENGTH_SHORT).show();

	}

	private boolean verifyMorseCode() {
		MorseCode = editText.getText().toString().toLowerCase();
		if ("".equals(MorseCode)) {
			Toast.makeText(this, "请输入莫斯电码子字符串", Toast.LENGTH_SHORT).show();
			return false;
		}
		for (int i = 0; i < MorseCode.length(); i++) {
			char c = MorseCode.charAt(i);
			boolean pass = (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')
					|| c != ' ';
			if (!pass) {
				Toast.makeText(this, "摩尔斯电码只能是字母和数字！", Toast.LENGTH_LONG)
				.show();
				return false;
			}

		}
		return true;

	}

}
