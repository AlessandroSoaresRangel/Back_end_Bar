package br.com.koisas_bar.backend.controller;

import br.com.koisas_bar.backend.domain.RestaurantTable;
import br.com.koisas_bar.backend.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class RestaurantTableController {

    private RestaurantTableService service;

    @Autowired
    public RestaurantTableController(RestaurantTableService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantTable>> getAllTables() {
        return ResponseEntity.ok(service.getAllTable());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTable> getTable(@PathVariable long id) {
        return ResponseEntity.ok(service.getTable(id));
    }

    @PostMapping
    public ResponseEntity<RestaurantTable> createTable(@RequestBody RestaurantTable table) {
        return ResponseEntity.ok(service.createTable(table));
    }

    @PutMapping
    public ResponseEntity<RestaurantTable> updateTable(@RequestBody RestaurantTable table) {
        return ResponseEntity.ok(service.updateTable(table));
    }


}
