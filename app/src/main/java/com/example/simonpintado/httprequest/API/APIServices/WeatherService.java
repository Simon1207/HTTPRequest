package com.example.simonpintado.httprequest.API.APIServices;

import com.example.simonpintado.httprequest.Models.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Simon Pintado on 11/05/2017.
 */

public interface WeatherService {
    //El enlace es un ejemplo generado por la pagina de un JSON el JSON puede ser cualquier otro, appid es el token generado por la cuenta.
   // http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=3368f98a87f23c69ceabdfd693927443

    //ELEMENTOS CREADOS CON LA LIBRERIA RETROFIT para el tratamiento de JSON
    @GET("weather")
    Call<City> getCity(@Query("q") String city, @Query("appid") String key);

   @GET("weather")
    Call<City> getCity(@Query("q") String city, @Query("appid") String key, @Query("units") String value);
}
