package com.feriavirtual.apirest.models;

public class Transportes {

    private int idTransporte;
    private int marca;
    private int capacidad;
    private int peso;
    private int idTipoTransporte;
    private int idRol;
    
    public Transportes() {
    	
    }

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

	public int getMarca() {
		return marca;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getIdTipoTransporte() {
		return idTipoTransporte;
	}

	public void setIdTipoTransporte(int idTipoTransporte) {
		this.idTipoTransporte = idTipoTransporte;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

}
