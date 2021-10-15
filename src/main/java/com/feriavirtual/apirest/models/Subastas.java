package com.feriavirtual.apirest.models;

public class Subastas {

	private  int idSubastas;
	private  int idUsuario;
	private  int idSolicitudProductos;

	public Subastas() {
	}

	public int getIdSubastas() {
		return idSubastas;
	}

	public void setIdSubastas(int idSubastas) {
		this.idSubastas = idSubastas;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdSolicitudProductos() {
		return idSolicitudProductos;
	}

	public void setIdSolicitudProductos(int idSolicitudProductos) {
		this.idSolicitudProductos = idSolicitudProductos;
	}

	@Override
	public String toString() {
		return "Subastas{" +
				"idSubastas=" + idSubastas +
				", idUsuario=" + idUsuario +
				", idSolicitudProductos=" + idSolicitudProductos +
				'}';
	}
}
