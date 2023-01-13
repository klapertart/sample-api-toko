package klapertart.lab.toko.services;

import klapertart.lab.toko.entities.Product;
import klapertart.lab.toko.entities.Supplier;
import klapertart.lab.toko.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void save(Product product){
        repository.save(product);
    }

    public Product findById(String productId){
        Optional<Product> product = repository.findById(productId);
        if(!product.isPresent()){
            return null;
        }
        return product.get();
    }

    public Product findByName(String productName){
        return repository.findByName(productName);
    }

    public List<Product> findByCategory(String categoryId){
        return repository.findByCategory(categoryId);
    }

    public List<Product> getAll(){
        Iterable<Product> all = repository.findAll();
        if (all != null){
            List<Product> products = new ArrayList<>();
            all.forEach(products::add);
            return  products;
        }
        return null;
    }

    public void delete(Product product){
        repository.delete(product);
    }

    public void addSupplier(Supplier supplier, String productId){
        Product product = findById(productId);
        if (product == null){
            throw new RuntimeException("Data product tidak ada");
        }

        product.getSuppliers().add(supplier);
        save(product);

    }
}
