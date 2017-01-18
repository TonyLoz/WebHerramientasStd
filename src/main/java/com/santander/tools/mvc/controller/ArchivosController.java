/**
 * 
 */
package com.santander.tools.mvc.controller;

import java.io.FileOutputStream;
import java.io.IOException;
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

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.santander.tools.bean.FileMetaBean;
import com.santander.tools.bean.RespuestaJsonBean;

/**
 * @author scary
 *
 */
@Controller
@RequestMapping
public class ArchivosController {

	private static final Logger LOG = Logger.getLogger(ArchivosController.class);
		
	private List<FileMetaBean> files2 = new ArrayList<FileMetaBean>();
	
	private FileMetaBean fileMeta = null;

	private String[] archivosPermitidos = { "PDF", "pdf", "tiff", "TIFF", "tif", "TIF" };

	@RequestMapping(value = "/archivos.htm", method = RequestMethod.GET)
	public String mostrarUsuarios() {
		LOG.debug("Controller para redirigir a la pantalla de uploading de archivos");
		files2 = new ArrayList<FileMetaBean>();
		return "archivos";
	}

	/***************************************************
	 * URL: /rest/controller/upload upload(): receives files
	 * 
	 * @param request
	 *            : MultipartHttpServletRequest auto passed
	 * @param response
	 *            : HttpServletResponse auto passed
	 * @return LinkedList<FileMeta> as json format
	 ****************************************************/
	@RequestMapping(value = "/upload.json", method = RequestMethod.POST)
	public @ResponseBody List<FileMetaBean> upload(@RequestParam("input22[]") ArrayList<MultipartFile> files) {
		
		
		for (MultipartFile mpf : files) {

			String ext1 = FilenameUtils.getExtension(mpf.getOriginalFilename());

			if (Arrays.asList(archivosPermitidos).contains(ext1)) {

					// 2.2 if files > 10 remove the first from the list
					//if (files.size() >= 10)
						//files.pop();

					// 2.3 create new fileMeta
					fileMeta = new FileMetaBean();
					fileMeta.setFileName(mpf.getOriginalFilename());
					fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
					fileMeta.setFileType(mpf.getContentType());

					try {
						fileMeta.setBytes(mpf.getBytes());

						// copy file to local disk (make sure the path "e.g.
						// D:/temp/files" exists)
						FileCopyUtils.copy(mpf.getBytes(),
								new FileOutputStream("/temp/files/" + mpf.getOriginalFilename()));

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 2.4 add to files
					files2.add(fileMeta);
					LOG.info("Archivo subido:" + fileMeta.getFileName());

			}
			
			
		}		
		
		return files2;

	}

	/***************************************************
	 * URL: /rest/controller/get/{value} get(): get file as an attachment
	 * 
	 * @param response
	 *            : passed by the server
	 * @param value
	 *            : value from the URL
	 * @return void
	 ****************************************************/
	@RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
	public void get(HttpServletResponse response, @PathVariable String value) {
		FileMetaBean getFile = files2.get(Integer.parseInt(value));
		try {
			response.setContentType(getFile.getFileType());
			response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getFileName() + "\"");
			FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/cancelarUpload.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<FileMetaBean> cancelarUpload(final HttpServletRequest request,
			final Map<String, Object> model) {

		LOG.info("Controller cancelar operacion");
		files2 = new ArrayList<FileMetaBean>();

		return files2;

	}
	
	@RequestMapping(value = "/listarArchivos.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<FileMetaBean> listarArchivos(final HttpServletRequest request,
			final Map<String, Object> model) {

		LOG.info("Controller listar archivos");


		return files2;

	}	

	@RequestMapping(value = "/borrarArchivo.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<FileMetaBean> borrarArchivo(@RequestParam("index") String index) {

		Integer val = Integer.parseInt(index);

		LOG.info("Controller borrar archivo");
		int i = 0;
		for (FileMetaBean it : files2) {
			if (i == val) {
				files2.remove(it);
				break;
			}
			i++;

		}

		return files2;

	}

	@RequestMapping(value = "/seleccionarTipoArchivo.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RespuestaJsonBean seleccionarTipoArchivo(@RequestParam("tipo") String tipo) {

		LOG.info("Controller borrar archivo");

		RespuestaJsonBean respuesta = new RespuestaJsonBean();

		//tipoArchivo = tipo;

		respuesta.setEstatus("OK");

		return respuesta;

	}

	@RequestMapping(value = "/iniciaFoliador.htm", method = RequestMethod.GET)
	public String iniciarFoliador(HttpServletRequest request, Map<String, Object> model) throws InterruptedException {

		LOG.info("Controller para redirigir a la pantalla de foliador");

		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("listaArchivos", files2);
		files2 = new ArrayList<FileMetaBean>();
		return "redirect:/foliador.htm";

	}

}
