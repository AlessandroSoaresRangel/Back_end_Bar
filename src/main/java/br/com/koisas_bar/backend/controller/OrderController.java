package br.com.koisas_bar.backend.controller;

import br.com.koisas_bar.backend.domain.Orders;
import br.com.koisas_bar.backend.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private OrdersService service;

    @Autowired
    private OrderController(OrdersService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = service.getAllOrders();

        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable long id) {
        Orders order = service.getOrder(id);

        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Orders> createOrders(@RequestBody Orders order) {

       Orders orderSaved = service.createOrder(order);

        return ResponseEntity.status(201).body(orderSaved);
    }

    @PutMapping
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
        Orders modifiedOrder = service.updateOrder(order);

        return ResponseEntity.ok(modifiedOrder);
    }
}
