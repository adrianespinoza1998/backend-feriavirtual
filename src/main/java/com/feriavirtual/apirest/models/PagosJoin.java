package com.feriavirtual.apirest.models;

import java.math.BigInteger;

public class PagosJoin {

    private String nombre;
    private String apPaterno;
    private int monto;
    private BigInteger tarjeta;
    private String sigla;

    public PagosJoin() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "PagosJoin{" +
                "nombre='" + nombre + '\'' +
                ", apPaterno='" + apPaterno + '\'' +
                ", monto=" + monto +
                ", tarjeta=" + tarjeta +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
