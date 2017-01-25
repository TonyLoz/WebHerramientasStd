/**
 * 
 */
package com.santander.tools.mvc.controller;

import java.io.File;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.santander.commons.exceptions.ServiceException;
import com.santander.tools.bean.BitacoraBean;
import com.santander.tools.bean.CertificadorBean;
import com.santander.tools.bean.FileMetaBean;
import com.santander.tools.bean.RespuestaJsonBean;

/**
 * @author scary
 *
 */
@Controller
@RequestMapping
public class DescargarArchivosController {

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
	
	
	
	/*
     * Download a file from 
     *   - inside project, located in resources folder.
     *   - outside project, located in File system somewhere. 
     */
    @RequestMapping(value="/download/{nameFile}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, @PathVariable("type") String nameFile) throws IOException {
     
        //File file = null;
        
        FileMetaBean selected = new FileMetaBean();
        
        for (FileMetaBean fmb : archivosProcesados){
        	
        	if(fmb.getFileName().equals(nameFile)){
        		selected = fmb;
        		break;
        	}
        	
        }
        
         
        String mimeType= URLConnection.guessContentTypeFromName(selected.getFileName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
         
        System.out.println("mimetype : "+mimeType);
         
        response.setContentType(mimeType);
         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + selected.getFileName() +"\""));
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)selected.getBytes().length);
        
        ByteArrayInputStream bis = new ByteArrayInputStream(selected.getBytes());
        
        InputStream inputStream = new BufferedInputStream(bis);
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }	
	

}
