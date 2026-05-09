package br.com.koisas_bar.backend.repository;

import br.com.koisas_bar.backend.domain.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillRepository extends CrudRepository<Bill, Long> {
    List<Bill> findAll();
}
