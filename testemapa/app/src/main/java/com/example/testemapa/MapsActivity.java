package com.example.testemapa;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);





    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */



    @Override
    public void onMapReady(GoogleMap googleMap) {

        Intent intentRecebedora = getIntent();

        Bundle parametros = intentRecebedora.getExtras();

        double latitude = parametros.getDouble("chave_latitude");
        double longitude = parametros.getDouble("chave_longitude");

        String lugar = "Posição Selecionada";
        String descricao = "Posição indicada pelo Usuario";
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng posicao = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions()
                .position(posicao)
                .snippet(descricao)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pinpoint))
                .title(lugar));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicao, 15));


        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(posicao);
        circleOptions.fillColor(Color.argb(50,0,255,255));
        circleOptions.strokeWidth(10);
        circleOptions.strokeColor(Color.argb(50,47,79,79));
        //Medida em metros
        circleOptions.radius(5000.00);
        //Aplicando o circulo no mapa
        mMap.addCircle(circleOptions);
       /* //CLICK CURTO
        mMap.setOnMapClickListener((latLng) -> {
            double lat, longi;
            longi = latLng.longitude;
            lat = latLng.longitude;

            Toast.makeText(MapsActivity.this,
                    "Click Curto - Lat" + lat + "Long" + longi, Toast.LENGTH_SHORT).show();

            mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title("Click Curto")
                    .snippet("Descricao Click Curto")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.bus)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
        });

        //CLICK LONGO
        mMap.setOnMapLongClickListener((latLng) -> {
            double lat, longi;
            longi = latLng.longitude;
            lat = latLng.latitude;

            Toast.makeText(MapsActivity.this, "Click Longo - Lat" + latitude + "Lon: " + longitude,
                    Toast.LENGTH_LONG).show();
            mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title("Click Longo")
                    .snippet("Descricao Click Longo")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.car))
            );
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
        });
*/
    }
}