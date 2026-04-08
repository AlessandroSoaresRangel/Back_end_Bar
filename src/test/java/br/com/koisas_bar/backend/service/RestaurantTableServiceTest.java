package br.com.koisas_bar.backend.service;

import br.com.koisas_bar.backend.domain.RestaurantTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class RestaurantTableServiceTest {

    @Autowired
    private TableService service;

    private static RestaurantTable restaurantTable;

    @BeforeAll
    static void init(){
        restaurantTable = new RestaurantTable();
        restaurantTable.setNumber(5);
        restaurantTable.setStatus(RestaurantTable.Status.ABERTA);
    }

    @Test
    public void createTableTest(){
        RestaurantTable savedRestaurantTable = service.createTable(restaurantTable);

        Assertions.assertNotNull(savedRestaurantTable);
        Assertions.assertEquals(restaurantTable, savedRestaurantTable);
    }

    @Test
    public void updateTableTest(){



        RestaurantTable savedRestaurantTable = service.updateTable(restaurantTable);

        Assertions.assertNotNull(savedRestaurantTable);
    }
}
