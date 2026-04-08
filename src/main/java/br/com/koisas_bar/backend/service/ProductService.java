package br.com.koisas_bar.backend.service;

import br.com.koisas_bar.backend.domain.Product;
import br.com.koisas_bar.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{

    private final ProductRepository repository;

    @Autowired
    public ProductService (ProductRepository repository) {
        this.repository = repository;
    }

    public Product getProduct(long id) {
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found."));
    }

    public Product createProduct(Product product) {
        return this.repository.save(product);
    }

    public List<Product> getAllProduct() {
        return this.repository.findAll();
    }

    public Product updateProduct(Product product) {
        this.repository.findById(product.getId())
                .orElseThrow(() -> new IllegalArgumentException("Object does not exist."));
        return this.repository.save(product);
    }
}
