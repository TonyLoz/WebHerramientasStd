package com.santander.tools.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un usuario.
 * @author OMartinez, V1.1
 * @version 1.0, 14/08/2016
 */
public class UsuarioBean {
    
    private String usuario = "";
    private int idUsuario = 0;
    private int idPerfil = 0;


	private String contrasena = "";
    private String nombre = "";
    private PerfilBean perfil = null;

    private String correo = "";
    private Map<String,String> permisos = new HashMap<String,String>();

 
	private String pregunta = "";
    private String respuesta = "";
    private Integer intento = 0;
    
    /**
	 * @return the idPerfil
	 */
	public int getIdPerfil() {
		return idPerfil;
	}

	/**
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public PerfilBean getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilBean perfil) {
        this.perfil = perfil;
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

    public Map<String,String> getPermisos() {
        return permisos;
    }

    public void setPermisos(Map<String,String> permisos) {
        this.permisos = permisos;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
 	 * @return the pregunta
 	 */
 	public String getPregunta() {
 		return pregunta;
 	}

 	/**
 	 * @param pregunta the pregunta to set
 	 */
 	public void setPregunta(String pregunta) {
 		this.pregunta = pregunta;
 	}

 	/**
 	 * @return the respuesta
 	 */
 	public String getRespuesta() {
 		return respuesta;
 	}

 	/**
 	 * @param respuesta the respuesta to set
 	 */
 	public void setRespuesta(String respuesta) {
 		this.respuesta = respuesta;
 	}

 	/**
 	 * @return the intento
 	 */
 	public Integer getIntento() {
 		return intento;
 	}

 	/**
 	 * @param intento the intento to set
 	 */
 	public void setIntento(Integer intento) {
 		this.intento = intento;
 	}
    
    
}
