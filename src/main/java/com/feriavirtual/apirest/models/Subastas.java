package com.feriavirtual.apirest.models;

public class Subastas {
	
    private int idSubastas;
    private int idTipoVenta;
    private int idRol;
    private int idSolicitudVenta;
    
    public Subastas() {
    	
    }

	public int getIdSubastas() {
		return idSubastas;
	}

	public void setIdSubastas(int idSubastas) {
		this.idSubastas = idSubastas;
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

	public int getIdSolicitudVenta() {
		return idSolicitudVenta;
	}

	public void setIdSolicitudVenta(int idSolicitudVenta) {
		this.idSolicitudVenta = idSolicitudVenta;
	}
    
}
