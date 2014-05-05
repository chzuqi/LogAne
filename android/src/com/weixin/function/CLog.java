package com.weixin.function;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class CLog implements FREFunction {

	private static final String TAG = "clog";
	
	@Override
	public FREObject call(FREContext context, FREObject[] arg1) {
		
		
		ExtensionShared.context = context;
		String type = null;
		String text = null;
		try
		{
			type = arg1[0].getAsString();
			text = arg1[1].getAsString();
			
		}
		catch(Exception e)
		{
			ExtensionShared.event("ARG_ERROR", "could not get from args");
			return null;
		}
		if (type.equals("error")){
			Log.e(TAG, text);
		}else if (type.equals("debug")){
			Log.d(TAG, text);
		}else if (type.equals("info")){
			Log.i(TAG, text);
		}else{
			Log.v(TAG, text);
		}
		return null;
	}

}
