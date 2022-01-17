package com.manifestcorp.onsoracledb.listener;

import com.manifestcorp.onsdomain.Order;
import com.manifestcorp.onsoracledb.dao.OrderMapper;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OnsOracleDbKafkaConsumer {
    private Logger logger = LoggerFactory.getLogger(OnsOracleDbKafkaConsumer.class);

    @Autowired
    OrderMapper orderMapper;

    @KafkaListener(topics = "${k.topic.consumer.name}")
    @Mapper
    public void listener(Order order){
        logger.info(order.toString());
        orderMapper.insertOrder(order);
    }



}
