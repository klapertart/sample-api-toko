package klapertart.lab.toko;

import klapertart.lab.toko.entities.Category;
import klapertart.lab.toko.entities.Product;
import klapertart.lab.toko.entities.Supplier;
import klapertart.lab.toko.services.ProductService;
import klapertart.lab.toko.services.SupplierService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.transaction.Transactional;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Autowired
    private SupplierService supplierService;

    @Test
    void testSave() {
        Category category = Category.builder()
                .id("08decb4f-9602-4f6f-a5cd-7acb3145295e")
                .build();

        Product product = Product.builder()
                .category(category)
                .name("Molen")
                .price(2000.0)
                .build();

        Product product2 = Product.builder()
                .category(category)
                .name("Roti Lapis")
                .price(3000.0)
                .build();

        Product product3 = Product.builder()
                .category(category)
                .name("Keripik Kentang")
                .price(1500.0)
                .build();

        service.save(product);
        service.save(product2);
        service.save(product3);

        Assertions.assertEquals(3, service.getAll().size());
    }

    @Test
    void testSaveProductSupplier() {
        //Supplier supplier = supplierService.findById("cf6b69bb-232d-423d-b135-c9a4eb65da6b");

        Supplier supplier = new Supplier();
        supplier.setId("cf6b69bb-232d-423d-b135-c9a4eb65da6b");

        service.addSupplier(supplier,"73a59853-dc41-4b94-bf4f-3986610d72f3");
    }

}
