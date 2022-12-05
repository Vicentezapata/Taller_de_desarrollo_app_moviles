package com.example.gpsaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.gpsaplication.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.CameraPosition

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // GENERAMOS UNA LOCALIZACION
        val santiago = LatLng(-33.459229,-70.645348)
        val ciisaAlameda = LatLng(-33.44702742381741, -70.66637765304397)
        val ciisaRepublica = LatLng(-33.44859031882275, -70.66797960649937)

        //AGREGAMOS UN MARCADOR EN EL MAPA
        mMap.addMarker(MarkerOptions().position(ciisaAlameda).title("CIISA Alameda"))
        mMap.addMarker(MarkerOptions().position(ciisaRepublica).title("CIISA Republica"))
        //POSICIONAMOS LA CAMARA EN LA LOCALIZACION
        // Mueve la cámara instantáneamente a Santiago con un zoom de 15.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(santiago,15f))
        // Construye una CameraPosition centrada en Ciisa Republica y anima la cámara a esa posición.
        val cameraPosition = CameraPosition.Builder()
            .target(ciisaRepublica) // Establece el centro del mapa en Ciisa Republica
            .zoom(17f) // Establece el zoom
            .bearing(90f) // Establece la orientación de la cámara al este
            .tilt(30f) // Establece la inclinación de la cámara a 30 grados
            .build() // Crea una CameraPosition a partir del constructor
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }
}