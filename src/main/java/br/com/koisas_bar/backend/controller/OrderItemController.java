package br.com.koisas_bar.backend.controller;

import br.com.koisas_bar.backend.domain.OrderItem;
import br.com.koisas_bar.backend.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/OrderItem")
public class OrderItemController {


    private OrderItemService service;

    @Autowired
     private OrderItemController (OrderItemService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItem(@PathVariable long id) {
        OrderItem item = service.getOrder(id);

        return ResponseEntity.ok(item);
    }

    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItem() {
        List<OrderItem> items = service.getAllOrderItem();

        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem item = service.createOrder(orderItem);

        return ResponseEntity.status(201).body(item);
    }

    @PutMapping
    public ResponseEntity<OrderItem> updateOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem item = service.updateOrderItem(orderItem);

        return ResponseEntity.ok(item);
    }
}
