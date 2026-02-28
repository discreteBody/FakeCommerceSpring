package com.example.FakeCommerce.services;

import com.example.FakeCommerce.repositories.OrderRepository;
import com.example.FakeCommerce.schema.Order;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepository  orderRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder() {
        return orderRepository.save(new Order());
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order getorderById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return null;
    }

    public void getOrderSummary(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));

    }

    public Order updateOrder(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));

        return orderRepository.save(order);
    }
}
