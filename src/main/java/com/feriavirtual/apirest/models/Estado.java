package com.feriavirtual.apirest.models;

public class Estado {
    
	private int idEstado;
    private String descripcion;
    
    public Estado(){
    	
    }

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
