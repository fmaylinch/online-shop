package tech.bts.onlineshop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The items to be purchased.
 */
public class ShoppingCart {

    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public ShoppingCart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void add(CartItem item) {
        items.add(item);
    }
}
