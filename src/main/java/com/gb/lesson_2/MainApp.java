package com.gb.lesson_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        ProductInMemoryRepository productInMemoryRepository = context.getBean("productRepository", ProductInMemoryRepository.class);
//        System.out.println(productInMemoryRepository.readProducts());
        ProductService productService = context.getBean("productService", ProductService.class);

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] cmd = sc.nextLine().split(" ");
            if (cmd[0].equals("/exit")) {
                break;
            }
            if (cmd[0].equals("/avg_price")) {
                System.out.println(productService.avrPrice());
            }
            if (cmd[0].equals("/count_products")) {
                System.out.println(productService.avrPrice());
            }
            if (cmd[0].equals("/read_product")) {
                if (cmd.length > 2) {
                    System.out.println("Неверное количество аргументов");
                }
                System.out.println(productService.readProduct(Integer.parseInt(cmd[1])));
            }
            if (cmd[0].equals("/read_products")) {
                System.out.println(productService.readProducts());
            }
            if (cmd[0].equals("/delete_product")) {
                if (cmd.length > 2) {
                    System.out.println("Неверное количество аргументов");
                }
                productService.deleteProduct(Integer.parseInt(cmd[1]));
            }
            if (cmd[0].equals("/create_product")) {
                if (cmd.length > 4) {
                    System.out.println("Неверное количество аргументов");
                }
                productService.createProduct(Integer.parseInt(cmd[1]),cmd[2],Double.parseDouble(cmd[3]));
            }
            if (cmd[0].equals("/update_price")) {
                if (cmd.length > 3) {
                    System.out.println("Неверное количество аргументов");
                }
                productService.updateProduct(Integer.parseInt(cmd[1]), Double.parseDouble(cmd[2]));
            }
        }
        context.close();
    }
}
