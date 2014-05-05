package com.clog.ane;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.weixin.function.CLog;

public class CLogContext extends FREContext {
	
	private static final String CLOG_TO_CONSOLE = "clog_to_console";
	@Override
	public void dispose() {

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		//映射
		map.put(CLOG_TO_CONSOLE, new CLog());
		return map;
	}

}
