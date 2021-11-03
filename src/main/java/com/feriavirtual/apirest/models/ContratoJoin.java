package com.feriavirtual.apirest.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ContratoJoin {

    private int idContrato;
    private int idUsuario;
    private String dni;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private int firmado;
    private String codigo;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaIni;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaFin;

    public ContratoJoin() {
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public int getFirmado() {
        return firmado;
    }

    public void setFirmado(int firmado) {
        this.firmado = firmado;
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
        return "ContratoJoin{" +
                "idContrato=" + idContrato +
                ", idUsuario=" + idUsuario +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apPaterno='" + apPaterno + '\'' +
                ", apMaterno='" + apMaterno + '\'' +
                ", firmado=" + firmado +
                ", codigo='" + codigo + '\'' +
                ", fechaIni=" + fechaIni +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
