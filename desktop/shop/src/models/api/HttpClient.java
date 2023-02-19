package models.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HttpClient {
    int responseCode;
    public HttpClient() {
    }
    public String get(String urlStr) {
        String result;
        try {
            result = tryGet(urlStr);
        } catch (IOException e) {
            String msg = "Hiba! A GET kérés sikertelen!";
            System.err.println(msg);
            result = msg;
        }
        return result;
    }
    public String tryGet(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();
        this.responseCode = http.getResponseCode();
        InputStream inputStream = http.getInputStream();
        String text = convertInputStreamToString(inputStream);        
        return text;
    }
    public String post(String url, String data, HashMap<String, String> headers) {
        String result;
        try {
            result = tryPost(url, data, headers);
        } catch (IOException e) {
            String msg = "Hiba! A REST API elérés sikertelen!";
            System.err.println(msg);
            result = msg;
        }
        return result;
    }
    public String tryPost(String urlStr, String data, HashMap<String, String> headers) 
            throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("POST");
        
        for( Map.Entry<String, String> entry : headers.entrySet()) {
            http.setRequestProperty(entry.getKey(), entry.getValue());
        }
        
        http.setDoOutput(true);
        byte[] dataArray = data.getBytes();
        OutputStream outputStream = http.getOutputStream();
        outputStream.write(dataArray);
        outputStream.close();
        
        this.responseCode = http.getResponseCode();
        InputStream inputStream = http.getInputStream();
        String text = convertInputStreamToString(inputStream);
        return text;
    }
    public String delete(String urlStr, HashMap<String, String> headers) {
        String result = "";
        try {
            result = tryDelete(urlStr, headers);
        } catch (IOException e) {
            System.err.println("Hiba! A törlés a REST API-in nem sikerült");
        }
        return result;
    }
    private String tryDelete(String urlStr, HashMap<String, String> headers) 
            throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("DELETE");
        
        for( Map.Entry<String, String> entry : headers.entrySet()) {
            http.setRequestProperty(entry.getKey(), entry.getValue());
        }
        
        http.setDoOutput(true);
                
        this.responseCode = http.getResponseCode();
        InputStream inputStream = http.getInputStream();
        String text = convertInputStreamToString(inputStream);
        return text;
    }

    public String put(String urlStr, String data, HashMap<String, String> headers) {
        String result = "";
        try {
            result = tryPut(urlStr, data, headers);
        } catch (IOException e) {
            System.err.println("Hiba! Az adatok frissítése az API-n sikertelen!");
        }
        return result;
    }
    private String tryPut(String urlStr, String data, HashMap<String, String> headers) 
            throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("PUT");
        
        for( Map.Entry<String, String> entry : headers.entrySet()) {
            http.setRequestProperty(entry.getKey(), entry.getValue());
        }
        http.setDoOutput(true);
        byte[] dataArray = data.getBytes();
        OutputStream outputStream = http.getOutputStream();
        outputStream.write(dataArray);
        outputStream.close();
        
        this.responseCode = http.getResponseCode();
        InputStream inputStream = http.getInputStream();
        String text = convertInputStreamToString(inputStream);
        return text;
    }
    private String convertInputStreamToString(InputStream inputStream) {
        String text;
        try {
            text = this.tryConvertInputStreamToString(inputStream);
        } catch (UnsupportedEncodingException e) {
            String msg = "Hiba! Nem támogatott kódolás!";
            System.err.println(msg);
            text = msg;
        }
        return text;
    }
    private String tryConvertInputStreamToString(InputStream inputStream) 
            throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        final Reader reader = new InputStreamReader(inputStream, "UTF-8");
        Scanner scanner = new Scanner(reader);
        while(scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        scanner.close();
        return stringBuilder.toString();
    }

    public int getResponseCode() {
        return responseCode;
    }
    
}
