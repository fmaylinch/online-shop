package tech.bts.onlineshop.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {

        CartItem other = (CartItem) obj; // You need to specify the type of obj

        // When you call a.equals(b), `a` will be `this`, and `b` will be `other`:
        // You return true if `a` and `b` are equal. Here you decide what it means to be equal.
        return this.getProductId() == other.productId
                && this.getQuantity() == other.getQuantity();
    }
}
