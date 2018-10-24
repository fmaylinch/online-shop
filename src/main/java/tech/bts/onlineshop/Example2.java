package tech.bts.onlineshop;

import tech.bts.onlineshop.business.ProductService;
import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.Product;

public class Example2 {

    public static void main(String[] args) {

        ProductDatabase productDatabase = new ProductDatabase();

        ProductService productService = new ProductService(productDatabase);
        productService.createProduct(new Product("iPhone XS", "Apple", 1250));
        productService.createProduct(new Product("Pixel 3", "Google", 900));

        productService.addProductStock(1, 100);
        productService.addProductStock(1, 200);
        productService.addProductStock(2, 150);
    }
}
