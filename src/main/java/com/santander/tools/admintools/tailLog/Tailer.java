/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santander.tools.admintools.tailLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 *
 * @author OMartinez
 */
 
    
public class Tailer extends SimpleTagSupport{
    
    private String archivo;
    private int lineasMax;
    private String modo;
    private String ruta;

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int getLineasMax() {
        return lineasMax;
    }

    public void setLineasMax(int lineasMax) {
        this.lineasMax = lineasMax;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    

    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter outPage = getJspContext().getOut();
          String[]  buffer = new String[lineasMax];
        try{
            
            if (modo.equals("1")){
                java.io.File directorio = new java.io.File(ruta);
		String [] ficheros = directorio.list();
		for (int i = 0; i < ficheros.length; i++) {
                    try {
                            outPage.println("<a href=showLogTail.cfg?archivo=" + ficheros[i]+ ">"+ ficheros[i] + "</a></br>");

                    } catch (IOException e) {
                            e.printStackTrace();
                    }
		}
            }
            
            if (modo.equals("2")){
                 BufferedReader reader = new BufferedReader(new FileReader(this.ruta+"/"+this.archivo));
                int index = -1;
                String linea;

                while ((linea = reader.readLine()) != null){

                    index += 1;
                    if ( index >= lineasMax){
                        for (int i = 0; i < lineasMax - 1; i++) {
                          buffer[i] =  buffer[(i + 1)];
                        }
                         index = (lineasMax - 1);
                    }
                    buffer[index] = linea;
                }
                for (String s: buffer){
                    if (s!=null){
                    outPage.println(s + "</br>");
                    }
                }
                reader.close();
            }
            
        }catch (Exception e){
             outPage.println(e.getMessage());
             e.printStackTrace();
        }
    }
    
}
