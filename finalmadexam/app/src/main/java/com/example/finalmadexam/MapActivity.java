package com.example.finalmadexam;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * STEP 5 (cont.) — Map Activity.
 * Shows a Google Map pinned to the selected heritage site.
 * STEP 4: Camera button lets user capture a photo of the site.
 *
 * Renamed from MainActivity (com.fam.favlocation) → MapActivity (com.example.finalmadexam).
 */
public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int REQUEST_CAMERA_PERMISSION = 100;
    private static final int REQUEST_IMAGE_CAPTURE     = 101;

    private static final LatLngBounds CAVITE_BOUNDS = new LatLngBounds(
            new LatLng(14.0800, 120.6500),
            new LatLng(14.6000, 121.1000)
    );

    private static final LatLng CAVITE_CENTER = new LatLng(14.2456, 120.8789);

    private static float hueForCategory(String category) {
        switch (category) {
            case "Battle Sites":                  return BitmapDescriptorFactory.HUE_RED;
            case "Natural & Revolutionary Sites": return BitmapDescriptorFactory.HUE_ORANGE;
            case "Revolutionary Sites":           return BitmapDescriptorFactory.HUE_YELLOW;
            case "Churches & Parishes":           return BitmapDescriptorFactory.HUE_AZURE;
            case "Heroes & Markers":              return BitmapDescriptorFactory.HUE_GREEN;
            case "Historic Structures":           return BitmapDescriptorFactory.HUE_VIOLET;
            default:                              return BitmapDescriptorFactory.HUE_ROSE;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        String label = intent.getStringExtra("label");
        String desc  = intent.getStringExtra("desc");
        if (label == null) label = "Cavite Heritage Map";
        if (desc  == null) desc  = "Cavite Cultural Heritage Sites";

        ((TextView)      findViewById(R.id.tv_map_title)).setText(label);
        ((TextView)      findViewById(R.id.tv_map_desc)).setText(desc);

        // Back button
        ((LinearLayout) findViewById(R.id.btn_back_map)).setOnClickListener(v -> {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        // Camera button (STEP 4)
        ((LinearLayout) findViewById(R.id.btn_camera)).setOnClickListener(v -> openCamera());

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.id_map);
        if (mapFragment != null) mapFragment.getMapAsync(this);
    }

    // ── Camera (STEP 4) ──────────────────────────────────────────────────────

    private void openCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        } else {
            launchCamera();
        }
    }

    private void launchCamera() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture, REQUEST_IMAGE_CAPTURE);
        } else {
            Toast.makeText(this, "No camera app found.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA_PERMISSION
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            launchCamera();
        } else {
            Toast.makeText(this, "Camera permission required.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Camera closes; user is returned to the map automatically.
    }

    // ── Map ──────────────────────────────────────────────────────────────────

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Intent intent   = getIntent();
        double lat      = intent.getDoubleExtra("lat",  CAVITE_CENTER.latitude);
        double lng      = intent.getDoubleExtra("lng",  CAVITE_CENTER.longitude);
        float  zoom     = intent.getFloatExtra("zoom",  15f);
        String label    = intent.getStringExtra("label");
        String category = intent.getStringExtra("category");
        int drawableRes = intent.getIntExtra("drawableRes", -1);

        if (label    == null) label    = "Heritage Site";
        if (category == null) category = "";

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        googleMap.setLatLngBoundsForCameraTarget(CAVITE_BOUNDS);
        googleMap.setMinZoomPreference(10f);
        googleMap.setMaxZoomPreference(20f);

        googleMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));

        LatLng pos = new LatLng(lat, lng);
        Marker marker = googleMap.addMarker(new MarkerOptions()
                .position(pos)
                .title(label)
                .icon(BitmapDescriptorFactory.defaultMarker(hueForCategory(category))));

        if (marker != null && drawableRes != -1) {
            marker.setTag(drawableRes);
        }

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(
                new CameraPosition.Builder()
                        .target(pos)
                        .zoom(zoom)
                        .build()
        ));
    }
}