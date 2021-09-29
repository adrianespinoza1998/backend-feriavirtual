package com.feriavirtual.apirest.models;

public class Productos {

    private int idProducto;
    private String nombreProducto;
    private int medidaProducto;
    private int precioProducto;
    private int stockProducto;
    private int idRol;
    
    public Productos() {
    	
    }

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getMedidaProducto() {
		return medidaProducto;
	}

	public void setMedidaProducto(int medidaProducto) {
		this.medidaProducto = medidaProducto;
	}

	public int getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	@Override
	public String toString() {
		return "Productos [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", medidaProducto="
				+ medidaProducto + ", precioProducto=" + precioProducto + ", stockProducto=" + stockProducto
				+ ", idRol=" + idRol + "]";
	}
	
	
}
