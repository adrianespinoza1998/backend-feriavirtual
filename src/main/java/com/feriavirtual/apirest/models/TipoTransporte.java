package com.feriavirtual.apirest.models;

public class TipoTransporte {
    
	private int idTipoTransporte;
	private String descripcion;
	
	public TipoTransporte() {
		
	}

	public int getIdTipoTransporte() {
		return idTipoTransporte;
	}

	public void setIdTipoTransporte(int idTipoTransporte) {
		this.idTipoTransporte = idTipoTransporte;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoTransporte{" +
				"idTipoTransporte=" + idTipoTransporte +
				", descripcion=" + descripcion +
				'}';
	}
}
