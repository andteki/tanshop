package models;

public class Product {
    int id;
    String name;
    String itemnumber;
    int quantity;
    double price;
    String imagepath;
    public Product() {}
    public Product(String name, String itemnumber, int quantity, double price, String imagepath) {
        this.name = name;
        this.itemnumber = itemnumber;
        this.quantity = quantity;
        this.price = price;
        this.imagepath = imagepath;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getItemNumber() {
        return itemnumber;
    }
    public void setItemNumber(String itemnumber) {
        this.itemnumber = itemnumber;
    }
    public int getCount() {
        return this.quantity;
    }
    public void setCount(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
}
