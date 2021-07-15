package com.example.googlemapmiip;

import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Callback;

public class MarkerImage implements Callback {

    private Marker marker_actualizar;

    public MarkerImage(Marker marker_actualizar) {
        this.marker_actualizar = marker_actualizar;
    }

    @Override
    public void onSuccess() {
        if (marker_actualizar != null && marker_actualizar.isInfoWindowShown()) {
            marker_actualizar.hideInfoWindow();
            marker_actualizar.showInfoWindow();
        }
    }

    @Override
    public void onError(Exception e) {

    }
}
