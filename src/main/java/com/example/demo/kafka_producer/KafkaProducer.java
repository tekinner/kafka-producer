package com.example.demo.kafka_producer;

import com.example.demo.model.CreditModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String topic, String payload){
        kafkaTemplate.send(topic, payload);
        logger.info(">>>>>>>>>>>>>>>>>> Message Sent! <<<<<<<<<<<<<<<<<<<<<<<<");
    }


}
