package klapertart.lab.toko.controllers;

import klapertart.lab.toko.data.ProductInputDto;
import klapertart.lab.toko.data.ProductUpdateDto;
import klapertart.lab.toko.data.SupplierDto;
import klapertart.lab.toko.entities.Category;
import klapertart.lab.toko.entities.Product;
import klapertart.lab.toko.entities.Supplier;
import klapertart.lab.toko.messages.ResponseError;
import klapertart.lab.toko.messages.ResponseGeneric;
import klapertart.lab.toko.messages.ResponseSuccess;
import klapertart.lab.toko.messages.ResponseUtil;
import klapertart.lab.toko.services.CategoryService;
import klapertart.lab.toko.services.ProductService;
import klapertart.lab.toko.services.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kurakuraninja
 * @since 10/01/23
 */

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService service;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SupplierService supplierService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseGeneric> save(@Valid @RequestBody ProductInputDto productInputDTO, Errors errors){
        if (errors.hasErrors()){
            Map<String,String> tError = new HashMap<>();
            for (ObjectError error : errors.getAllErrors()){
                FieldError fieldError = (FieldError) error;
                tError.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseError(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(), tError));
        }

        Category category = categoryService.findById(productInputDTO.getCategoryId());

        if (category == null){
            Map<String,String> mapError = new HashMap<>();
            mapError.put("categoryId","Id not registered");

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseError(HttpStatus.BAD_REQUEST.value(),
                            HttpStatus.BAD_REQUEST.name(),
                            mapError));
        }

        Product product = Product.builder()
                .price(productInputDTO.getPrice())
                .name(productInputDTO.getName())
                .category(category)
                .build();
        service.save(product);

        return ResponseUtil.success();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseGeneric> update(@Valid @RequestBody ProductUpdateDto productUpdateDTO, Errors errors){
        if (errors.hasErrors()){
            Map<String,String> tError = new HashMap<>();
            for (ObjectError error : errors.getAllErrors()){
                FieldError fieldError = (FieldError) error;
                tError.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseError(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(), tError));
        }

        Category category = categoryService.findById(productUpdateDTO.getCategoryId());

        if (category == null){
            Map<String,String> mapError = new HashMap<>();
            mapError.put("categoryId","Id not registered");

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseError(HttpStatus.BAD_REQUEST.value(),
                            HttpStatus.BAD_REQUEST.name(),
                            mapError));
        }

        Product product = Product.builder()
                .id(productUpdateDTO.getId())
                .price(productUpdateDTO.getPrice())
                .name(productUpdateDTO.getName())
                .category(category)
                .build();
        service.save(product);

        return ResponseUtil.success();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseGeneric> findById(@PathVariable String id){
        Product product = service.findById(id);

        if (product == null){
            return ResponseUtil.notFound();
        }

        List<Product> products = new ArrayList<>();
        products.add(product);
        return ResponseEntity
                .ok(new ResponseSuccess<Product>(HttpStatus.OK.value(),HttpStatus.OK.name(),products));

    }

    @GetMapping(path = "/category/{id}")
    public ResponseEntity<ResponseGeneric> findByCategoryId(@PathVariable String id){
        List<Product> products = service.findByCategory(id);

        if (products == null){
            return ResponseUtil.notFound();
        }

        return ResponseEntity
                .ok(new ResponseSuccess<Product>(HttpStatus.OK.value(),HttpStatus.OK.name(),products));
    }

    @GetMapping
    public ResponseEntity<ResponseGeneric> getAll(){
        List<Product> products = service.getAll();

        if (products == null){
            return ResponseUtil.notFound();
        }

        return ResponseEntity
                .ok(new ResponseSuccess<Product>(HttpStatus.OK.value(),HttpStatus.OK.name(),products));

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseGeneric> delete(@PathVariable String id){
        Product product = service.findById(id);

        if(product == null){
            Map<String,String> mapError = new HashMap<>();
            mapError.put("product id","Id not registered");

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseError(HttpStatus.BAD_REQUEST.value(),
                            HttpStatus.BAD_REQUEST.name(),
                            mapError));
        }

        service.delete(product);

        return ResponseUtil.success();
    }

    @PostMapping(path = "/supplier",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseGeneric> addSupplier(@Valid @RequestBody SupplierDto supplierDTO, Errors errors){
        if (errors.hasErrors()){
            Map<String,String> tError = new HashMap<>();
            for (ObjectError error : errors.getAllErrors()){
                FieldError fieldError = (FieldError) error;
                tError.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseError(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(), tError));
        }

        Product product = service.findById(supplierDTO.getProductId());
        if (product == null){
            Map<String,String> mapError = new HashMap<>();
            mapError.put("productId","Id not registered");

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseError(HttpStatus.BAD_REQUEST.value(),
                            HttpStatus.BAD_REQUEST.name(),
                            mapError));
        }

        Supplier supplier = supplierService.findById(supplierDTO.getSupplierId());
        if (supplier == null){
            Map<String,String> mapError = new HashMap<>();
            mapError.put("supplierId","Id not registered");

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseError(HttpStatus.BAD_REQUEST.value(),
                            HttpStatus.BAD_REQUEST.name(),
                            mapError));
        }

        service.addSupplier(supplier,product.getId());

        return ResponseUtil.success();
    }

}
