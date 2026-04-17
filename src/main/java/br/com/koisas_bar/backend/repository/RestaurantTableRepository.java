package br.com.koisas_bar.backend.repository;

import br.com.koisas_bar.backend.domain.RestaurantTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantTableRepository extends CrudRepository<RestaurantTable, Long> {
    List<RestaurantTable> findAll();
}
