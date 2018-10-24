package tech.bts.onlineshop.business;

import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.Product;

public class ProductService {

    private ProductDatabase productDatabase;


    public ProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }


    /** Adds a product and returns the id for that product */
    public long createProduct(Product product) {
        return this.productDatabase.add(product);
    }

    public Product getProductById(long productId) {
        return productDatabase.get(productId);
    }

    public void addProductStock(long productId, int quantity) {

        Product product = this.productDatabase.get(productId);
        int total = product.getQuantity() + quantity;
        product.setQuantity(total);
    }
}
