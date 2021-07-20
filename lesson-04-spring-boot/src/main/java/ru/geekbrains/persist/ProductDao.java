package ru.geekbrains.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{
    List<Product> findByPriceBetween(Integer min, Integer max);

    List<Product> findByPriceGreaterThanEqual(Integer min);

    List<Product> findByPriceLessThanEqual(Integer max);
}
