package com.feriavirtual.apirest.models;

import java.math.BigInteger;

public class Pagos {

	private  int idPagos;
	private  int idSubastas;
	private  int monto;
	private BigInteger tarjeta;
	private  int idMoneda;

	public Pagos() {
	}

	public int getIdPagos() {
		return idPagos;
	}

	public void setIdPagos(int idPagos) {
		this.idPagos = idPagos;
	}

	public int getIdSubastas() {
		return idSubastas;
	}

	public void setIdSubastas(int idSubastas) {
		this.idSubastas = idSubastas;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public BigInteger getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(BigInteger tarjeta) {
		this.tarjeta = tarjeta;
	}

	public int getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}

	@Override
	public String toString() {
		return "Pagos{" +
				"idPagos=" + idPagos +
				", idSubastas=" + idSubastas +
				", monto=" + monto +
				", tarjeta=" + tarjeta +
				", idMoneda=" + idMoneda +
				'}';
	}
}
