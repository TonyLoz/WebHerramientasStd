var DelayMessage=2000;
var zIndex = 9999;
/**
 * Objeto que construye un objeto que muestra mensajes  de cualquier tipo
 * @type devuelve un objeto que contiene una instancia para el mostrado de notificaciones.
 */
var Messages = {
    messageOk: function(text, optParam) {
        $.notify({
            // options
            message: text
        }, {
            // settings
            type: 'success',
            z_index: zIndex,
            delay: DelayMessage,
            animate: {
		enter: 'animated fadeInDown',
		exit: 'animated fadeOutUp'
            }
        });
    },
    messageInfo: function(text, optParam) {
        $.notify({
            // options
            message: text
        }, {
            // settings
            type: 'info',
            z_index: zIndex,
            delay: DelayMessage,
            animate: {
		enter: 'animated fadeInDown',
		exit: 'animated fadeOutUp'
            }
        });
    },
    messageWarning: function(text, optParam) {
        $.notify({
            // options
            message: text
        }, {
            // settings
            type: 'warning',
            z_index: zIndex,
            delay: DelayMessage,
            animate: {
		enter: 'animated fadeInDown',
		exit: 'animated fadeOutUp'
            }
        });
    },
    messageError: function(text, optParam) {
        $.notify({
            // options
            message: text
        }, {
            // settings
            type: 'danger',
            z_index: zIndex,
            delay: DelayMessage,
            animate: {
		enter: 'animated fadeInDown',
		exit: 'animated fadeOutUp'
            }
        });
    },
    deleteMessages: function(optParam) {
        $.notifyClose();
    }    
};

