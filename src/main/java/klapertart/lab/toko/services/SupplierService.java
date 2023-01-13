package klapertart.lab.toko.services;

import klapertart.lab.toko.entities.Supplier;
import klapertart.lab.toko.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository repository;

    public void save(Supplier supplier){
        repository.save(supplier);
    }

    public Supplier findById(String supplierId){
        Optional<Supplier> supplier = repository.findById(supplierId);
        if(supplier.isPresent()){
            return supplier.get();
        }
        return null;
    }

    public List<Supplier> getAll(){
        Iterable<Supplier> all = repository.findAll();
        if(all != null){
            List<Supplier> suppliers = new ArrayList<>();
            all.forEach(suppliers::add);
            return suppliers;
        }
        return null;
    }

    public void delete(Supplier supplier){
        repository.delete(supplier);
    }
}
