package com.example.rabbit_api.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.example.rabbit_api.models.Case;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.AMQP.BasicProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AddMessageToRabbit {


    private static String QUEUE;

    private  static String rabbitmqHost;
    private  static String exchangeName;

    private  static Integer delay;

    @Value("${rabbitmq.queue_name}")
    public void setQueueNameStatic(String name){
        AddMessageToRabbit.QUEUE = name;
    }

    @Value("${rabbitmq.host}")
    public void setHostStatic(String name){
       AddMessageToRabbit.rabbitmqHost = name;
    }

    @Value("${rabbitmq.exchange}")
    public void setExchangeStatic(String name){
        AddMessageToRabbit.exchangeName = name;
    }

    @Value("${rabbitmq.delay}")
    public void setExchangeStatic(Integer value){
        AddMessageToRabbit.delay = value;
    }
    public void SendMessage(Case message, String routingKey)  throws IOException, TimeoutException  {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitmqHost);

        Map<String, Object> myHeaders = new HashMap<String, Object>();
        myHeaders.put("x-delay", delay);
        BasicProperties props = new BasicProperties.Builder()
                .headers(myHeaders)
                .build();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE, false, false, false, null);
            channel.basicPublish(exchangeName, routingKey, props, message.getCaseText().getBytes());

        }
    }
}
