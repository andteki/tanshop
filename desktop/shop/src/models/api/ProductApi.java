package models.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.ShopProperti;
import models.tools.Converter;
import models.Product;

public class ProductApi {
    ShopProperti pro;
    String host;
    HttpClient http;
    public ProductApi() {
        this.pro = new ShopProperti();
        this.host = this.pro.getProperty("restapi.host");
        http = new HttpClient();
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
        String res = this.http.get(urlStr);
        return res;
    }
    public void addProduct(Product product) {
        String endpoint = "products";
        String urlStr = this.host + endpoint;
        HttpClient http = new HttpClient();

        String jsonProduct = Converter.objectToJsonText(product);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("Authorization", "Bearer 1|D7kJN1v1CwIpBuZcSwHQDAnkvkWrvie4S9heKPf4");

        String res = http.post(urlStr, jsonProduct, headers);
        System.out.println(http.getResponseCode());
        System.out.println(res);
    }
    public void delProduct(int id) {
        System.out.println(id);
        String endpoint = "products";
        String urlStr = this.host + endpoint + "/" + id;

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("Authorization", "Bearer 1|D7kJN1v1CwIpBuZcSwHQDAnkvkWrvie4S9heKPf4");        
        
        this.http.delete(urlStr, headers);        
    }
    public void modifyProduct(Product product) {
        String endpoint = "products";
        String urlStr = this.host + endpoint + "/" + product.getId();

        String jsonProduct = Converter.objectToJsonText(product);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("Authorization", "Bearer 1|D7kJN1v1CwIpBuZcSwHQDAnkvkWrvie4S9heKPf4");

        String res = this.http.put(urlStr, jsonProduct, headers);
        System.out.println(http.getResponseCode());
        System.out.println(res);        
    }
}
