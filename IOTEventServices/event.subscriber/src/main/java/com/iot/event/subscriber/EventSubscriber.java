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
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

@Service
@PropertySources({ @PropertySource(value = { "classpath:event.subscriber.properties" }), 
	               @PropertySource(value = {"file:${event.configuration.home}/environment.properties" }, 
	               ignoreResourceNotFound = true) })
@Import({ com.iot.event.cassandra.connection.config.CassandraAppConfig.class})
public class EventSubscriber implements MqttCallback, InitializingBean {

	private static Logger logger = LoggerFactory.getLogger(EventSubscriber.class);

	@Value("${iot.event.insert.query}")
	private String insertEventQuery;

	@Autowired
	private MQTTConfig mqttConfig;
	
	private MqttClient mqttClient;

	@Autowired
	private Session session;

	@Override
	public void afterPropertiesSet() throws Exception {
		mqttClient = mqttConfig.createMqttClient();
		mqttClient.setCallback(this);
		mqttClient.subscribe("topic/events");
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		logger.info("Topic name {}, payload {}", topic, new String(message.getPayload()));
		PreparedStatement prepared = session.prepare(insertEventQuery);
		session.execute(prepared.bind(new String(message.getPayload())));
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub

	}

}
