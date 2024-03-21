package com.alga.reference.old.service;

import com.alga.reference.model.OrderItem;
import com.alga.reference.old.model.Guest;

import java.util.List;

public interface OrderService {

    void createOrder(List<OrderItem> orderItems, List<Guest> guests);

}
