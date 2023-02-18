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
    public void addProduct(Product product) {
        String endpoint = "products";
        String urlStr = this.host + endpoint;
        HttpClient http = new HttpClient();

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String jsonProduct = gson.toJson(product);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("Authorization", "Bearer 1|D7kJN1v1CwIpBuZcSwHQDAnkvkWrvie4S9heKPf4");

        String res = http.post(urlStr, jsonProduct, headers);
        System.out.println(http.getResponseCode());
        System.out.println(res);
    }
}
