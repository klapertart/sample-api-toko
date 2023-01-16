package klapertart.lab.toko.controllers;

import klapertart.lab.toko.data.CategoryDto;
import klapertart.lab.toko.data.CategoryUpdateDto;
import klapertart.lab.toko.entities.Category;
import klapertart.lab.toko.messages.ResponseError;
import klapertart.lab.toko.messages.ResponseGeneric;
import klapertart.lab.toko.messages.ResponseUtil;
import klapertart.lab.toko.services.CategoryService;
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
import java.util.HashMap;
import java.util.Map;

/**
 * @author kurakuraninja
 * @since 16/01/23
 */

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseGeneric> save(@Valid @RequestBody CategoryDto categoryDto, Errors errors){
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

        Category category = modelMapper.map(categoryDto,Category.class);
        categoryService.save(category);

        return ResponseUtil.success();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseGeneric> save(@Valid @RequestBody CategoryUpdateDto categoryDto, Errors errors){
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

        Category category = modelMapper.map(categoryDto,Category.class);
        categoryService.save(category);

        return ResponseUtil.success();
    }

}
