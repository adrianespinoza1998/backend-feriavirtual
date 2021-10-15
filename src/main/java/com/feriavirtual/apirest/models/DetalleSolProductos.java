package com.feriavirtual.apirest.models;

public class DetalleSolProductos {

    private int idDetalleSolProductos;
    private int idProducto;
    private int idSolicitudProductos;
    private int cantidad;

    public DetalleSolProductos() {
    }

    public int getIdDetalleSolProductos() {
        return idDetalleSolProductos;
    }

    public void setIdDetalleSolProductos(int idDetalleSolProductos) {
        this.idDetalleSolProductos = idDetalleSolProductos;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdSolicitudProductos() {
        return idSolicitudProductos;
    }

    public void setIdSolicitudProductos(int idSolicitudProductos) {
        this.idSolicitudProductos = idSolicitudProductos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleSolProductos{" +
                "idDetalleSolProductos=" + idDetalleSolProductos +
                ", idProducto=" + idProducto +
                ", idSolicitudProductos=" + idSolicitudProductos +
                ", cantidad=" + cantidad +
                '}';
    }
}
