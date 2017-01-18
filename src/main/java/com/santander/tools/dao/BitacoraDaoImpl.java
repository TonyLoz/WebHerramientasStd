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
import com.santander.tools.bean.BitacoraBean;

/**
 * @author Omartinez
 *
 */
@Repository
public class BitacoraDaoImpl implements BitacoraDao {

	private static final Logger LOGGER = Logger.getLogger("defaultLogger");

	private static final String QUERY_USUARIO = "SELECT u.NOMBRE," + "u.PASSWORD," + "u.EMAIL," + "u.ID_PERFIL, " + "p.PERFIL FROM tb_usuario u, tb_perfil p WHERE p.ID_PERFIL=u.ID_PERFIL "
			+ " AND EMAIL = :email";
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSourceSntndr")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private static final class BitacoraMapper implements RowMapper<BitacoraBean> {

		public BitacoraBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			BitacoraBean bitacora = new BitacoraBean();
			bitacora.setUsuario(rs.getString(1));
			bitacora.setComentarios(rs.getString(2));
			bitacora.setFecha(rs.getString(3));
			bitacora.setArchivo(rs.getString(4));
			bitacora.setOperacion(rs.getString(4));

			return bitacora;
		}
	}


	/**
	 * Método para obtener un usuarios
	 *
	 * @return
	 * @throws DAOException
	 */
	@Override
	public List<BitacoraBean> getObtenerBitacora() throws DAOException {

		LOGGER.info("Obtener usuarios");

		Map<String, Object> parametros = new HashMap<String, Object>();
		List<BitacoraBean> lista = new ArrayList<BitacoraBean>();
		
		//String usuario,	String operacion, String comentarios, String fecha, String archivo
		
		BitacoraBean b1 = new BitacoraBean("Alvaro S", "FOLIAR", "Se pagino documento", "01/01/17 12:00:00", "archivo_alvaro_010117120000.pdf");
		BitacoraBean b2 = new BitacoraBean("Alvaro S", "FOLIAR", "Se pagino documento", "15/01/17 04:00:00", "archivo2_alvaro_150117120000.pdf");
		
		lista.add(b1);
		lista.add(b2);

		LOGGER.debug("Fin DAO");
		return lista;
	}	
	

    
    

}
