package com.kalpesh.practice.registration.service;

import com.kalpesh.practice.registration.domain.Message;
import com.kalpesh.practice.registration.domain.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private Message msg;
    @Value("${jsa.rabbitmq.topicexchange}")
    private String topicexchange;

    @Value("${jsa.rabbitmq.routingkey3}")
    private String routingkey3;


    public void produce(User user){
//        msg = new Message(user.getUserId(), user.getPassword());
        rabbitTemplate.convertAndSend(topicexchange, routingkey3,user);

        System.out.println("Send msg = " + user);
    }
}
