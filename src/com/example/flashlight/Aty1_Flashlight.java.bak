package com.example.flashlight;

import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.TransitionDrawable;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

public class Aty1_Flashlight  extends  Aty0_BaseActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//得到当前屏幕的尺寸，用point对象存储（x,y）
		Point point=new Point();
		getWindowManager().getDefaultDisplay().getSize(point);
		
		//动态的在代码中调整手电筒的click  area空间，用到了layoutParams
		LayoutParams layoutParams=FlashlightController.getLayoutParams();
		layoutParams.height=(int) (point.y*0.75);
		layoutParams.width=point.x/3;
		FlashlightController.setLayoutParams(layoutParams);
		
		//闪光灯默认状态
		FlashlghtImageView.setTag(false);
		
		
		/*		
		 * 下面这段代码可以实现设备的查看，支持的硬件特性FeatureInfo
		FeatureInfo[] featureInfos= getPackageManager().getSystemAvailableFeatures();
		for(FeatureInfo featureInfo:featureInfos)
		{
			System.out.println(featureInfo);
			System.out.println("_______________");
		}
		*/	
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		closeFlash();
		super.onPause();
	}
	
	//开启闪光灯事件
	public void onClick_OpenFlah(View v)
	{
		//判断手机是否存在闪光灯
		if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
		{
			Toast.makeText(this, "没有闪光灯！", Toast.LENGTH_SHORT).show();
			return;
		}
		if(((Boolean)FlashlghtImageView.getTag())==false)
		{
			openFlash();
		}
		else{
			closeFlash();
		}
	}
	
	
	
	public void openFlash(){
		TransitionDrawable drawable=(TransitionDrawable) FlashlghtImageView.getDrawable();
		drawable.startTransition(200);
		FlashlghtImageView.setTag(true);//标志是否已经打开闪光灯，一种方便的数据存储方式
		
		try {
			//闪光灯只能和照相机一起使用，因此只能先从获得Camera对象开始
			camera=Camera.open();
			int  textureId=0;
			//只要打开闪光灯，所以这里对纹理的操作很粗略
			camera.setPreviewTexture(new SurfaceTexture(textureId));
			camera.startPreview();
			
			parameters = camera.getParameters();
			
			parameters.setFlashMode(parameters.FLASH_MODE_TORCH);
			camera.setParameters(parameters);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void closeFlash()
	{
		
		//需要反方向播放
		TransitionDrawable drawable=(TransitionDrawable) FlashlghtImageView.getDrawable();
		if(((Boolean)FlashlghtImageView.getTag())==true)
		{
			//反向播放的方法！
			drawable.reverseTransition(200);
			FlashlghtImageView.setTag(false);
			if(camera!=null)
			{
				parameters=camera.getParameters();
				parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
				
				camera.setParameters(parameters);
				camera.stopPreview();
				camera.release();
				camera=null;
				parameters=null;
			}
			
			
		}
	}


}



