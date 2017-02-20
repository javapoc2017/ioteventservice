package com.iot.event.subscriber;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iot.event.subscriber.util.MessageConverter;
import com.semisol.data.dao.api.IotEventsDAO;
import com.semisol.data.domain.IotEvents;

@Service
public class AppEventPublisher {

	private static Logger logger = LoggerFactory.getLogger(AppEventPublisher.class);

	@Value("${iot.app.publish.topic}")
	private String iotAppEventsTopic;

	@Autowired
	private MQTTConfig mqttConfig;

	private MqttClient mqttClient;
	
	@Autowired
	private IotEventsDAO iotEventsDAO;
	
	public void publishAppEvent(String eventMessage){
		try {
			mqttClient = mqttConfig.createMqttClient();
			MqttMessage message = new MqttMessage(eventMessage.getBytes());
			mqttClient.publish(iotAppEventsTopic, message);
			iotEventsDAO.saveEventsInfo(MessageConverter.convertJsonToMapperObject(eventMessage));
		} catch (Exception ex) {
			logger.error("Exception while publishing the message ", ex);
		}
	}
	
	public void publishAppEvent(IotEvents iotEvents){
		try {
			mqttClient = mqttConfig.createMqttClient();
			MqttMessage message = new MqttMessage(MessageConverter.convertObjectToJson(iotEvents).getBytes());
			mqttClient.publish(iotAppEventsTopic, message);
			iotEventsDAO.saveEventsInfo(iotEvents);
		} catch (Exception ex) {
			logger.error("Exception while publishing the message ", ex);
		}
	}
	
}
