package com.feriavirtual.apirest.models;

public class Ciudad {

    private int idCiudad;
    private String descripcion;
    private int idPais;

    public Ciudad() {

    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "idCiudad=" + idCiudad +
                ", descripcion='" + descripcion + '\'' +
                ", idPais=" + idPais +
                '}';
    }
}
