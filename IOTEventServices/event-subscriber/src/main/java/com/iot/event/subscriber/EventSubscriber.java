package com.iot.event.subscriber;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.iot.event.subscriber.util.MessageConverter;
import com.semisol.data.dao.api.DeviceEventsDAO;
import com.semisol.data.domain.DeviceEvent;

@Service
public class EventSubscriber implements MqttCallback, InitializingBean {

	private static Logger logger = LoggerFactory.getLogger(EventSubscriber.class);

	@Value("${iot.device.publish.topic}")
	private String iotDeviceEventsTopic;

	@Autowired
	private MQTTConfig mqttConfig;

	private MqttClient mqttClient;

	@Autowired
	private DeviceEventsDAO iotEventsDAO;

	@Override
	public void afterPropertiesSet() throws Exception {
		mqttClient = mqttConfig.createMqttClient();
		mqttClient.setCallback(this);
		mqttClient.subscribe(iotDeviceEventsTopic);
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) {
		logger.info("Topic name {}, payload {}", topic, new String(message.getPayload()));
		try {
			DeviceEvent iotEvents = MessageConverter.convertJsonToMapperObject(new String(message.getPayload()));
			iotEventsDAO.saveEventsInfo(iotEvents);
			//logger.info(""+iotEventsDAO.findLatestEventByDevice("12334"));
		} catch (Exception ex) {
			logger.error("Exception while processing the message ", ex);
		}

	}

	@Override
	public void connectionLost(Throwable cause) {
		logger.info("Connection to " + mqttConfig.getBrokerHost() + " lost!" + cause);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}	
}
