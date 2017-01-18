/**
 * 
 */
package com.santander.tools.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.santander.commons.exceptions.DAOException;
import com.santander.commons.exceptions.FormatException;
import com.santander.tools.bean.MenuBean;
import com.santander.tools.bean.PerfilBean;
import com.santander.tools.bean.PermisoBean;

/**
 * @author Z615563
 *
 */
@Repository
public class PermisoDaoImpl implements PermisoDao {

	private static final Logger LOGGER = Logger.getLogger("defaultLogger");

/*OPCION varchar(50) 
PADRE varchar(50) 
IDX_OPCION int(11) 
IDX_PADRE int(11) 
CONTROLLER varchar(50)*/
	private static final String QUERY_PERMISOS = "SELECT P.OPCION," 
			+ "P.PADRE,"
			+ "P.CONTROLLER,"
			+ "P.IDX_OPCION," 
			+ "P.IDX_PADRE" 
			
			+ " FROM tb_pantalla P, tb_perfil_pantalla PF "
			+ " WHERE PF.ID_PANTALLA = P.ID_PANTALLA"
			+ " AND PF.ID_PERFIL= :idPerfil";


	
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSourceSntndr")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	
	
	private static final class PermisoMapper implements RowMapper<PermisoBean> {

		public PermisoBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			PermisoBean permiso = new PermisoBean();

			permiso.setOpcion(rs.getString(1));
			permiso.setMenu(rs.getString(2));
			permiso.setController(rs.getString(3));

			return permiso;
		}
	}
	

	/**
	 * Método para obtener servidores de la BD de la CMDB
	 *
	 * @return
	 * @throws DAOException
	 */
	@Override
	public List<PermisoBean> getPermisos(int idPerfil) throws DAOException {
		
		LOGGER.info("Obtener permisos, perfil: " + idPerfil);

		List<PermisoBean> listaPermisos = new ArrayList<PermisoBean>();
		Map<String, Object> parametros = new HashMap<String, Object>();
		try {
			
			parametros.put("idPerfil", idPerfil);
	
			LOGGER.debug("Ejecutando query: " + QUERY_PERMISOS);

			listaPermisos = this.jdbcTemplate.query(QUERY_PERMISOS, parametros, new PermisoMapper());

			if (listaPermisos == null) {
				listaPermisos = new ArrayList<PermisoBean>();
			}

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.trace(FormatException.obtieneStackTrace(e));
			throw new DAOException("Error en DAO: " + e.getMessage());
		}
		LOGGER.debug("Fin DAO");
		return listaPermisos;
	}
	
	
	@Override
	public PerfilBean getPerfil(int idPerfil, List<PermisoBean> listaPermisos) throws DAOException {
		
		PerfilBean perfil = new PerfilBean();
		perfil.setListaMenus(new ArrayList<MenuBean>());
		
	    /*SortedSet<PermisoBean> set = new TreeSet<PermisoBean>(new Comparator<PermisoBean>(){
	        public int compare(PermisoBean o1, PermisoBean o2) {
	        	 return o1.getMenu().compareTo(o2.getMenu());
	        }
	    });*/		
	    
	    //List<PermisoBean> listI = new ArrayList<>(listaPermisos);
	    //set.addAll(listI); // eliminate duplicates
	    
		List<PermisoBean> listI = new ArrayList<PermisoBean>(new LinkedHashSet<PermisoBean>(listaPermisos));
	    
		for (PermisoBean pb: listI){
			MenuBean mb = new MenuBean();
			
			mb.setNombre(pb.getMenu());
			mb.setListaOpciones(new ArrayList<PermisoBean>());
			for (PermisoBean pbb: listaPermisos){
				
				if(pbb.getMenu().equals(mb.getNombre())){
					mb.getListaOpciones().add(pbb);
				}
				
			}
			
			perfil.getListaMenus().add(mb);
		}
		
		return perfil;
	}	
	
	

}







