package edu.upc.dsa.models;

public class Product {

    private  String id;
    private  String name;
    private double price;
    private int sales;

    public Product(String id, String name, double price) { //constructor
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = 0;
    }
    public Product( ) {

    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int sales() {

        return sales;
    }

    // Incrementar el número de ventas del producto
    public void incrementSales(int quantity) {
        this.sales += quantity; // Aumentamos las ventas según la cantidad proporcionada
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales)    { this.sales = sales; }
}
