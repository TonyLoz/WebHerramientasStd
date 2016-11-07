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

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.santander.commons.exceptions.DAOException;
import com.santander.commons.exceptions.FormatException;
import com.santander.tools.bean.PerfilBean;

/**
 * @author Omartinez
 *
 */
@Repository
public class PerfilDaoImpl implements PerfilDao {

	private static final Logger LOGGER = Logger.getLogger("defaultLogger");

	private static final String QUERY_PERFIL = "SELECT ID_PERFIL," + "PERFIL" + " FROM tb_perfil ";

	private static final String INSERTAR_PERFIL = "INSERT INTO tb_perfil " + "(PERFIL) " + " VALUES " + "(:perfil)";

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSourceSntndr")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private static final class PerfilMapper implements RowMapper<PerfilBean> {

		public PerfilBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			PerfilBean perfil = new PerfilBean();
			perfil.setId(rs.getInt(1));
			perfil.setNombre(rs.getString(2));

			return perfil;
		}
	}

	/**
	 * Método para obtener perfiles
	 *
	 * @return
	 * @throws DAOException
	 */
	@Override
	public List<PerfilBean> getPerfiles() throws DAOException {

		LOGGER.info("Obtener perfiles");

		Map<String, Object> parametros = new HashMap<String, Object>();
		List<PerfilBean> lista = new ArrayList<PerfilBean>();
		try {

			LOGGER.debug("Ejecutando query: " + QUERY_PERFIL);

			lista = this.jdbcTemplate.query(QUERY_PERFIL, parametros, new PerfilMapper());

			if (lista == null) {
				lista = new ArrayList<PerfilBean>();
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
	public Long registrarPerfi(PerfilBean perfil) throws DAOException {

		// Insertamos el registro en caso de que no exista
		MapSqlParameterSource bindValues = new MapSqlParameterSource();

		agregarParametros(perfil, bindValues);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		LOGGER.debug(String.format("Ejecutando Query: %s", INSERTAR_PERFIL));

		this.jdbcTemplate.update(INSERTAR_PERFIL, bindValues, keyHolder);

		return Long.parseLong(keyHolder.getKey().toString());
	}

	private void agregarParametros(PerfilBean perfil, MapSqlParameterSource params) {

		params.addValue("perfil", perfil.getNombre());

	}

}
