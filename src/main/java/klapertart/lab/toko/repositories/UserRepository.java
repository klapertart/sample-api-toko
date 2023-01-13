package klapertart.lab.toko.repositories;

import klapertart.lab.toko.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author kurakuraninja
 * @since 13/01/23
 */

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
