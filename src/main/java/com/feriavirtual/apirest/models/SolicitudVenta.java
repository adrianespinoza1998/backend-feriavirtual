package com.feriavirtual.apirest.models;

public class SolicitudVenta {
	
    private int idSolicitudVenta;
    private int idTipoVenta;
    private int idRol;
    private int idTipoSolicitud;
    private int idEstadoSolicitud;
    
    public SolicitudVenta() {
    	
    }

	public int getIdSolicitudVenta() {
		return idSolicitudVenta;
	}

	public void setIdSolicitudVenta(int idSolicitudVenta) {
		this.idSolicitudVenta = idSolicitudVenta;
	}

	public int getIdTipoVenta() {
		return idTipoVenta;
	}

	public void setIdTipoVenta(int idTipoVenta) {
		this.idTipoVenta = idTipoVenta;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public int getIdTipoSolicitud() {
		return idTipoSolicitud;
	}

	public void setIdTipoSolicitud(int idTipoSolicitud) {
		this.idTipoSolicitud = idTipoSolicitud;
	}

	public int getIdEstadoSolicitud() {
		return idEstadoSolicitud;
	}

	public void setIdEstadoSolicitud(int idEstadoSolicitud) {
		this.idEstadoSolicitud = idEstadoSolicitud;
	}
    
}
