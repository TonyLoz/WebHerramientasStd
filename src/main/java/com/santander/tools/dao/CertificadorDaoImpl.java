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

import com.santander.tools.bean.CertificadorBean;

/**
 * @author Omartinez
 *
 */
@Repository
public class CertificadorDaoImpl implements CertificadorDao {

	private static final Logger LOGGER = Logger.getLogger("defaultLogger");

	private static final String QUERY_CERTIFICADORES = "SELECT ID_CERT,NOMBRE,SELECCIONADO FROM tb_certificador"
			+ " ORDER BY NOMBRE";
	
	private static final String ACTUALIZAR_CERTIFICADOR = "UPDATE tb_certificador SET NOMBRE=:nombre WHERE ID_CERT=:id";
	
	private static final String BORRAR_CERTIFICADOR = "DELETE FROM tb_certificador WHERE ID_CERT=:id";
	
	
	  private static final String INSERTAR_CERTIFICADOR
      = "INSERT INTO tb_certificador "
      + "(NOMBRE,SELECCIONADO) "
      + " VALUES "
      + "(:nombre,:sel)";	

    
    
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSourceSntndr")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private static final class CertificadorMapper implements RowMapper<CertificadorBean> {

		public CertificadorBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			CertificadorBean certificador = new CertificadorBean();
			certificador.setIdCertificador(rs.getInt(1));
			certificador.setNombre(rs.getString(2));
			certificador.setSeleccionado(rs.getInt(3));
			return certificador;
		}
	}



	

	/**
	 * Método para obtener un usuarios
	 *
	 * @return
	 * @throws DAOException
	 */
	@Override
	public List<CertificadorBean> getCertificadores() throws DAOException {

		LOGGER.info("Obtener certificadores");

		Map<String, Object> parametros = new HashMap<String, Object>();
		List<CertificadorBean> lista = new ArrayList<CertificadorBean>();
		try {

			LOGGER.debug("Ejecutando query: " + QUERY_CERTIFICADORES);

			lista = this.jdbcTemplate.query(QUERY_CERTIFICADORES, parametros, new CertificadorMapper());

			if (lista == null) {
				lista = new ArrayList<CertificadorBean>();
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
    public Long registrarCertificador(CertificadorBean certificador) throws DAOException {

        //Insertamos el registro en caso de que no exista
        MapSqlParameterSource bindValues = new MapSqlParameterSource();
        
        bindValues.addValue("nombre", certificador.getNombre());
        bindValues.addValue("sel", 0);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        LOGGER.debug(String.format("Ejecutando Query: %s", INSERTAR_CERTIFICADOR));

        this.jdbcTemplate.update(INSERTAR_CERTIFICADOR, bindValues, keyHolder);

        return Long.parseLong(keyHolder.getKey().toString());
    }	

    

    
    @Override
    public void actualizarCertificador(CertificadorBean certificador) throws DAOException {

        //Insertamos el registro en caso de que no exista
        MapSqlParameterSource bindValues = new MapSqlParameterSource();
        
        bindValues.addValue("nombre", certificador.getNombre());
        bindValues.addValue("id", certificador.getIdCertificador());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        LOGGER.debug(String.format("Ejecutando Query: %s", ACTUALIZAR_CERTIFICADOR));

        this.jdbcTemplate.update(ACTUALIZAR_CERTIFICADOR, bindValues, keyHolder);

        //return Long.parseLong(keyHolder.getKey().toString());
    }    
    
    
    @Override
    public void borrarCertificador(CertificadorBean certificador) throws DAOException {

        //Insertamos el registro en caso de que no exista
        MapSqlParameterSource bindValues = new MapSqlParameterSource();
        
        bindValues.addValue("id", certificador.getIdCertificador());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        LOGGER.debug(String.format("Ejecutando Query: %s", BORRAR_CERTIFICADOR));

        this.jdbcTemplate.update(BORRAR_CERTIFICADOR, bindValues, keyHolder);

        //return Long.parseLong(keyHolder.getKey().toString());
    }     
    

}
