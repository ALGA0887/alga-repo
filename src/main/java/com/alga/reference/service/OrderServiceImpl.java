package com.alga.reference.service;

import com.alga.reference.model.Guest;
import com.alga.reference.model.OrderItem;
import com.alga.reference.repository.GuestRepository;
import com.alga.reference.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final GuestRepository guestRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public void createOrder(List<OrderItem> orderItems, List<Guest> guests) {
        orderItemRepository.saveAll(orderItems);
        guestRepository.saveAll(guests);
    }
}
