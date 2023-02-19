package models;

public class Product {
    int id;
    String name;
    String artnumber;
    int quantity;
    double price;
    String imagepath;
    public Product() {}
    public Product(String name, String artnumber, int quantity, double price, String imagepath) {
        this.name = name;
        this.artnumber = artnumber;
        this.quantity = quantity;
        this.price = price;
        this.imagepath = imagepath;
    }
    public Product(int id, String name, String artnumber, int quantity, double price, String imagepath) {
        this.id = id;
        this.name = name;
        this.artnumber = artnumber;
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
    public String getArtnumber() {
        return artnumber;
    }
    public void setArtnumber(String artnumber) {
        this.artnumber = artnumber;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImagepath() {
        return imagepath;
    }
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
    
    
}
