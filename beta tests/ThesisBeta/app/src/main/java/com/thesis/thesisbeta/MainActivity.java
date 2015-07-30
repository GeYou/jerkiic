package com.thesis.thesisbeta;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {

    static final LatLng IvanPos = new LatLng(40, -79);
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createMap();
        addMarker();
    }

    private void createMap() {
        try {
            if(null == googleMap){
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.map)).getMap();
                if(null == googleMap) {
                    Toast.makeText(getApplicationContext(),
                            "Error creating map", Toast.LENGTH_SHORT).show();
                }
                /*else {
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    googleMap.setMyLocationEnabled(true);
                    googleMap.setTrafficEnabled(true);
                    googleMap.setIndoorEnabled(true);
                    googleMap.setBuildingsEnabled(true);
                    googleMap.getUiSettings().setZoomControlsEnabled(true);

                    Marker marker = googleMap.addMarker(new MarkerOptions().position(IvanPos).title("Hello"));


                    LatLng latlng = new LatLng(10.351993898, 123.913227877);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));

            // Zoom in the Google Map
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(8));
            googleMap.addMarker(new MarkerOptions()
                            .position(latlng)
                            .title("Marker")
                            .draggable(true)
            );
                }*/
            }
        } catch (NullPointerException exception){
            Log.e("mapApp", exception.toString());
        }
    }
    private void addMarker() {

        /** Make sure that the map has been initialised **/
        if (null != googleMap) {


            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.setMyLocationEnabled(true);
            googleMap.setTrafficEnabled(true);
            googleMap.setIndoorEnabled(true);
            googleMap.setBuildingsEnabled(true);
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            Marker marker = googleMap.addMarker(new MarkerOptions().position(IvanPos).title("Hello"));
        }
    }

}
