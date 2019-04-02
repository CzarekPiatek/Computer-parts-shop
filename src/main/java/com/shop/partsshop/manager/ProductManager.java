package com.shop.partsshop.manager;

import com.shop.partsshop.dao.ProductRepo;
import com.shop.partsshop.dao.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductManager {

    private ProductRepo productRepo;

    @Autowired
    public ProductManager(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public void deleteById(Long id) {
       productRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase()
    {
        save(new Product("lel","lel",30.5f));
        save(new Product("eeel","eeeel",55.5f));
    }

}
