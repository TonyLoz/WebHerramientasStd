<%-- 
    Document   : index
    Created on : 25-nov-2014, 15:51:35
    Author     : hector.hurtado
--%>

<%@page import="com.santander.tools.properties.Props"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tailer" uri="/WEB-INF/tlds/tailertld.tld"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGS</title>
        <script>
            
            function recargarLog(){
                var x= document.getElementById("narchivo").value;
                var y= document.getElementById("nlineas").value;
                var patron = /^\d*$/; 
                if (y.length!=0 && patron .test(y) && y>0){
                     document.location="showLogTail.cfg?archivo=" + x +"&l="+y;
                }
            }
        </script>
    </head>
    <body>
        <a href="adminToolsMenu.cfg">Go to menu</a> <br/><br/>
        <%
            if (request.getParameter("archivo")==null){
         %>       
            <h1>LOGS!</h1> 
            <tailer:tail ruta='<%= Props.get("rutaLogs")%>' lineasMax="" modo="1" archivo="" />
            
         <%
            }else{
          %>       
            <% 
                int lineas=1000;
                if (request.getParameter("l")!=null){
                    lineas=Integer.valueOf(request.getParameter("l"));
                }
            %> 
        
             <h1>LOGS! <%= request.getParameter("archivo") %>  (<%=lineas%> Lineas)</h1>
             <br/><br/>
             Lineas: <input type="text" id="nlineas" name="nlineas" /><input type="button" value="Aceptar" onclick="recargarLog();" />
        
             <br/><br/>
             <input type="hidden" value="<%= request.getParameter("archivo") %>" id="narchivo" name="narchivo" />
            <tailer:tail ruta='<%= Props.get("rutaLogs")%>' archivo='<%= request.getParameter("archivo") %>' lineasMax='<%=lineas%>' modo='2' /> 
         <%       
            }
         %>
    </body>
</html>
