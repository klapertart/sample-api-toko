package klapertart.lab.toko.services;

import klapertart.lab.toko.entities.Category;
import klapertart.lab.toko.repositories.CategoryRepository;
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
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public void save(Category category){
        repository.save(category);
    }

    public Category findById(String categoryId){
        Optional<Category> category = repository.findById(categoryId);
        if(!category.isPresent()){
            return null;
        }
        return  category.get();
    }

    public List<Category> getAll(){
        Iterable<Category> all = repository.findAll();
        if (all != null){
            List<Category> categories = new ArrayList<>();
            all.forEach(categories::add);
            return categories;
        }
        return null;
    }

    public void delete(Category category){
        repository.delete(category);
    }
}
