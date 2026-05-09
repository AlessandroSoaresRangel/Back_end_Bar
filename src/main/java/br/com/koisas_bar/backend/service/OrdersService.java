package br.com.koisas_bar.backend.service;

import br.com.koisas_bar.backend.domain.Orders;
import br.com.koisas_bar.backend.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {


    private final OrdersRepository repository;

    @Autowired
    public OrdersService (OrdersRepository repository) {
        this.repository = repository;
    }

    public Orders getOrder(long id) {
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found."));
    }

    public Orders createOrder(Orders order) {
        return this.repository.save(order);
    }

    public List<Orders> getAllOrders() {
        return this.repository.findAll();
    }

    public Orders updateProduct(Orders order) {
        this.repository.findById(order.getId())
                .orElseThrow(() -> new IllegalArgumentException("Object does not exist."));
        return this.repository.save(order);
    }


}
