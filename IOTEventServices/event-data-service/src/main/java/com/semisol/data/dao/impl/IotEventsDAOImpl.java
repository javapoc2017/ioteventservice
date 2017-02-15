package com.semisol.data.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.semisol.data.dao.api.IotEventsDAO;

@Configuration
@PropertySources({ @PropertySource(value = { "classpath:cassandra-data-service.properties" }), @PropertySource(value = {
		"file:${event.configuration.home}/environment.properties" }, ignoreResourceNotFound = true) })
@Import({ com.semisol.data.config.CassandraConfiguration.class })
public class IotEventsDAOImpl implements IotEventsDAO {
	
	/*@Autowired
	private IotEventsRepository iotEventsRepository;*/

	@Autowired
	private Session session;

	@Value("${iot.device.event.insert.query}")
	private String insertEventQuery;

	@Value("${iot.device.event.select.query}")
	private String deviceSelectQuery;
	//will move latter to repo
	public void saveEventsInfo(String message) throws Exception {
		Object obj = JSONValue.parse(message);
		JSONObject jsonObject = (JSONObject) obj;
		String devid = (String) jsonObject.get("devid");
		String devloginid = (String) jsonObject.get("devloginid");
		String devtype = (String) jsonObject.get("devtype");
		Timestamp eventTime = Timestamp.valueOf((String) jsonObject.get("event_time"));
		JSONObject attributesJson = (JSONObject) jsonObject.get("attributes");
		Map<String, String> attributes = new HashMap<>();
		for (Object key : attributesJson.keySet()) {
			String keyStr = (String) key;
			String valStr = (String) attributesJson.get(keyStr);
			attributes.put(keyStr, valStr);
		}
		PreparedStatement pstatement = session.prepare(insertEventQuery);
		session.execute(pstatement.bind(devid, devloginid, devtype, eventTime, attributes));
	}

	public String getEventDataByDevice(String devId) throws ClassNotFoundException {
		String deviceSelectQuery1 = "SELECT * FROM iotevents_v1.iot_events WHERE devid='" + devId
				+ "' ORDER BY event_time DESC LIMIT 1";
		for (Row row : session.execute(deviceSelectQuery1)) {
			String devid = row.getString("devid");
			String devloginid = row.getString("devloginid");
			String devtype = row.getString("devtype");
			Date eventTime = row.getTimestamp("event_time");
			Map<String, String> attribues = (Map<String, String>) row.getMap("attributes",
					Class.forName("java.lang.String"), Class.forName("java.lang.String"));
		}
		return "";
	}

}
