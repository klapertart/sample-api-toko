package klapertart.lab.toko;

import klapertart.lab.toko.entities.Category;
import klapertart.lab.toko.services.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService service;

    @Test
    void testSave() {
        Category category = Category.builder()
                .name("Makanan")
                .build();
        Category category2 = Category.builder()
                .name("Minuman")
                .build();
        Category category3 = Category.builder()
                .name("Obat-obatan")
                .build();

        service.save(category);
        service.save(category2);
        service.save(category3);

        Assertions.assertEquals(3,service.getAll().size());
    }
}
