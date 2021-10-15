package com.feriavirtual.apirest.models;

public class Moneda {

    private int idMoneda;
    private String descripcion;
    
    public Moneda() {
    	
    }

	public int getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Moneda{" +
				"idMoneda=" + idMoneda +
				", descripcion='" + descripcion + '\'' +
				'}';
	}
}
