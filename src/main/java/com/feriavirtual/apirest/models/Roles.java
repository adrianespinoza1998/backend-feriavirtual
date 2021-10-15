package com.feriavirtual.apirest.models;

public class Roles {
	
    private int idRol;
    private String descripcion;
    
    public Roles() {
    	
    }

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Roles{" +
				"idRol=" + idRol +
				", descripcion='" + descripcion + '\'' +
				'}';
	}
}
