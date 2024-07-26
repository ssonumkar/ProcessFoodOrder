package com.orderfood.process.ProcessOrder.service;

import com.orderfood.process.ProcessOrder.dao.ItemTypeRepository;
import com.orderfood.process.ProcessOrder.dao.OrderRepository;
import com.orderfood.process.ProcessOrder.entity.Item;
import com.orderfood.process.ProcessOrder.entity.Order;
import com.orderfood.process.ProcessOrder.exception.OrderValidationException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemTypeRepository itemTypeRepository;
    public OrderService(OrderRepository orderRepository, ItemTypeRepository itemTypeRepository) {
        this.orderRepository = orderRepository;
        this.itemTypeRepository = itemTypeRepository;
    }
    public void processOrder(Order order) throws Exception, OrderValidationException {
        if(!validate(order))
            throw new OrderValidationException("Invalid order");
        if (order.getItems() != null) {
            for (Item item : order.getItems()) {
                item.setOrder(order);
            }
        }
        //add business logic
        order.setStatus("COMPLETED");
        orderRepository.save(order);
    }
    private boolean validate(Order order) {
        for(Item item: order.getItems()){
            if(item.getItemType() != null && !this.itemTypeRepository.isItemTypeExist(item.getItemType()))
                return false;
        }
        return true;
    }
}
