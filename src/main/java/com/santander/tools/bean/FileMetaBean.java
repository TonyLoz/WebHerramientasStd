/**
 * 
 */
package com.santander.tools.bean;



import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author scary
 *
 */
@JsonIgnoreProperties({ "bytes" })
public class FileMetaBean {
	private String fileName="";
	private String fileSize="";
	private String fileType="";

	private Boolean flagFoliar = false;
	private Boolean flagVistaPrevia = false;
	private Boolean flagCertFinal = false;
	private Boolean flagCertTodo = false;
	private Integer indexColectivo = null;

	private byte[] bytes;

	/**
	 * @return the flagFoliar
	 */
	public Boolean getFlagFoliar() {
		return flagFoliar;
	}

	/**
	 * @param flagFoliar
	 *            the flagFoliar to set
	 */
	public void setFlagFoliar(Boolean flagFoliar) {
		this.flagFoliar = flagFoliar;
	}

	/**
	 * @return the flagVistaPrevia
	 */
	public Boolean getFlagVistaPrevia() {
		return flagVistaPrevia;
	}

	/**
	 * @param flagVistaPrevia
	 *            the flagVistaPrevia to set
	 */
	public void setFlagVistaPrevia(Boolean flagVistaPrevia) {
		this.flagVistaPrevia = flagVistaPrevia;
	}

	/**
	 * @return the flagCertFinal
	 */
	public Boolean getFlagCertFinal() {
		return flagCertFinal;
	}

	/**
	 * @param flagCertFinal
	 *            the flagCertFinal to set
	 */
	public void setFlagCertFinal(Boolean flagCertFinal) {
		this.flagCertFinal = flagCertFinal;
	}

	/**
	 * @return the flagCertTodo
	 */
	public Boolean getFlagCertTodo() {
		return flagCertTodo;
	}

	/**
	 * @param flagCertTodo
	 *            the flagCertTodo to set
	 */
	public void setFlagCertTodo(Boolean flagCertTodo) {
		this.flagCertTodo = flagCertTodo;
	}

	/**
	 * @return the indexColectivo
	 */
	public Integer getIndexColectivo() {
		return indexColectivo;
	}

	/**
	 * @param indexColectivo
	 *            the indexColectivo to set
	 */
	public void setIndexColectivo(Integer indexColectivo) {
		this.indexColectivo = indexColectivo;
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
}
