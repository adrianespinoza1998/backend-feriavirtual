package com.feriavirtual.apirest.models;

public class Transportes {

    private int idTransporte;
	private int idTipoTransporte;
    private String marca;
    private int capacidad;
    private int peso;
    private int idUsuario;
    
    public Transportes() {
    }

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

	public int getIdTipoTransporte() {
		return idTipoTransporte;
	}

	public void setIdTipoTransporte(int idTipoTransporte) {
		this.idTipoTransporte = idTipoTransporte;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Transportes{" +
				"idTransporte=" + idTransporte +
				", idTipoTransporte=" + idTipoTransporte +
				", marca='" + marca + '\'' +
				", capacidad=" + capacidad +
				", peso=" + peso +
				", idUsuario=" + idUsuario +
				'}';
	}
}
