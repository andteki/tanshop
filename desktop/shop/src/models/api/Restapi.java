package models.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Pro;
import models.Product;

public class Restapi {
    Pro pro;
    String host;
    public Restapi() {
        this.pro = new Pro();
        this.host = this.pro.getProperty("restapi.host");
    }


    public ArrayList<Product> getProducts() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String text = getProductsAsString();
        Product[] productArray =  gson.fromJson(text, Product[].class);
        ArrayList<Product> productList = 
            new ArrayList<>(Arrays.asList(productArray));
        return productList;
    }
    private String getProductsAsString() {                        
        String endpoint = "products";
        String urlStr = host + endpoint;
        HttpClient http = new HttpClient();
        String res = http.get(urlStr);
        return res;
    }
    public void addProduct(String name, String artnumber, int quantity, double price, String imagepath) {
        String endpoint = "products";
        String urlStr = this.host + endpoint;
        HttpClient http = new HttpClient();

        Product productData = new Product(name, artnumber, quantity, price, imagepath);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String jsonData = gson.toJson(productData);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        String res = http.post(urlStr, jsonData, headers);
        System.out.println(http.getResponseCode());
        System.out.println(res);
    }
}
