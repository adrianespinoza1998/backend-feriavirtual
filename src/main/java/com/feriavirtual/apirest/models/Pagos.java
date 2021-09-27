package com.feriavirtual.apirest.models;

public class Pagos {

    private int idPagos;
    private int idBanco;
    private int idRol;
    private int idSolicitudVenta;
    private int idMoneda;
    
    public Pagos() {
    	
    }

	public int getIdPagos() {
		return idPagos;
	}

	public void setIdPagos(int idPagos) {
		this.idPagos = idPagos;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
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

	public int getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}
}
