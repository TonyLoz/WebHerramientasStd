var TemporizadorSesion = {
    tiempoSegSesion: 1800,
    tiempoRestante: 0,
    idTemporizador: null,
    estaCorriendoTemporizador: false,
    delay: 1000,
    init: function() {
        var me = this;
        $.ajaxSetup({
            complete: function() {
                me.inicializarTemporizador();
            },
            statusCode: {
                302: function() {
                    Mensajes.borrarMensajes();
                    me.detenerTemporizador();
                    alert("Lo sentimos, la sesi\xF3n ha terminado");
                    Global.salir();
                }
            }
        });
    },
    inicializarTemporizador: function() {
        this.tiempoRestante = this.tiempoSegSesion;
        this.detenerTemporizador();
        this.iniciarTemporizador();
    },
    detenerTemporizador: function() {
        if (this.estaCorriendoTemporizador) {
            clearTimeout(this.idTemporizador);
            this.estaCorriendoTemporizador = false;
        }
    },
    iniciarTemporizador: function() {
        if (this.tiempoRestante === 180) {
            Mensajes.mensajeInformativo("Su sesi&oacute;n terminar&aacute; " +
                    "en 3 minutos, para continuar es necesario que realice " +
                    "alguna operaci&oacute;n");
        }
        if (this.tiempoRestante <= 0) {
            this.detenerTemporizador();
            alert("Lo sentimos, la sesi\xF3n ha terminado");
            Global.salir();
        } else {
            this.tiempoRestante = this.tiempoRestante - 1;
            this.estaCorriendoTemporizador = true;
            this.idTemporizador = self.setTimeout("TemporizadorSesion.iniciarTemporizador()", this.delay);
        }
    }
};