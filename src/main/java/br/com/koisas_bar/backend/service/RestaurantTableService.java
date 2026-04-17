package br.com.koisas_bar.backend.service;

import br.com.koisas_bar.backend.domain.RestaurantTable;
import br.com.koisas_bar.backend.repository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepository repository;

    @Autowired
    public RestaurantTableService(RestaurantTableRepository repository) {
        this.repository = repository;
    }

    public RestaurantTable getTable(long id) {
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Table not found."));
    }

    public RestaurantTable createTable(RestaurantTable restaurantTable) {
        return this.repository.save(restaurantTable);
    }

    public List<RestaurantTable> getAllTable() {
        return this.repository.findAll();
    }

    public RestaurantTable updateTable(RestaurantTable restaurantTable) {
        this.repository.findById(restaurantTable.getId())
                .orElseThrow(() -> new IllegalArgumentException("Object does not exist."));
        return this.repository.save(restaurantTable);
    }
}
