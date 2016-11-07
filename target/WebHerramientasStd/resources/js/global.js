var contextPath = null;
$(document).ready(function() {
    Global.init();
    Global.ocultarProcesando();
});
var Global = {
    init: function() {
        contextPath = $("#context-path").val();
        Mensajes.init({selector: "#mensajeGlobal"});
        TemporizadorSesion.init();
    },
    salir: function() {
        location.href = contextPath + "/cerrarSesion.htm";
    },
    borrarMensajeGlobal: function(){
        $('#mensajeGlobal').html('');
    },
    verProcesando: function() {
        $('.navbarCargando').show();
    },
    ocultarProcesando: function() {
        $('.navbarCargando').hide();
    },
    tienePermiso: function(permiso){
        if ($('#usuario-permisos').val().contains('[' + permiso + ']')){
            return true;
        } else {
            return false;
        }
    }
};


