package com.feriavirtual.apirest.models;

public class DetalleVenta {

	private  int idDetalleVenta;
	private  int idProducto;
	private  int cantidad;
	private  int precio;

	public DetalleVenta() {
	}

	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "DetalleVenta{" +
				"idDetalleVenta=" + idDetalleVenta +
				", idProducto=" + idProducto +
				", cantidad=" + cantidad +
				", precio=" + precio +
				'}';
	}
}
