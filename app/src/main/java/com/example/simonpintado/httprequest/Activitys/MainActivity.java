package com.example.simonpintado.httprequest.Activitys;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simonpintado.httprequest.API.API;
import com.example.simonpintado.httprequest.API.APIServices.WeatherService;
import com.example.simonpintado.httprequest.Models.City;
import com.example.simonpintado.httprequest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
public TextView txtID,txtName,txtCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtID=(TextView)findViewById(R.id.txtID);
        txtName=(TextView)findViewById(R.id.txtName);
        txtCountry=(TextView)findViewById(R.id.txtCountry);



        //servicio por medio de interface
        WeatherService service= API.getApi().create(WeatherService.class);

        //llamada de servicio
        Call<City> cityCall =service.getCity("Seville,ES",API.APPKEY,"metric");
        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                City city=response.body(); //body devuelve un objeto de tipo CITY parseado con gson
                int id=city.getId();
                String sid= Integer.toString(id);
                String name=city.getName();
                String country=city.getCountry();

                txtID.setText(sid);
                txtName.setText(name);
                txtCountry.setText(country);


            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
            }
        });

    }//onCreate


}

