package com.example.riyaz.googlemapsretrofit;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.riyaz.googlemapsretrofit.POJO.Example;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by Riyaz on 8/1/2017.
 */

public class DisplayLocActivity extends Fragment{

    String[] name = new String[20];
    String[] formatted_address = new String[20];
    RecyclerView recyclerView;
    LocationAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    double latitude =39.000089;
    double longitude = -76.863842;
    private int PROXIMITY_RADIUS = 10000;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1,container,false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        build_retrofit_and_get_response("bank");
    }

    private void build_retrofit_and_get_response(String type) {
        String url = "https://maps.googleapis.com/maps/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitMaps service = retrofit.create(RetrofitMaps.class);
        Call<Example> call = service.getNearbyPlaces(type, latitude + "," + longitude, PROXIMITY_RADIUS);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Response<Example> response, Retrofit retrofit) {

                try {

                    for (int i = 0; i < response.body().getResults().size(); i++){
                        formatted_address[i] = response.body().getResults().get(i).getformatted_address();
                    }

                    recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
                    adapter = new LocationAdapter(formatted_address);
                    recyclerView.setAdapter(adapter);
                    layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);


                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });

    }


}
