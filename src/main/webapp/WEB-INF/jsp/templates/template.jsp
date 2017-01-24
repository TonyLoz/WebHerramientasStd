<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/logo.png">
        <title>Home-WebHerramientasStd</title>
        <link href="${pageContext.request.contextPath}/resources/libs/bootstrap-th/css/bootstrap.min.css" rel="stylesheet">    
        <link href="${pageContext.request.contextPath}/resources/libs/bootstrap-th/css/main.css" rel="stylesheet">  
        <link href="${pageContext.request.contextPath}/resources/libs/bootstrap-th/css/animations.css" rel="stylesheet">  
        <link href="${pageContext.request.contextPath}/resources/libs/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/mensajes.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/global.css" rel="stylesheet">      
        <!--link href="${pageContext.request.contextPath}/resources/css/autenticacion.css" rel="stylesheet"-->
   		<link href="${pageContext.request.contextPath}/resources/css/loading.css" rel="stylesheet"  /><!-- Loading -->
   		<link href="${pageContext.request.contextPath}/resources/libs/bootstrap-select-1.11.2/css/bootstrap-select.min.css" rel="stylesheet" >
   		<link href="${pageContext.request.contextPath}/resources/libs/bootstrap-touchspin/jquery.bootstrap-touchspin.min.css" rel="stylesheet" >
   		<link href="${pageContext.request.contextPath}/resources/libs/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
   		<link href="${pageContext.request.contextPath}/resources/libs/bootstrap-fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resources/libs/datatables-1.10.12/media/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css" >
        <link href="${pageContext.request.contextPath}/resources/libs/handsontable/handsontable.full.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/libs/handsontable/plugins/bootstrap/handsontable.bootstrap.css" rel="stylesheet">   		

        <!--script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery-3.1.1.min.js"></script-->
        <!-- script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery-1.10.2.min.js"></script-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery-2.2.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/modernizr-2.6.2.min.js"></script>        
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootstrap-th/js/bootstrap.min.js"></script>        
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootstrap-notify/bootstrap-notify.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/respond.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/placeholdem.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/hoverIntent.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/superfish.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.actual.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.elastislide.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.prettyPhoto.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.ui.totop.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.isotope.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.easypiechart.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jflickrfeed.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.sticky.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/owl.carousel.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.nicescroll.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.fractionslider.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.scrollTo-min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.localscroll-min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.parallax-1.1.3.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootbox.min.js"></script> 
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootstrap-select-1.11.2/js/bootstrap-select.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootstrap-touchspin/jquery.bootstrap-touchspin.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/handsontable/handsontable.full.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/datatables-1.10.12/media/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/datatables-1.10.12/DataTableLanguage.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/datatables-1.10.12/media/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/validator/validator.min.js"></script>

 		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootstrap-fileinput/js/fileinput.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootstrap-fileinput/js/locales/es.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootstrap-fileinput/js/plugins/canvas-to-blob.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootstrap-fileinput/js/plugins/purify.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/bootstrap-fileinput/js/plugins/sortable.min.js"></script>
        
		<!--script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery.ui.widget.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libs/jquery-fileupload-9.14.0/js/jquery.iframe-transport.js"></script-->
      
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/messagesBN.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/loading.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/temporizadorSesion.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mensajes.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/global.js"></script>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/commons/plugins.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/commons/main.js"></script>  
        <!-- script type="text/javascript" src="${urlMapas}"></script-->

        <title>WebHerramientasStd</title>
    </head>
    <body>
    	<input id="contextPath" type="hidden" name="country" value="${pageContext.request.contextPath}">
        <t:insertAttribute name="encabezado" ignore="true" />
        <div id="contenedorAreaTrabajo" class="container">
            <div id="mensajeGlobal" class="notifications-inline"></div>
            <t:insertAttribute name="areaTrabajo" ignore="true" />
        </div>
    </body>
</html>