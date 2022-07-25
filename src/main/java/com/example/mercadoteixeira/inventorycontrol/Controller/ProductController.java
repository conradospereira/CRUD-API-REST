package com.example.mercadoteixeira.inventorycontrol.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.example.mercadoteixeira.inventorycontrol.Model.Product;
import com.example.mercadoteixeira.inventorycontrol.Repository.ProductRepository;
import org.springframework.web.bind.annotation.PutMapping;


//import com.example.mercadoteixeira.inventorycontrol.Repository.ProductRepository;

@RestController
@RequestMapping({"/product"})
public class ProductController {
    
    private ProductRepository repository;

    ProductController(ProductRepository productRepository) {
         this.repository = productRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return repository.save(product);
    }

    //@PutMapping(value="/{id}")
    //public ResponseEntity update(@PathVariable("id") long id, @RequestBody Product product){

    //    return repository.findById(id)
    //            .map(record -> {
    //                record.setName(productDescription.getName());
    //            });
    //}


}
