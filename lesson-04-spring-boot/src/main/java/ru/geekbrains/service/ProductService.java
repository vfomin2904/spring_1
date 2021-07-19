package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductDao;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

   public List<Product> findAll(){return productDao.findAll();}

   public Optional<Product> findById(Long id){
        return productDao.findById(id);
   }

   public void save(Product product){
       productDao.save(product);
   }

    public List<Product> findByPriceBetween(Integer min, Integer max) {
        return productDao.findByPriceBetween(min, max);
    }

    public List<Product> findByPriceGreaterThanEqual(Integer min) {
        return productDao.findByPriceGreaterThanEqual(min);

    }

    public List<Product> findByPriceLessThanEqual(Integer max) {
        return productDao.findByPriceLessThanEqual(max);
    }

    public void deleteById(Long id){
        productDao.deleteById(id);
    }
}
