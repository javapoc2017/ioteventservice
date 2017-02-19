package com.iot.event.subscriber.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.semisol.data.domain.IotEvents;

public class MessageConverter {

	private static Gson gson = null;
	
	private static Gson getGsonObject(){
		if(gson == null){
			gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		}
		return gson;
	}
	
	public static IotEvents convertJsonToMapperObject(String jsonrString) throws JsonParseException{
		return getGsonObject().fromJson(jsonrString, new TypeToken<IotEvents>(){}.getType());
	}
	
	public static String convertObjectToJson(Object deviceObj){
		return getGsonObject().toJson(deviceObj);
	}
}
