package klapertart.lab.toko.repositories;

import klapertart.lab.toko.entities.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, String> {
}
