package tech.bts.onlineshop.model;

public class Discount {

    private String id;
    private String name;
    private double amount;
    private boolean percentage;

    public Discount (String id, String name, double amount, boolean percentage){
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.percentage = percentage;
    }

    // When you only have getters, we call this an immutable class

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPercentage() {
        return percentage;
    }
}