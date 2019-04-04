package com.shop.partsshop.dao;

import com.shop.partsshop.dao.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
List<Product> findAllByPriceBetween(float lower, float higher);
List<Product> findAllByNameContaining(String name);
List<Product> findAllByCategoryEquals(String category);
}
