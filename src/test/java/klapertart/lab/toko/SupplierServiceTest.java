package klapertart.lab.toko;

import klapertart.lab.toko.entities.Product;
import klapertart.lab.toko.entities.Supplier;
import klapertart.lab.toko.services.ProductService;
import klapertart.lab.toko.services.SupplierService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@SpringBootTest
public class SupplierServiceTest {

    @Autowired
    private SupplierService service;

    @Test
    void testSave() {
        Supplier supplier = Supplier.builder()
                .name("Majalengka Food")
                .address("Majalengka")
                .build();
        service.save(supplier);

        Supplier supplier2 = Supplier.builder()
                .name("Bandung Food")
                .address("Bandung")
                .build();
        service.save(supplier2);

        Assertions.assertEquals(2, service.getAll().size());
    }

}
