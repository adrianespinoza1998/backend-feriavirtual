package com.feriavirtual.apirest.models;

public class Pais {

	private int idPais;
	
	private String descripcion;
	
	public Pais() {
		
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Pais{" +
				"idPais=" + idPais +
				", descripcion='" + descripcion + '\'' +
				'}';
	}
}
