package klapertart.lab.toko.repositories;

import klapertart.lab.toko.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@Repository
public interface ProductRepository extends CrudRepository<Product,String> {
    Product findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.category.id = :id")
    List<Product> findByCategory(@PathParam("id") String id);
}
