package com.gb.lesson_2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Primary
public class ProductInMemoryRepository {
    private List<Product> products;

    public List<Product> readProducts() {
        return products;
    }

    public Product readProduct(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void createProduct(int id, String title, double price) {
        products.add(new Product(id, title, price));
        System.out.printf("Добавлен продукт: [%d %s %.2f]", id, title, price);
    }

    public void deleteProduct(int id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product nextProduct = iterator.next();
            if (nextProduct.getId() == id) {
                iterator.remove();
                System.out.println("удален продукт" + nextProduct.getTitle() + "с Id" + nextProduct.getId());
            }
        }
    }
    public void updateProduct(int id, double price) {
        for (Product product: products) {
            if (product.getId() == id) {
                product.setPrice(price);
                System.out.println("Изменена цена продукта на " + price + ", для продуктас ID" + product.getId());
            }
        }
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Tomato", 155.20));
        products.add(new Product(2, "Potato", 25.20));
        products.add(new Product(3, "Cheese", 136.00));
        products.add(new Product(4, "Milk", 96.50));
        products.add(new Product(5, "Butter", 100.00));

    }
}
