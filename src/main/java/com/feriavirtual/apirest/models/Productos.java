package com.feriavirtual.apirest.models;

public class Productos {

	private  int idProducto;
	private  int kilos;
	private  int precio;
	private  int stock;
	private  int idUsuario;
	private  int idTipoProducto;
	private String img;

	public Productos() {
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getKilos() {
		return kilos;
	}

	public void setKilos(int kilos) {
		this.kilos = kilos;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Productos{" +
				"idProducto=" + idProducto +
				", kilos=" + kilos +
				", precio=" + precio +
				", stock=" + stock +
				", idUsuario=" + idUsuario +
				", idTipoProducto=" + idTipoProducto +
				", img='" + img + '\'' +
				'}';
	}
}
