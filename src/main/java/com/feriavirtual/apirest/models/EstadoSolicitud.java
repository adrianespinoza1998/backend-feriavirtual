package com.feriavirtual.apirest.models;

public class EstadoSolicitud {
	
    private int idEstadoSolicitud;
    private String descripcion;
    
    public EstadoSolicitud() {
    	
    }

	public int getIdEstadoSolicitud() {
		return idEstadoSolicitud;
	}

	public void setIdEstadoSolicitud(int idEstadoSolicitud) {
		this.idEstadoSolicitud = idEstadoSolicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
