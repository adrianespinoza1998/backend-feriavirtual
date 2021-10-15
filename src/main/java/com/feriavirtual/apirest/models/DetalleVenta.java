package com.feriavirtual.apirest.models;

public class DetalleVenta {

	private  int id_detalle_venta;
	private  int id_producto;
	private  int cantidad;
	private  int precio;

	public DetalleVenta() {
	}

	public int getId_detalle_venta() {
		return id_detalle_venta;
	}

	public void setId_detalle_venta(int id_detalle_venta) {
		this.id_detalle_venta = id_detalle_venta;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
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
				"id_detalle_venta=" + id_detalle_venta +
				", id_producto=" + id_producto +
				", cantidad=" + cantidad +
				", precio=" + precio +
				'}';
	}
}
