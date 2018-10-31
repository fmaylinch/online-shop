package tech.bts.onlineshop.business;

import tech.bts.onlineshop.model.Discount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountService {

    private Map<String, Discount> discounts;

    public DiscountService() {
        this.discounts = new HashMap<>();
    }

    public double calculateFinalAmount(String discountId, double amount) {

        Discount discount = this.discounts.get(discountId);

        if (discount == null) {
            return amount;
        } else {
            if (discount.isPercentage()) {
                return amount * (1 - discount.getAmount() / 100);
            } else {
                return Math.max(amount - discount.getAmount(), 0);
            }
        }
    }

    public void add(Discount discount) {

        this.discounts.put(discount.getId(), discount);
    }
}
