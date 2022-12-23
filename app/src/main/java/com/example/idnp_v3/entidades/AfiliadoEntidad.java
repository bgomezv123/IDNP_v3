package com.example.idnp_v3.entidades;

public class AfiliadoEntidad {
    private int id;
    private String username;
    private String afiContra;
    private String nombre;
    private String prop;
    private String lat;
    private String lon;
    private String direcion;
    private String web;

    public AfiliadoEntidad(int id, String username, String afiContra, String nombre, String prop, String lat, String lon, String direcion, String web) {
        this.id = id;
        this.username = username;
        this.afiContra = afiContra;
        this.nombre = nombre;
        this.prop = prop;
        this.lat = lat;
        this.lon = lon;
        this.direcion = direcion;
        this.web = web;
    }

    public AfiliadoEntidad(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAfiContra() {
        return afiContra;
    }

    public void setAfiContra(String afiContra) {
        this.afiContra = afiContra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
