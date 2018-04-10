package com.example.prabhat.raj.AppActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabhat.raj.R;
import com.example.prabhat.raj.UtilsApp.GPSTracker;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import static com.google.android.gms.maps.CameraUpdateFactory.newLatLng;

public class MapActivity extends FragmentActivity implements
        OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private Location l;
    private LocationManager locationManager;
    private AlertDialog.Builder b;
    private AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_map);


        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager ().findFragmentById (R.id.map);
        mapFragment.getMapAsync (this);

        locationManager = (LocationManager) getSystemService (Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission (this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission
                        (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        locationManager.requestLocationUpdates (LocationManager.GPS_PROVIDER, 1,
                1, this);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;


        GPSTracker gpsTracker = new GPSTracker (this);
        LatLng originLatLng = new LatLng(gpsTracker.getLatitude(), gpsTracker.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mMap.addMarker(markerOptions.position(originLatLng).title("You are at "));
        CameraUpdate cameraUpdateCenter = CameraUpdateFactory.newLatLng(originLatLng);
        CameraUpdate cameraUpdateZoom = CameraUpdateFactory.zoomTo(12);
        mMap.moveCamera(cameraUpdateCenter);
        mMap.animateCamera(cameraUpdateZoom);
        mMap.setMyLocationEnabled (true);
        mMap.getUiSettings ().setMyLocationButtonEnabled (true);
        mMap.getUiSettings ().setMapToolbarEnabled (true);
        mMap.getUiSettings ().setZoomControlsEnabled (true);

/*
        LatLng sydney = new LatLng (28.6123860, 77.3900230);
        mMap.addMarker (new MarkerOptions ().position (sydney).title ("Marker at Fluper Noida"));
        mMap.moveCamera (newLatLng (sydney));*/

    }


    @Override
    public void onLocationChanged(Location location) {
     /*   Toast.makeText (this, "In ONLocatioonChanged", Toast.LENGTH_SHORT).show ();
     //   mMap.clear();
        Log.d ("A","onLocationChanged");
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        Geocoder geocoder = new Geocoder (getApplicationContext());
        try {
            List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
            String locality = addressList.get(0).getLocality();
            String countryName = addressList.get(0).getCountryName();
            String address = locality + " , " + countryName;
            mMap.addMarker(new MarkerOptions().position(latLng).title(address));
            mMap.moveCamera(newLatLng(latLng));
            mMap.moveCamera(CameraUpdateFactory.zoomTo(5));
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


}

