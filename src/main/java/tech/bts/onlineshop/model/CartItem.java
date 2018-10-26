package tech.bts.onlineshop.model;

/**
 * One product and the quantity to purchase.
 */
public class CartItem {

    private long productId;
    private int quantity;

    public CartItem(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
