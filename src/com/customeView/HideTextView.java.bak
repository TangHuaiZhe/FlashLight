package com.customeView;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class HideTextView extends TextView{

	public HideTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}
	
	
	protected Handler mHandler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			if(msg.what == 0)
			{
				setVisibility(View.GONE);
			}
			else if(msg.what == 1)
				
			{
				setVisibility(View.VISIBLE);
			}
		}
	};
    class TextViewThread extends Thread
    {
    	public void run()
    	{
    		mHandler.sendEmptyMessage(1);
    		try
    		{
    			sleep(3000);
    			mHandler.sendEmptyMessage(0);
    		}
    		catch (Exception e) {
				// TODO: handle exception
			}
    	}
    }
    
    public void hide()
    {
    	new TextViewThread().start();
    }
}
