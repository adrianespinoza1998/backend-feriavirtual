package com.feriavirtual.apirest.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Contrato {

	private int idContrato;
	private int firmado;
	private int idUsuario;
	private String codigo;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date fechaIni;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date fechaFin;

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Contrato{" +
				"idContrato=" + idContrato +
				", firmado=" + firmado +
				", idUsuario=" + idUsuario +
				", codigo='" + codigo + '\'' +
				", fechaIni=" + fechaIni +
				", fechaFin=" + fechaFin +
				'}';
	}
}
