package com.example.simonpintado.httprequest.API;

import com.example.simonpintado.httprequest.API.Deserializer.MyDeserializer;
import com.example.simonpintado.httprequest.Models.City;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Simon Pintado on 12/05/2017.
 */

public class API {


    public static final String BASE_URL="http://api.openweathermap.org/data/2.5/";
    public  static final String APPKEY="3368f98a87f23c69ceabdfd693927443"; //KEY GENERADO CREANDO UNA CUENTA EN OPENWEATHERMAP.ORG
    private static Retrofit retrofit=null;

    public static Retrofit getApi(){
        if(retrofit==null){
            //si es nulo se crea, sino no entra en el if y lo devuelve

            GsonBuilder builder= new GsonBuilder();
            builder.registerTypeAdapter(City.class,new MyDeserializer());
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }
}
