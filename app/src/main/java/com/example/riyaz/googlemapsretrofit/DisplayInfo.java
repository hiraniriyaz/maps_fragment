package com.example.riyaz.googlemapsretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Riyaz on 8/3/2017.
 */

public class DisplayInfo extends AppCompatActivity {
TextView tx_lat,tx_lng,tx_placename, tx_formatted_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info_layout);
        tx_lat = (TextView) findViewById(R.id.lat);
        tx_lng = (TextView) findViewById(R.id.lng);
        tx_placename = (TextView) findViewById(R.id.placename);
        tx_formatted_address = (TextView) findViewById(R.id.formatted_address);

        Intent i = getIntent();
        final Bundle extras = i.getExtras();
        tx_lat.setText("Latitude:"+(extras.getString("lat")));
        tx_lng.setText("Longitude:"+(extras.getString("long")));
        tx_placename.setText(("Bank Name:"+extras.getString("placename")));
        tx_formatted_address.setText(("Bank Address:"+extras.getString("formatted_address")));
    }
}
