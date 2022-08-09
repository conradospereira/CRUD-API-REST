package com.example.mercadoteixeira.inventorycontrol;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.mercadoteixeira.inventorycontrol.Model.Product;
import com.example.mercadoteixeira.inventorycontrol.Repository.ProductRepository;

@SpringBootApplication
public class InventorycontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorycontrolApplication.class, args);
	}

	@Bean
	CommandLineRunner init (ProductRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Product p = new Product();
						p.setProductDescription ("Product " + i);
						p.setProductCode("1111111111111");
						p.setProductPrice("111,111");
						p.setProductQuantity("11111111");
						return p;
					})
					.map (v -> repository.save(v))
					.forEach (System.out::println);
		};
	}

}
