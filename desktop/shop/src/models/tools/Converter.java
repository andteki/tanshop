package models.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Converter {

    public static String objectToJsonText(Object object) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String jsonProduct = gson.toJson(object);
        return jsonProduct;
    }
}
