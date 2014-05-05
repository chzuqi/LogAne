package com.weixin.function;

import android.util.Log;

import com.adobe.fre.FREContext;

public class ExtensionShared {
	public static FREContext context = null;
	
	public static void event(String code,String level  ){
		Log.d(code, "event" + ":"+level );
		context.dispatchStatusEventAsync(code, level );
	}
	
}
