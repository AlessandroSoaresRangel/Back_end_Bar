package br.com.koisas_bar.backend.repository;

import br.com.koisas_bar.backend.domain.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

    List<Orders> findAll();

}
