var contextPath = null;
$(document).ready(function() {
    contextPath = $("#context-path").val();
    Login.initLogin();
    Login.invalidarSesion();
});
var Login = {
    loginForm: '.form-signin',
    contextPath: null,
    initLogin: function() {
        var me = this;
        $(this.loginForm).submit(function() {
            var result = me.validarFormulario();
            if (result) {
                var btn = $(me.loginForm + ' > button[type="submit"]');
                btn.button('loading');
            }
            return result;
        })
        contextPath = $("#context-path").val();
    },
    validarFormulario: function() {
        $(this.loginForm).find('.required:input:enabled').each(function() {
            if (!($(this).is(':checkbox') || $(this).is(':radio'))) {
                if ($(this).val().length === 0) {
                    return false;
                }
            }
        });
        return true;
    },
    invalidarSesion: function(callbacks) {
        $.ajax({
            type: "POST",
            dataType: "text",
            url: contextPath + '/invalidarSesion.htm',
            cache: false,
            success: function(data) {
                if (callbacks) {
                    callbacks.success(data);
                }
            },
            error: function() {
                if (callbacks) {
                    callbacks.error();
                }
            }
        });
    }
};