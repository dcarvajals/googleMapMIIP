package com.example.googlemapmiip;

import com.google.android.gms.maps.model.LatLng;

public class Facultad {

    private String nombre_facultad = "";
    private String direccion = "";
    private String decano = "";
    private String email_facultad = "";
    private String logo = "";
    private LatLng location =  null;

    public Facultad() { }

    public String getNombre_facultad() {
        return nombre_facultad;
    }

    public void setNombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        this.decano = decano;
    }

    public String getEmail_facultad() {
        return email_facultad;
    }

    public void setEmail_facultad(String email_facultad) {
        this.email_facultad = email_facultad;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }
}
