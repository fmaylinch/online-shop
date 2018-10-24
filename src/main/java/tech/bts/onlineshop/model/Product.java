package tech.bts.onlineshop.model;

public class Product {

    private long id;
    private String name;
    private String brand;
    private double price;
    private int quantity;

    public final static long NOT_SPECIFIED = -1;

    public Product(String name, String brand, double price) {
        this.id = NOT_SPECIFIED;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.price + "€";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return this.quantity > 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
