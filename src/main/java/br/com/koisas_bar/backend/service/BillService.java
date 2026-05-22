package br.com.koisas_bar.backend.service;

import br.com.koisas_bar.backend.domain.Bill;
import br.com.koisas_bar.backend.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    private BillRepository repository;

    @Autowired
    private BillService(BillRepository repository) {
        this.repository = repository;
    }


    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    public Bill getBill(long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Bill not found."));
    }

    public Bill createBill(Bill bill) {
        return repository.save(bill);
    }

    public Bill updateBill(Bill bill) {
        getBill(bill.getId());

        return repository.save(bill);
    }
}
