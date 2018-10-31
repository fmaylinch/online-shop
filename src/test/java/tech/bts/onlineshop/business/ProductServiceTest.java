package tech.bts.onlineshop.business;

import org.junit.Assert;
import org.junit.Test;
import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.CartItem;
import tech.bts.onlineshop.model.Product;
import tech.bts.onlineshop.model.ShoppingCart;

import java.util.Arrays;

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
        long pixelId = productService.createProduct(new Product("pixel", "Google", 800));

        Assert.assertEquals(0, productService.getAvailableQuantity(pixelId, 50));

        productService.addProductStock(pixelId, 100);

        Assert.assertEquals(50, productService.getAvailableQuantity(pixelId, 50));
        Assert.assertEquals(100, productService.getAvailableQuantity(pixelId, 200));
    }

    @Test
    public void purchase_reduces_products_stock() {

        // 1- setup the necessary objects
        ProductService productService = new ProductService(new ProductDatabase());

        long penId = productService.createProduct(new Product("pen", "Pilot", 3), 100);
        long macId = productService.createProduct(new Product("macbook", "Apple", 1500), 50);
        long tvId = productService.createProduct(new Product("tv", "Sony", 400), 500);

        ShoppingCart cart = new ShoppingCart();
        cart.add(new CartItem(penId, 20));
        cart.add(new CartItem(tvId, 50));

        // 2- calling the method(s) we are testing
        productService.purchase(cart);

        // 3- check the expected result
        Assert.assertEquals(80, productService.getProductById(penId).getQuantity());
        Assert.assertEquals(450, productService.getProductById(tvId).getQuantity());
        Assert.assertEquals(50, productService.getProductById(macId).getQuantity());
    }

    @Test
    public void purchase_more_than_available() {

        // 1- setup the necessary objects
        ProductService productService = new ProductService(new ProductDatabase());
        long penId = productService.createProduct(new Product("pen", "Pilot", 3), 100);
        long macId = productService.createProduct(new Product("mac", "Apple", 1500), 50);
        ShoppingCart cart = new ShoppingCart();
        cart.add(new CartItem(penId, 200));
        cart.add(new CartItem(macId, 30));

        // 2- calling the method(s) we are testing
        ShoppingCart actualCart = productService.purchase(cart);

        // 3- check the expected result
        Assert.assertEquals(0, productService.getProductById(penId).getQuantity());
        Assert.assertEquals(20, productService.getProductById(macId).getQuantity());

        Assert.assertEquals(actualCart.getItems(), Arrays.asList(
                new CartItem(penId, 100),
                new CartItem(macId, 30)));
    }
}
