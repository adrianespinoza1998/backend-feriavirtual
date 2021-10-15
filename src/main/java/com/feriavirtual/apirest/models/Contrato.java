package com.feriavirtual.apirest.models;

public class Contrato {

	private int idContrato;
	private int firmado;
	private int idUsuario;

	public Contrato() {
	}

	public int getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public int getFirmado() {
		return firmado;
	}

	public void setFirmado(int firmado) {
		this.firmado = firmado;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Contrato{" +
				"idContrato=" + idContrato +
				", firmado=" + firmado +
				", idUsuario=" + idUsuario +
				'}';
	}
}
