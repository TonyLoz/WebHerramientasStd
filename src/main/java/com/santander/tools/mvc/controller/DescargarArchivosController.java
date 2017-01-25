/**
 * 
 */
package com.santander.tools.mvc.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.santander.tools.bean.FileMetaBean;
import com.santander.tools.bean.RespuestaJsonBean;

/**
 * @author scary
 *
 */
@Controller
@RequestMapping
public class DescargarArchivosController extends BaseMultiActionController {

	private static final Logger LOG = Logger.getLogger(DescargarArchivosController.class);
		
	private List<FileMetaBean> archivosProcesados = new ArrayList<FileMetaBean>();
	private List<String> nombresProcesados = new ArrayList<String>();
	
	private FileMetaBean fileMeta = null;
	
	


	private static final String INTERNAL_FILE="irregular-verbs-list.pdf";
	private static final String EXTERNAL_FILE_PATH="C:/mytemp/SpringMVCHibernateManyToManyCRUDExample.zip";	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/descargarArchivos.htm",method = RequestMethod.GET)
    public ModelAndView descargarArchivos(HttpServletRequest request, Map<String, Object> model) throws InterruptedException{
		
		LOG.debug("Controller para redirigir a la pantalla de downloading de archivos");
		ModelAndView respuestaController = new ModelAndView("descargarArchivos");
		
    	archivosProcesados = (List<FileMetaBean>) request.getSession(false).getAttribute("archivosProcesados");
    	nombresProcesados = (List<String>) request.getSession(false).getAttribute("nombresProcesados");
		
		return respuestaController;
	}
	
	
    /**
     * Metodo para obtener la lista de archivos procesados
     *
     * @param request
     * @param model
     * @return
     */
	
	@RequestMapping(value = "/consultarProcesados.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RespuestaJsonBean consultarPerfiles(final HttpServletRequest request,
			final Map<String, Object> model) {
	

    	LOG.info("Controller para obtener, en formato JSON, archivos procesados");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();

        //try {
            respuesta.setLista(archivosProcesados);
            respuesta.setEstatus("ok");

        //} catch (ServiceException se) {
        //	LOG.error("Error al obtener Bitacora: " + se.getMessage() + " " + se.toString());
         //   respuesta.setEstatus("error");
         //   respuesta.setMensaje(se.getMessage());
        //}

        return respuesta;

    }	
	
	
  /*  @RequestMapping(value = "download.do", method = RequestMethod.GET)
    public void getFile(final HttpServletRequest request,
            HttpServletResponse response) {
        try {
        	
        	JSONObject o =  requestParamsToJSON(request);
        	
        	String fileName = o.getString("nombre");
        	
            DefaultResourceLoader loader = new DefaultResourceLoader();
            InputStream is = loader.getResource("classpath:META-INF/resources/Accepted.pdf").getInputStream();
            IOUtils.copy(is, response.getOutputStream());
            response.setHeader("Content-Disposition", "attachment; filename=Accepted.pdf");
            response.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        }
    }*/	
	
    

    
	/*
     * Download a file from 
     *   - inside project, located in resources folder.
     *   - outside project, located in File system somewhere. 
     */
    @RequestMapping(value = "download.do", method = RequestMethod.GET, produces = "application/pdf")
    public void getFile(final HttpServletRequest request,
            HttpServletResponse response) throws IOException{ 
        //File file = null;
        
    	JSONObject o =  requestParamsToJSON(request);
    	String fileName = o.getString("nombre");    	
    	
        FileMetaBean selected = new FileMetaBean();
        
        for (FileMetaBean fmb : archivosProcesados){
        	
        	if(fmb.getFileName().equals(fileName)){
        		selected = fmb;
        		break;
        	}
        	
        }
        
        
        ByteArrayInputStream bis = new ByteArrayInputStream(selected.getBytes());
        
        InputStream inputStream = new BufferedInputStream(bis);
        
        String mimeType= "application/pdf";
        
        response.setContentType(mimeType);
        
        response.setHeader("Content-Disposition", "attachment; filename=\""+selected.getFileName()+"\""); 
        
        response.setContentLength(selected.getBytes().length);
 
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
        
        //org.apache.commons.io.IOUtils.copy(inputStream, response.getOutputStream());
        
        response.flushBuffer();
        
    }	
    
	
	

}
