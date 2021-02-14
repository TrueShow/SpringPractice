package com.gb.lesson_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductInMemoryRepository productInMemoryRepository;

    public int countProducts() {
        List<Product> products = productInMemoryRepository.readProducts();
        int count = 0;
        for (Product product: products) {
            count += 1;
        }
        return count;
    }

    public double avrPrice() {
        List<Product> products = productInMemoryRepository.readProducts();
        double avrPrice = 0;
        for (Product product: products) {
            avrPrice += product.getPrice();
        }
        return avrPrice / products.size();
    }

    public void createProduct(int id, String title, double Price) {
        productInMemoryRepository.createProduct(id, title, Price);
    }

    public void deleteProduct(int id) {
        productInMemoryRepository.deleteProduct(id);
    }

    public List<Product> readProducts() {
        return productInMemoryRepository.readProducts();
    }

    public Product readProduct(int id) {
        return productInMemoryRepository.readProduct(id);
    }

    public void updateProduct(int id, double price) {
        productInMemoryRepository.updateProduct(id, price);
    }
}
