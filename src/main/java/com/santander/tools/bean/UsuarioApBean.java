package com.santander.tools.bean;

/**
 * Clase que representa un usuario de una aplicación en específico
 * @author OMartinez, V1.1
 * @version 1.0, 14/08/2016
 */
public class UsuarioApBean {
    
    private long id;
    private String usuario;
    private String perfil;
    private String aplicacion;
    private String nombre;
    private String correo;
    private String estado;
    private boolean seEnviaCorreo;
    private String tipoUsuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isSeEnviaCorreo() {
        return seEnviaCorreo;
    }

    public void setSeEnviaCorreo(boolean seEnviaCorreo) {
        this.seEnviaCorreo = seEnviaCorreo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
}
