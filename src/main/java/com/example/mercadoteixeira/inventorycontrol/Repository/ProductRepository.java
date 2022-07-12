package com.example.mercadoteixeira.inventorycontrol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mercadoteixeira.inventorycontrol.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}