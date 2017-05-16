package com.example.simonpintado.httprequest.API.Deserializer;

import com.example.simonpintado.httprequest.Models.City;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Simon Pintado on 12/05/2017.
 */

public class MyDeserializer implements JsonDeserializer<City> {
//Deserializacion de JSON de acuerdo al enlace proporcionado del JSON de openweatermap.
    @Override
    public City deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        int id= json.getAsJsonObject().get("id").getAsInt();
        String name= json.getAsJsonObject().get("name").getAsString();
        String country=json.getAsJsonObject().get("sys").getAsJsonObject()
                .get("country").getAsString();
        City city=new City(id,name,country);
        return city;
    }
}
