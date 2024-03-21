package com.alga.reference;

import com.alga.reference.model.OrderItem;
import com.alga.reference.old.model.Guest;
import com.alga.reference.old.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("OldDataGenerator")
public class OldDataGenerator implements DataGenerator {

    private final OrderService orderService;

    @Autowired
    public OldDataGenerator(@Qualifier("OldOrderService") OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void generate() {
        // Create com.alga.reference.old.model.Guest with DbRef (simulate old data in database)
        OrderItem orderItem1 = new OrderItem("orderItem1", "first course", List.of("guest_with_dbref"));
        OrderItem orderItem2 = new OrderItem("orderItem2", "second course", List.of("guest_with_dbref"));
        OrderItem orderItem3 = new OrderItem("orderItem3", "dessert", List.of("guest_with_dbref"));
        List<OrderItem> orderItems = List.of(orderItem1, orderItem2, orderItem3);
        Guest guest = new Guest("guest_with_dbref", "Alexander", orderItems);
        orderService.createOrder(orderItems, List.of(guest));
    }
}
