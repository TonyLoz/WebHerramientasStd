package com.santander.tools.bean;

import java.util.Date;

/**
 * Clase que representa el detalle de un usuario o regla en específico.
 * @author OMartinez, V1.1
 * @version 1.0, 14/08/2016
 */
public class UsuarioApDetalleBean {

    private long id;
    private String usuario;
    private String contrasena;
    private String contrasenaEncriptada;
    private String perfil;
    private int idAplicacion;
    private int unidadNegocio;
    private String unidadNegocioDescripcion;
    private String aplicacion;
    private int aplicacion_tiempoProcesoBajaUsuario;
    private boolean aplicacion_sePermiteModificarCondicion;
    private String nombre;
    private String correo;
    private String estado;
    private String tipoUsuario;
    private long idCliente;
    private String cliente;
    private String condicion;
    private boolean seEnvioCorreo;
    private boolean permisosATodosLosServicios;
    private String estadoCapacitacion;
    private Date fechaHoraAlta;
    private Date fechaHoraBaja;
    private Date fechaHoraMod;
    private int idUsuarioRegistra;
    private int idArmadora;
    private String armadora;
    private int idArrendadora;
    private String arrendadora;
    private int idOficina;

    public UsuarioApDetalleBean() {
    }

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
    
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasenaEncriptada() {
        return contrasenaEncriptada;
    }

    public void setContrasenaEncriptada(String contrasenaEncriptada) {
        this.contrasenaEncriptada = contrasenaEncriptada;
    }
    
    public int getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public int getAplicacion_tiempoProcesoBajaUsuario() {
        return aplicacion_tiempoProcesoBajaUsuario;
    }

    public void setAplicacion_tiempoProcesoBajaUsuario(int aplicacion_tiempoProcesoBajaUsuario) {
        this.aplicacion_tiempoProcesoBajaUsuario = aplicacion_tiempoProcesoBajaUsuario;
    }

    public boolean isAplicacion_sePermiteModificarCondicion() {
        return aplicacion_sePermiteModificarCondicion;
    }

    public void setAplicacion_sePermiteModificarCondicion(boolean aplicacion_sePermiteModificarCondicion) {
        this.aplicacion_sePermiteModificarCondicion = aplicacion_sePermiteModificarCondicion;
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

    public Date getFechaHoraAlta() {
        return fechaHoraAlta;
    }

    public void setFechaHoraAlta(Date fechaHoraAlta) {
        this.fechaHoraAlta = fechaHoraAlta;
    }

    public Date getFechaHoraBaja() {
        return fechaHoraBaja;
    }

    public void setFechaHoraBaja(Date fechaHoraBaja) {
        this.fechaHoraBaja = fechaHoraBaja;
    }
    
    public Date getFechaHoraMod() {
        return fechaHoraMod;
    }

    public void setFechaHoraMod(Date fechaHoraMod) {
        this.fechaHoraMod = fechaHoraMod;
    }
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public boolean isSeEnvioCorreo() {
        return seEnvioCorreo;
    }

    public void setSeEnvioCorreo(boolean seEnvioCorreo) {
        this.seEnvioCorreo = seEnvioCorreo;
    }

    public boolean isPermisosATodosLosServicios() {
        return permisosATodosLosServicios;
    }

    public void setPermisosATodosLosServicios(boolean permisosATodosLosServicios) {
        this.permisosATodosLosServicios = permisosATodosLosServicios;
    }

    public String getEstadoCapacitado() {
        return estadoCapacitacion;
    }

    public void setEstadoCapacitacion(String estadoCapacitacion) {
        this.estadoCapacitacion = estadoCapacitacion;
    }

    public int getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(int unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUnidadNegocioDescripcion() {
        return unidadNegocioDescripcion;
    }

    public void setUnidadNegocioDescripcion(String unidadNegocioDescripcion) {
        this.unidadNegocioDescripcion = unidadNegocioDescripcion;
    }

    public int getIdUsuarioRegistra() {
        return idUsuarioRegistra;
    }

    public void setIdUsuarioRegistra(int idUsuarioRegistra) {
        this.idUsuarioRegistra = idUsuarioRegistra;
    }

    public int getIdArmadora() {
        return idArmadora;
    }

    public void setIdArmadora(int idArmadora) {
        this.idArmadora = idArmadora;
    }

    public int getIdArrendadora() {
        return idArrendadora;
    }

    public void setIdArrendadora(int idArrendadora) {
        this.idArrendadora = idArrendadora;
    }

    public String getArmadora() {
        return armadora;
    }

    public void setArmadora(String armadora) {
        this.armadora = armadora;
    }

    public String getArrendadora() {
        return arrendadora;
    }
    
    public void setArrendadora(String arrendadora) {
        this.arrendadora = arrendadora;
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }
    
    
}
