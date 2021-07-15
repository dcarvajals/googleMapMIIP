package com.example.googlemapmiip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback,
        GoogleMap.InfoWindowAdapter,
        GoogleMap.OnInfoWindowClickListener {

    GoogleMap  map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady( GoogleMap googleMap) {
        map = googleMap;

        // configuraciones del mapa
        // zoom del mapa
        map.getUiSettings().setZoomControlsEnabled(true);
        // mostramos la informacion (modal)
        map.setInfoWindowAdapter(MainActivity.this);

        ArrayList<Facultad> fcdatas = datosEmbebidos();

        for(Facultad facultad : fcdatas ){
            Marker mker =  map.addMarker(new MarkerOptions().position(facultad.getLocation())
                    .title("Datos de la facultad seleccionada"));
            mker.setTag(facultad);
        }
    }

    public ArrayList<Facultad>  datosEmbebidos () {
        //CAMPUS CENTRA UTEQ
        //FCI
        Facultad fci = new Facultad();
        //creamos un arraylist de facultades para tener las facultades en memoria
        ArrayList<Facultad>  datosFacultad = new ArrayList<Facultad>();
        fci.setNombre_facultad("Facultad Ciencias de la Ingenieria");
        fci.setDecano("Ing. Washington Alberto Chiriboga Casanova, M.Sc.");
        fci.setDireccion("Campus 'Ingeniero Manuel Agustín Haz Álvarez', Av. Quito km. 1 1/2 vía " +
                "a Santo Domingo de los Tsáchilas");
        fci.setEmail_facultad("facultadci@uteq.edu.ec");
        fci.setLogo("https://www.uteq.edu.ec/images/about/logo_fci.jpg");
        fci.setLocation(new LatLng(-1.0125772416600838, -79.47043092589146));
        datosFacultad.add(fci);

        //FCE
        Facultad fce = new Facultad();
        fce.setNombre_facultad("Facultad de Ciencias Empresariales");
        fce.setDecano("Ing. Mariela Susana Andrade Arias, PhD.");
        fce.setDireccion("Campus 'Ingeniero Manuel Agustín Haz Álvarez', Av. Quito km. 1 1/2 vía " +
                "a Santo Domingo de los Tsáchilas");
        fce.setEmail_facultad("facultadce@uteq.edu.ec");
        fce.setLogo("https://www.uteq.edu.ec/images/about/logo_fce.jpg");
        fce.setLocation(new LatLng(-1.0121740313099747, -79.47007644954464));
        datosFacultad.add(fce);

        //CAMPUS LA MARIA
        //FCA
        Facultad fca = new Facultad();
        fca.setNombre_facultad("Facultad de Ciencias Agropecuarias");
        fca.setDecano("Ing. Leonardo Gonzalo Matute, M.Sc.");
        fca.setDireccion("Campus 'La María', km 7 vía Quevedo-El Empalme");
        fca.setEmail_facultad("decanato_agropecuarias@uteq.edu.ec");
        fca.setLogo("https://www.uteq.edu.ec/images/about/logo_fcagrop.jpg");
        fca.setLocation(new LatLng(-1.0810259049531765, -79.50200330824408));
        datosFacultad.add(fca);

        //FCIP
        Facultad fcip = new Facultad();
        fcip.setNombre_facultad("Facultad de Ciencias de la Industria y Producción");
        fcip.setDecano("Ing. Sonnia Esther Barzola Miranda, M.Sc.");
        fcip.setDireccion("Campus 'La María', km 7 vía Quevedo-El Empalme");
        fcip.setEmail_facultad("fcip@uteq.edu.ec");
        fcip.setLogo("https://www.uteq.edu.ec/images/about/logo_fcip.jpg");
        fcip.setLocation(new LatLng(-1.0126243773616503, -79.47107994830553));
        datosFacultad.add(fcip);

        return datosFacultad;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View infoView = LayoutInflater.from(MainActivity.this).
                inflate(R.layout.datos_facultad, null);

        TextView tv_nombrefacultad = (TextView) infoView.findViewById(R.id.tv_nombrefacultad);
        TextView tv_nombredecano = (TextView) infoView.findViewById(R.id.tv_nombredecano);
        TextView tv_correofacultad = (TextView) infoView.findViewById(R.id.tv_correofacultad);
        TextView tv_direccionfacultad = (TextView) infoView.findViewById(R.id.tv_direccionfacultad);
        ImageView logo_facultad = (ImageView) infoView.findViewById(R.id.im_logofacultad);

        //obtener los datos de las facultades
        Facultad fc = (Facultad) marker.getTag();
        tv_nombrefacultad.setText(fc.getNombre_facultad());
        tv_nombredecano.setText(fc.getDecano());
        tv_correofacultad.setText(fc.getEmail_facultad());
        tv_direccionfacultad.setText(fc.getDireccion());

        //obtener la imagen de la facultad
        Picasso.get().load(fc.getLogo())
                .into(logo_facultad, new MarkerImage(marker));

        return infoView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public void onInfoWindowClick( Marker marker) {

    }
}