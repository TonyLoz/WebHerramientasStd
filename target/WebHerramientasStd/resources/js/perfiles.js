$(document).ready(function () {


});






function altaUsuario() {

    $.ajax({
        url: "altaUsuario.htm",
        type: "GET",
        beforeSend: function() {
            mostrarMensajeCargando("Por favor espere, cargando información");
        },
        success: function(respuestaJson) {
            ocultarMensajes();
            if (respuestaJson.estatus === "ok") {

                ocultarMensajes();
            } else {
                if (respuestaJson.estatus === "preventivo") {
                    mostrarMensajePreventivo(respuestaJson.mensaje);
                } else {
                    mostrarMensajeError(respuestaJson.mensaje);
                }
            }

        },
        error: function() {
            ocultarMensajes();
            mostrarMensajeError("Ocurri&oacute; un error al cargar información");
        }
    });

}



function consultarPerfiles() {
    //ocultarMensajes();

    $.ajax({
        url: "consultarPerfiles.htm",
        type: "GET",
        dataType: "json",
        async: false,
        beforeSend: function() {
            //mostrarMensajeCargando("Por favor espere, cargando información");
        },
        success: function(respuestaJson) {
            //ocultarMensajes();
            if (respuestaJson.estatus === "ok") {

                listaPerfiles = respuestaJson.lista;
                
                $.each(listaPerfiles, function(id,value){
            		$("#ltPerfil").append('<option value="'+vaue.id+'">'+value.nombre+'</option>');
            	});
                
                //ocultarMensajes();
            } else {
                if (respuestaJson.estatus === "preventivo") {
                    //mostrarMensajePreventivo(respuestaJson.mensaje);
                } else {
                    //mostrarMensajeError(respuestaJson.mensaje);
                }
            }

        },
        error: function() {
            //ocultarMensajes();
            //mostrarMensajeError("Ocurri&oacute; un error al consultar Ejecutivos");
        }
    });
}