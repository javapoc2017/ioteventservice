package com.iot.event.subscriber.test;

import java.util.Date;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class EventPublisher {

    public static void publishMessages() throws MqttException {

        String topic = "iot/device/publishevents";
        int qos = 2;
        String broker = "tcp://m11.cloudmqtt.com:17832";//"tcp://127.0.0.1:1883";
        String userName="pulvnqwm";
        String password="X5dGnZ_Vq4BO";		
        String clientId = "publisherClientId";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName(userName);
            connOpts.setPassword(password.toCharArray());
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            MqttMessage message = new MqttMessage(prepareSwitchEventMessage().getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
        } catch (final MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
    
    private static String prepareSwitchEventMessage(){
    	return null;
    }
   
    private static String prepareSensorEventMessage(){
    	return null;
    }
    
    public static void main(String ar[]) throws Exception{
    	publishMessages();
    }
}
