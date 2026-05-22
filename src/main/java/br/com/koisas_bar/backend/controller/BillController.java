package br.com.koisas_bar.backend.controller;

import br.com.koisas_bar.backend.domain.Bill;
import br.com.koisas_bar.backend.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bill")
public class BillController {

    private BillService service;

    @Autowired
    private BillController(BillService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBill(@PathVariable long id) {
        Bill bill = service.getBill(id);

        return ResponseEntity.ok(bill);
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBill() {
        List<Bill> bills = service.getAllBill();

        return ResponseEntity.ok(bills);
    }

    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        Bill newBill = service.createBill(bill);

        return ResponseEntity.status(201).body(newBill);
    }

    @PutMapping
    public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) {
        Bill newBill = service.updateBill(bill);

        return ResponseEntity.ok(newBill);
    }
}
