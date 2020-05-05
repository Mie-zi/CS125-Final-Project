package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener {

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
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        //mMap.getCameraPosition();
        initiateMarkers(mMap);
        move(getIntent().getDoubleExtra("latitude", 0),
                getIntent().getDoubleExtra("longitude", 0));
    }

    private void initiateMarkers(GoogleMap mMap) {
        LatLng EngHall = new LatLng(40.110837, -88.226910);
        LatLng Grainger = new LatLng(40.112470, -88.226917);
        LatLng Licoln = new LatLng(40.106401, -88.228420);
        LatLng Foe = new LatLng(40.106060, -88.227076);
        LatLng Dkh = new LatLng(40.103847, -88.228422);
        mMap.addMarker(new MarkerOptions().position(EngHall).title("toilet in Enghall"));
        mMap.addMarker(new MarkerOptions().position(Grainger).title("toilet in Grainger"));
        mMap.addMarker(new MarkerOptions().position(Licoln).title("toilet in Lincoln"));
        mMap.addMarker(new MarkerOptions().position(Foe).title("toilet in foellinger"));
        mMap.addMarker(new MarkerOptions().position(Dkh).title("toilet in DavidKiley"));
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    private void move(double latitude, double longitude) {
        LatLng latLng = new LatLng(latitude, longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }


}
