package com.demo.koolcloud.mvptest.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {

	public static JSONObject getResponseData(JSONObject dataJson) {
		JSONObject bodyJson = null;
		if (null != dataJson) {
			try {
				
				JSONArray bodyArray = dataJson.getJSONArray("body");
				if (null != bodyArray && bodyArray.length() > 0) {
					bodyJson = bodyArray.getJSONObject(0);
					
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bodyJson;
	}
}
