package br.com.koisas_bar.backend.service;

import br.com.koisas_bar.backend.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;


@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService service;


    @Test
    void updateProduct_happyPathTest() {
        Product product = new Product();
        product.setId(3L);
        product.setName("Outro nome");
        product.setQuantity(4);
        product.setBuyingDate(Date.valueOf("2026-03-07"));
        product.setType("teste");
        product.setBuyingPrice(9D);
        product.setSellingPrice(20D);

        Product returning = this.service.updateProduct(product);

        Assertions.assertEquals(product.getId(), returning.getId());
        Assertions.assertEquals(product.getName(), returning.getName());

    }

    @Test
    void updateProduct_WithDifferentIdTest() {
        Product product = new Product();
        product.setId(20000L);
        product.setName("Outro nome");
        product.setQuantity(4);
        product.setBuyingDate(Date.valueOf("2026-03-07"));
        product.setType("teste");
        product.setBuyingPrice(9D);
        product.setSellingPrice(20D);

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.service.updateProduct(product));
    }


    @Test
    void getProduct_IdNotFoundTest() {
        Assertions.assertThrows(IllegalArgumentException.class,() ->this.service.getProduct(2000));

    }
}
