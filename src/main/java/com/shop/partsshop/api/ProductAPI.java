package com.shop.partsshop.api;

import com.shop.partsshop.dao.entity.Product;
import com.shop.partsshop.manager.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ProductAPI {
    private ProductManager products;

    @Autowired
    public ProductAPI(ProductManager products) {
        this.products = products;
    }

    //wypisz wszystkie produkty
    @GetMapping("/all")
    public Iterable<Product> getAll() {
        return products.findAll();
    }

    //wypisz produkt o id
    @GetMapping
    public Optional<Product> getId(@RequestParam long id) {
        return products.findById(id);
    }

    //dodaj produkt
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return products.save(product);
    }

    //nadpisz produkt
    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return products.save(product);
    }

    //usun produkt
    @DeleteMapping
    public void deleteProduct(@RequestBody long id){
        products.deleteById(id);
    }
}
