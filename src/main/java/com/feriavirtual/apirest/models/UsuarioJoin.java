package com.feriavirtual.apirest.models;

public class UsuarioJoin {

    private int idUsuario;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String dni;
    private String direccion;
    private String codPostal;
    private String correo;
    private String pais;
    private String rol;
    private String estado;
    private int terminosCondiciones;

    public UsuarioJoin() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTerminosCondiciones() {
        return terminosCondiciones;
    }

    public void setTerminosCondiciones(int terminosCondiciones) {
        this.terminosCondiciones = terminosCondiciones;
    }

    @Override
    public String toString() {
        return "UsuarioJoin{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apPaterno='" + apPaterno + '\'' +
                ", apMaterno='" + apMaterno + '\'' +
                ", dni='" + dni + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codPostal='" + codPostal + '\'' +
                ", correo='" + correo + '\'' +
                ", pais='" + pais + '\'' +
                ", rol='" + rol + '\'' +
                ", estado='" + estado + '\'' +
                ", terminosCondiciones=" + terminosCondiciones +
                '}';
    }
}
