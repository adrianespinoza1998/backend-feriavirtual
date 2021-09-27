package com.feriavirtual.apirest.models;

public class TipoVenta {
	
    private int idTipoVenta;
    private int descripcion;
    
    public TipoVenta() {
    	
    }

	public int getIdTipoVenta() {
		return idTipoVenta;
	}

	public void setIdTipoVenta(int idTipoVenta) {
		this.idTipoVenta = idTipoVenta;
	}

	public int getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}

}
