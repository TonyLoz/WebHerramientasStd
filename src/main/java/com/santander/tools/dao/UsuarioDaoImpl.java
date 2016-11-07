/**
 * 
 */
package com.santander.tools.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.santander.commons.exceptions.DAOException;
import com.santander.commons.exceptions.FormatException;

import com.santander.tools.bean.UsuarioBean;

/**
 * @author Omartinez
 *
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private static final Logger LOGGER = Logger.getLogger("defaultLogger");

	private static final String QUERY_USUARIO = "SELECT NOMBRE," + "PASSWORD," + "EMAIL," + "ID_PERFIL" + " FROM tb_usuario "
			+ " WHERE EMAIL = :email";
	
	  private static final String INSERTAR_USUARIO
      = "INSERT INTO tb_usuario "
      + "(NOMBRE,CORREO,IDPERFIL,INTENTO) "
      + " VALUES "
      + "(:nombre,:correo,:perfil,:intento)";	

    @Value("${password.default}")
    private String defaultPassword;
    
    
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSourceSntndr")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private static final class UsuarioMapper implements RowMapper<UsuarioBean> {

		public UsuarioBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			UsuarioBean usuario = new UsuarioBean();
			usuario.setNombre(rs.getString(1));
			usuario.setContrasena(rs.getString(2));
			usuario.setCorreo(rs.getString(3));

			usuario.setIdPerfil(rs.getInt(4));
			return usuario;
		}
	}



	/**
	 * Método para obtener un usuario
	 *
	 * @return
	 * @throws DAOException
	 */
	@Override
	public UsuarioBean getUsuario(String mail) throws DAOException {

		LOGGER.info("Obtener usuario: " + mail);

		UsuarioBean usuario = new UsuarioBean();
		Map<String, Object> parametros = new HashMap<String, Object>();
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		try {

			parametros.put("email", mail);

			LOGGER.debug("Ejecutando query: " + QUERY_USUARIO);

			lista = this.jdbcTemplate.query(QUERY_USUARIO, parametros, new UsuarioMapper());

			if (lista != null) {
				if (lista.size() > 0) {
					usuario = lista.get(0);
				} else {
					usuario = null;
				}
			} else {
				usuario = null;
			}			

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.trace(FormatException.obtieneStackTrace(e));
			throw new DAOException("Error en DAO: " + e.getMessage());
		}
		LOGGER.debug("Fin DAO");
		return usuario;
	}
	

	/**
	 * Método para obtener un usuarios
	 *
	 * @return
	 * @throws DAOException
	 */
	@Override
	public List<UsuarioBean> getUsuarios() throws DAOException {

		LOGGER.info("Obtener usuarios");

		Map<String, Object> parametros = new HashMap<String, Object>();
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		try {

			LOGGER.debug("Ejecutando query: " + QUERY_USUARIO);

			lista = this.jdbcTemplate.query(QUERY_USUARIO, parametros, new UsuarioMapper());

			if (lista != null) {
				lista = new ArrayList<UsuarioBean>();
			}			

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.trace(FormatException.obtieneStackTrace(e));
			throw new DAOException("Error en DAO: " + e.getMessage());
		}
		LOGGER.debug("Fin DAO");
		return lista;
	}	
	
    @Override
    public Long registrarUsuario(UsuarioBean Usuario) throws DAOException {

        //Insertamos el registro en caso de que no exista
        MapSqlParameterSource bindValues = new MapSqlParameterSource();

        agregarParametros(Usuario, bindValues);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        LOGGER.debug(String.format("Ejecutando Query: %s", INSERTAR_USUARIO));

        this.jdbcTemplate.update(INSERTAR_USUARIO, bindValues, keyHolder);

        return Long.parseLong(keyHolder.getKey().toString());
    }	

    
    private void agregarParametros(
    		UsuarioBean usuario, MapSqlParameterSource params) {
  
    	/*if (usuario.getNombre() == null) {
            params.addValue("NOMBRE", null);
        } else {
            params.addValue("NOMBRE", usuario.getNombre());
        }*/
        params.addValue("nombre", usuario.getNombre());
        params.addValue("intento", 0);
        params.addValue("password", defaultPassword);
        params.addValue("perfil", usuario.getIdPerfil());
        params.addValue("correo", usuario.getCorreo());

    }
    
    

}
