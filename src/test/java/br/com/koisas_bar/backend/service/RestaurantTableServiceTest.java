package br.com.koisas_bar.backend.service;

import br.com.koisas_bar.backend.domain.RestaurantTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class RestaurantTableServiceTest {

    @Autowired
    private RestaurantTableService service;

    @Test
     void createTableTest(){
        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setNumber(5);
        restaurantTable.setStatus(RestaurantTable.Status.ABERTA);

        RestaurantTable savedRestaurantTable = service.createTable(restaurantTable);

        Assertions.assertNotNull(savedRestaurantTable);
        Assertions.assertEquals(restaurantTable, savedRestaurantTable);
    }

    @Test
     void updateTableTest(){

        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setNumber(5);
        restaurantTable.setStatus(RestaurantTable.Status.ABERTA);

        RestaurantTable saved = service.createTable(restaurantTable);

        RestaurantTable savedRestaurantTable = service.updateTable(saved);

        Assertions.assertNotNull(savedRestaurantTable);
    }
}
