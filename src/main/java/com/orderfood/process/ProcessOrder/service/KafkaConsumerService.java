package com.orderfood.process.ProcessOrder.service;


import com.orderfood.process.ProcessOrder.dao.ItemTypeRepository;
import com.orderfood.process.ProcessOrder.dao.OrderRepository;
import com.orderfood.process.ProcessOrder.entity.Item;
import com.orderfood.process.ProcessOrder.entity.Order;
import com.orderfood.process.ProcessOrder.exception.OrderValidationException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final OrderService  orderService;

    KafkaConsumerService(OrderService orderService){
        this.orderService = orderService;
    }

    @KafkaListener(topics = "test", groupId = "order-group")
    public void consume(Order order) {
        try {
            this.orderService.processOrder(order);
        }catch(Exception | OrderValidationException e){
            System.out.println("Error processing order: "+e.getMessage());
        }

    }


}