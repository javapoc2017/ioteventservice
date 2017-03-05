package com.iot.event.subscriber.util;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.semisol.data.domain.DeviceEvent;

public class MessageConverter {

	private static Gson gson = null;
	
	private static Gson getGsonObject(){
		if(gson == null){
			gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		}
		return gson;
	}
	
	public static DeviceEvent convertJsonToMapperObject(String jsonrString) throws JsonParseException{
		DeviceEvent iotEvents = getGsonObject().fromJson(jsonrString, new TypeToken<DeviceEvent>(){}.getType());
		iotEvents.setEventId(UUID.randomUUID());
		if(iotEvents.getEventTime() == null){
			Calendar cal=Calendar.getInstance();
			iotEvents.setEventTime(new Timestamp(cal.getTimeInMillis()));
		}
		return iotEvents;
	}
	
	public static String convertObjectToJson(Object deviceObj){
		return getGsonObject().toJson(deviceObj);
	}
}
