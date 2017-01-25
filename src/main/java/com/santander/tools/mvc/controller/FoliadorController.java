package com.santander.tools.mvc.controller;




import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.santander.commons.exceptions.ServiceException;
import com.santander.tools.bean.ArchivoOpcionesBean;
import com.santander.tools.bean.FileMetaBean;
import com.santander.tools.bean.RespuestaJsonBean;
import com.santander.tools.service.foliador.PaginadorService;



/**
 * Clase que controla todas las peticiones relacionadas foliador
 * 
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 03/08/2016
 */
@Controller
public class FoliadorController extends BaseMultiActionController {

	private static final Logger LOG = Logger.getLogger(FoliadorController.class);  
	
	@Autowired
	PaginadorService paginadorService;
	
	private List<FileMetaBean> archivos = new ArrayList<FileMetaBean>();
	private List<FileMetaBean> archivosProcesados = new ArrayList<FileMetaBean>();
	
	private FileMetaBean archivoMeta = null;	
	
	
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/foliador.htm",method = RequestMethod.GET)
    public ModelAndView foliador(HttpServletRequest request, Map<String, Object> model) throws InterruptedException{
    	LOG.debug("Controller para redirigir a la pantalla de foliador");
    	
    	ModelAndView respuestaController = new ModelAndView("foliador");
    	
    	List<FileMetaBean> tmp = (List<FileMetaBean>) request.getSession(false).getAttribute("listaArchivos");
    	
    	archivos.addAll(new ArrayList<FileMetaBean>(tmp)); 
    	
    	//request.getSession(false).removeAttribute("listaArchivos");
    	
        return respuestaController;
    }
    
    
    /**
     * Metodo para obtener la lista de arcivos cargados
     *
     * @param request
     * @param model
     * @return
     */
	
	@RequestMapping(value = "/consultarArchivos.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RespuestaJsonBean consultarArchivos(final HttpServletRequest request,
			final Map<String, Object> model) {
	

    	LOG.info("Controller para obtener, en formato JSON, Archivos cargados previamente");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();

        //try {
            respuesta.setLista(archivos);
            respuesta.setEstatus("ok");

        /*} catch (ServiceException se) {
        	LOG.error("Error al obtener Perfiles: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        }*/

        return respuesta;

    }	   
	
	
	
	
    /**
     * Metodo para obtener la lista de arcivos cargados
     *
     * @param request
     * @param model
     * @return
     */
	
	@RequestMapping(value = "/procesarArchivos.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RespuestaJsonBean procesarArchivos(final HttpServletRequest request,
			final Map<String, Object> model) {
	

    	LOG.info("Controller para obtener, en formato JSON, Archivos cargados previamente");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();
        
        archivosProcesados = new ArrayList<FileMetaBean>();
        List <String> nombres = new ArrayList<String>();
        
        Map<String, Object> parameters = request.getParameterMap();
        
        for (Map.Entry<String, Object> entry : parameters.entrySet())
        {
        	Object o = entry.getValue();
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }        
        
        
        LOG.info("Tamaño Opciones:"+parameters.size());
        

        try {
        
        	for(FileMetaBean fmb : archivos){
        		
                String outputFile = fmb.getFileName().replace(".pdf", "") + "_foliado.pdf";
                outputFile= outputFile.replace(" ", "");
                
                InputStream is = paginadorService.paginarDocumento(fmb.getBytes(), outputFile);
                
                FileMetaBean fmbp = new FileMetaBean();
                
                byte[] bytes = IOUtils.toByteArray(is);
                
                fmbp.setBytes(bytes);
                fmbp.setFileName(outputFile);
                
                nombres.add(outputFile);
                
                archivosProcesados.add(fmbp);
        		
        	}
        
    		HttpSession sesion = request.getSession(true);
    		sesion.setAttribute("nombresProcesados", nombres); 
    		sesion.setAttribute("archivosProcesados", archivosProcesados); 
        	
            respuesta.setLista(nombres);
            respuesta.setEstatus("ok");
            respuesta.setMensaje("Archivos Procesados Correctamente");

        } catch (ServiceException se) {
        	LOG.error("Error al obtener Perfiles: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        } catch (IOException se) {
        	LOG.error("Error al obtener Perfiles: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        }

        return respuesta;

    }	
    
	
}
