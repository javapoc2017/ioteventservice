package com.iot.event.subscriber;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class MQTTConfig {

	@Value("${iot.mqtt.broker.host}")
	private String brokerHost;

	@Value("${iot.mqtt.broker.user.name}")
	private String username;

	@Value("${iot.mqtt.broker.password}")
	private String password;
	
    @Bean
    public MqttClient createMqttClient() throws MqttException, UnknownHostException, SocketException {
        final MemoryPersistence persistence = new MemoryPersistence();
        final MqttClient sampleClient = new MqttClient(brokerHost, getMacAddress(), persistence);
        final MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(username);
        connOpts.setPassword(password.toCharArray());
        sampleClient.connect(connOpts);
        return sampleClient;
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }
    
    private String getMacAddress() throws UnknownHostException, SocketException{
    	StringBuilder sb = new StringBuilder();
    	InetAddress ip = InetAddress.getLocalHost();
    	NetworkInterface network = NetworkInterface.getByInetAddress(ip);
		byte[] mac = network.getHardwareAddress();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
		return sb.toString();
    }

	public String getBrokerHost() {
		return brokerHost;
	}
    
}
