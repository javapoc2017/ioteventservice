package com.iot.event.subscriber;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({ @PropertySource(value = { "classpath:event.subscriber.properties" }), 
    @PropertySource(value = {"file:${event.configuration.home}/environment.properties" }, 
    ignoreResourceNotFound = true) })
public class MQTTConfig {

	@Value("${iot.mqtt.broker.host}")
	private String brokerHost;

	@Value("${iot.mqtt.client.id}")
	private String clientId;

	
    @Bean
    public MqttClient createMqttClient() throws MqttException {
        final MemoryPersistence persistence = new MemoryPersistence();
        final MqttClient sampleClient = new MqttClient(brokerHost, clientId, persistence);
        final MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        sampleClient.connect(connOpts);
        return sampleClient;
    }

}
