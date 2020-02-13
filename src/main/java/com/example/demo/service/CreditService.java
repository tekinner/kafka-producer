package com.example.demo.service;

import com.example.demo.entity.CreditEntity;
import com.example.demo.entity.repository.CreditRepository;
import com.example.demo.kafka_producer.KafkaProducer;
import com.example.demo.model.CreditModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private Gson gson;

    @RequestMapping(value = "/credit", method = RequestMethod.GET)
    public Object creditMessage(@RequestParam Integer memberid, @RequestParam String message, @RequestParam String transactiontype,
                                @RequestParam Double amount, @RequestParam String topic) {

        CreditModel creditModel = new CreditModel(memberid, message, transactiontype, amount,topic);
        System.out.println("*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--**-*-*-"+creditModel);
        //save to db
        CreditEntity creditEntity = new CreditEntity(memberid, message, transactiontype, amount, topic);
        creditRepository.save(creditEntity);

        //send message
        kafkaProducer.sendMessage(topic, gson.toJson(creditModel));

        return creditModel;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object healthCheck() {

        return "<h1>hello, you're on the PRODUCER service..it's working..</h1>";
    }



}

