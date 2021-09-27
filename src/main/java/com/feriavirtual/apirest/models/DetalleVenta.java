package com.feriavirtual.apirest.models;

public class DetalleVenta {

	private int idDetalleVenta;
    private int cantidadDetalleVenta;
    private int precioDetalleVenta;
    private int idSolicitudVenta;
    private int idProducto;
    
    public DetalleVenta() {
    	
    }
    
    public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public int getCantidadDetalleVenta() {
		return cantidadDetalleVenta;
	}

	public void setCantidadDetalleVenta(int cantidadDetalleVenta) {
		this.cantidadDetalleVenta = cantidadDetalleVenta;
	}

	public int getPrecioDetalleVenta() {
		return precioDetalleVenta;
	}

	public void setPrecioDetalleVenta(int precioDetalleVenta) {
		this.precioDetalleVenta = precioDetalleVenta;
	}

	public int getIdSolicitudVenta() {
		return idSolicitudVenta;
	}

	public void setIdSolicitudVenta(int idSolicitudVenta) {
		this.idSolicitudVenta = idSolicitudVenta;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
}
