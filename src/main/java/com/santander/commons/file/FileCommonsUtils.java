/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santander.commons.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.santander.commons.exceptions.FileExistException;

/**
 * Utileria core para el manejo de archivos.
 * @author OMartinez
 */
public class FileCommonsUtils {

    /* Total de bytes a ller por segmento */
    private static final Integer READ_BYTES_PACKAGE = 1024;

    /**
     * Metodo que guarda el stream en un archivo de salida en el sistema de
     * archivos.
     * @param in stream a guardar
     * @param outputFile arhicos de salida.
     * @throws IOException excepcion en caso de que exista algun problema con el
     * FS.
     */
    public static void saveStream(final InputStream in, final File outputFile) throws IOException {
        OutputStream outputStream = null;
        try {
            if (outputFile.exists()) {
                throw new FileExistException(String.format("El archivo: %s exite en la ruta especificada!", outputFile.getName()));
            }
            outputStream = new FileOutputStream(outputFile);
            byte[] bytes = new byte[READ_BYTES_PACKAGE];
            int read;
            while ((read = in.read(bytes)) > 0) {
                outputStream.write(bytes, 0, read);
            }
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}
