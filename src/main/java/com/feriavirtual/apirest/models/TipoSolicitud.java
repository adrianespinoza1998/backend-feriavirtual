package com.feriavirtual.apirest.models;

public class TipoSolicitud {
	
    private int idTipoSolicitud;
    private int descripcion;
    
    public TipoSolicitud() {
    	
    }

	public int getIdTipoSolicitud() {
		return idTipoSolicitud;
	}

	public void setIdTipoSolicitud(int idTipoSolicitud) {
		this.idTipoSolicitud = idTipoSolicitud;
	}

	public int getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoSolicitud{" +
				"idTipoSolicitud=" + idTipoSolicitud +
				", descripcion=" + descripcion +
				'}';
	}
}
