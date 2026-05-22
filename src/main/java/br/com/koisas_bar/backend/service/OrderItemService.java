package br.com.koisas_bar.backend.service;

import br.com.koisas_bar.backend.domain.OrderItem;
import br.com.koisas_bar.backend.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository repository;

    @Autowired
    public OrderItemService (OrderItemRepository repository) {
        this.repository = repository;
    }

    public OrderItem getOrder(long id) {
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("OrderItem not found."));
    }

    public OrderItem createOrder(OrderItem order) {
        return this.repository.save(order);
    }

    public List<OrderItem> getAllOrderItem() {
        return this.repository.findAll();
    }

    public OrderItem updateOrderItem(OrderItem order) {
        this.repository.findById(order.getId())
                .orElseThrow(() -> new IllegalArgumentException("Object does not exist."));
        return this.repository.save(order);
    }
}
