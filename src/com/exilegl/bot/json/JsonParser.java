package com.exilegl.bot.json;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
	
	/**
	 * Returns the content of a given tag
	 * from a URL
	 * @param tag The tag you wish to fetch
	 * @param url The URL which you wish to fetch from
	 */
	public String getFromUrl(String tag, String url){
		String content = ("");
		try{
			JSONObject json = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
			content = (json.getString(tag).toString());
		}catch(JSONException | IOException e){
			content = ("Failed to fetch JSON from URL");
		}
		return content;
	}
	
}
