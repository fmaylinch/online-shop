package tech.bts.onlineshop.business;

import org.junit.Assert;
import org.junit.Test;
import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.Product;

public class ProductServiceTest {

    @Test
    public void empty_catalog_has_no_products() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        int count = productService.getCount();
        Assert.assertEquals(0, count);
    }

    @Test
    public void add_product_to_catalog() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        Product product = new Product("pixel", "Google", 800);
        long pixelId = productService.createProduct(product);
        int count = productService.getCount();
        Assert.assertEquals(1, count);
        Product p = productService.getProductById(pixelId);
        Assert.assertEquals("pixel", p.getName());
    }

    @Test
    public void product_availability() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        Product product = new Product("pixel", "Google", 800);
        long pixelId = productService.createProduct(product);

        Assert.assertEquals(false, productService.checkProductAvailabiliy(pixelId, 500));

        productService.addProductStock(pixelId, 500);

        Assert.assertEquals(true, productService.checkProductAvailabiliy(pixelId, 500));
    }

    @Test
    public void product_available_quantity() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        Product product = new Product("pixel", "Google", 800);
        long pixelId = productService.createProduct(product);

        Assert.assertEquals(0, productService.getAvailableQuantity(pixelId, 50));

        productService.addProductStock(pixelId, 100);

        Assert.assertEquals(50, productService.getAvailableQuantity(pixelId, 50));
        Assert.assertEquals(100, productService.getAvailableQuantity(pixelId, 200));
    }

}
