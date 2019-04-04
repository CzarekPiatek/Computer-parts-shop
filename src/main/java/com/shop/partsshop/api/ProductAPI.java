package com.shop.partsshop.api;

import com.shop.partsshop.dao.entity.Product;
import com.shop.partsshop.manager.ProductManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ProductAPI {
    private ProductManager productManager;

    public ProductAPI(ProductManager productManager) {
        this.productManager = productManager;
    }

    //wypisz wszystkie produkty
    @GetMapping("/all")
    public Iterable<Product> getAll() {
        return productManager.findAll();
    }

    //wypisz produkt o id
    @GetMapping("/{id}")
    public Optional<Product> getId(@PathVariable long id) {
        return productManager.findById(id);
    }

    //dodaj produkt
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productManager.save(product);
    }

    //nadpisz produkt
    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productManager.save(product);
    }

    //usun produkt
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id){
        productManager.deleteById(id);
    }

    //znajdz produkt w przedziale cenowym
    @GetMapping("/price")
    public List<Product> findAllByPriceBetween(@RequestParam float lower, @RequestParam float higher)
    {
        return productManager.findAllByPriceBetween(lower,higher);
    }

    //produkt o nazwie
    @GetMapping("/name")
    public List<Product> findAllByNameContaining(@RequestParam String name)
    {
        return productManager.findAllByNameContaining(name);
    }

    //produkt danej kategorii
    @GetMapping("/category")
    public List<Product> findAllByCategoryEquals(@RequestParam String category)
    {
        return productManager.findAllByCategoryEquals(category);
    }
}
