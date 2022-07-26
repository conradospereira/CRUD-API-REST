package com.example.mercadoteixeira.inventorycontrol.Controller;

import org.hibernate.mapping.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.mercadoteixeira.inventorycontrol.Model.Product;
import com.example.mercadoteixeira.inventorycontrol.Repository.ProductRepository;

@RestController
@RequestMapping({"/product"})
public class ProductController {
    
    private ProductRepository repository;

    ProductController(ProductRepository productRepository) {
         this.repository = productRepository;
    }

    @GetMapping
    public List findAll() {
        return (List) repository.findAll();
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

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Product product){

        return repository.findById(id)
                .map(record -> {
                    record.setProductDescription(product.getProductDescription());
                    record.setProductCode(product.getProductCode());
                    record.setProductQuantity(product.getProductQuantity());
                    record.setProductPrice(product.getProductPrice());
                    Product updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


}
