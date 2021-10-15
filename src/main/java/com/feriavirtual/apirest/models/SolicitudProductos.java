package com.feriavirtual.apirest.models;

public class SolicitudProductos {

    private  int idSolicitudProductos;
    private  int idUsuario;
    private  int idTipoSolicitud;
    private  int idEstadoSolicitud;

    public SolicitudProductos() {
    }

    public int getIdSolicitudProductos() {
        return idSolicitudProductos;
    }

    public void setIdSolicitudProductos(int idSolicitudProductos) {
        this.idSolicitudProductos = idSolicitudProductos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(int idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public int getIdEstadoSolicitud() {
        return idEstadoSolicitud;
    }

    public void setIdEstadoSolicitud(int idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }

    @Override
    public String toString() {
        return "SolicitudProductos{" +
                "idSolicitudProductos=" + idSolicitudProductos +
                ", idUsuario=" + idUsuario +
                ", idTipoSolicitud=" + idTipoSolicitud +
                ", idEstadoSolicitud=" + idEstadoSolicitud +
                '}';
    }
}
