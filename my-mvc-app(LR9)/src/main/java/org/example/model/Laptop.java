package org.example.model;
public class Laptop {
    private String brand;
    private String model;
    private int year;
    private double price;
    private String processor;

    // Конструкторы, геттеры и сеттеры
    public Laptop() {}

    public Laptop(String brand, String model, int year, double price, String processor) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.processor = processor;
    }

    // Геттеры и сеттеры
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getProcessor() { return processor; }
    public void setProcessor(String processor) { this.processor = processor; }
}
