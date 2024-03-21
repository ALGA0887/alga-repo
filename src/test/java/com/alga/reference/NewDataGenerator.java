package com.alga.reference;

import com.alga.reference.model.Guest;
import com.alga.reference.model.OrderItem;
import com.alga.reference.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("NewDataGenerator")
public class NewDataGenerator implements DataGenerator {

    private final OrderService orderService;

    public NewDataGenerator(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void generate() {
        // Create com.alga.reference.model.Guest without DBRef (simulate new data in database)
        OrderItem orderItem1 = new OrderItem("orderItem4", "first course", List.of("guest_with_docref"));
        OrderItem orderItem2 = new OrderItem("orderItem5", "second course", List.of("guest_with_docref"));
        OrderItem orderItem3 = new OrderItem("orderItem6", "dessert", List.of("guest_with_docref"));
        List<OrderItem> orderItems = List.of(orderItem1, orderItem2, orderItem3);
        Guest guest = new Guest("guest_with_docref", "Alexander");
        orderService.createOrder(orderItems, List.of(guest));
    }
}
