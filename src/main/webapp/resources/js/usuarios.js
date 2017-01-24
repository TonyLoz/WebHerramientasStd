var tabla;

$(document).ready(function() {
	handler();
	consultarPerfiles();

});

function handler() {
	

	$('#nuevo-usuario-form').validator();
	
	initTabla();

	$("#btnGuardar").click(function() {
		
		var nombre = $("#name").val();
		var email = $("#email").val();
		var perfil = $("#ltPerfil").val();
		
		guardarUsuario(nombre,email,perfil);
	});

	
	$("#btnUpdUser").click(function() {
		
		var nombre = $("#upd-name").val();
		var email = $("#upd-email").val();
		var idUser = $("#hdnIdUser").val();
		
		hideModalActualizarUsuario();
		
		actualizarUsuario(nombre,email,idUser, function(){
			actualizarTablaUsuarios();
		});
	});	
	
	

}

function mostrarPanelAlta() {
	$("#panel-usuarios-alta").show();
	$("#panel-usuarios-admin").hide();
}
function mostrarPanelAdmin() {
	
	actualizarTablaUsuarios();
	
	// consultarUsuarios(function(){
	$("#panel-usuarios-alta").hide();
	$("#panel-usuarios-admin").show();

	// });

}

function initTabla() {

	var columns = [ {
		data : 'nombre'
	}, {
		data : 'correo'
	}, {
		data : 'perfil.nombre'
	}, {
		render : function(data, type, full, meta) {

			return '<a href="#" onclick="borrarUsuarioConfirmacion('+full.idUsuario+');return false;">Borrar</a>';
		}
	},
	{
		render : function(data, type, full, meta) {
			
			return '<a href="#" onclick="modalActualizarUsuario('+full.idUsuario+',\''+full.nombre+'\',\''+full.correo+'\');return false;">Actualizar</a>';
		}
	}

	];

	tabla = $('#table-usuarios').DataTable({
		ajax : {
			url : 'consultarUsuarios.json',
			dataSrc : 'lista'
		},
		columns : columns,
		language : dtLanguage,
		buttons : [ {
			text : 'Refrescar',
			action : function(e, dt, node, config) {
				dt.ajax.reload();
			}
		} ]
	});
}


function actualizarTablaUsuarios(){
	
	tabla.ajax.reload();
	
	/*
	 * $('#table-usuarios').DataTable( { ajax: "consultarUsuarios.json" } );
	 */	
	
}

function modalActualizarUsuario(idUser, nombre, email, callBack) {

	$("#upd-name").val(nombre);
	$("#upd-email").val(email);
    $("#hdnIdUser").val(idUser);
    $('#modal-update-user').modal({backdrop: 'static', keyboard: false});

}

function hideModalActualizarUsuario() {

	$("#upd-name").val("");
    $("#hdnIdUser").val("");
    $('#modal-update-user').modal('hide');

}

function borrarUsuarioConfirmacion(idUsuario){
	
	

    bootbox.confirm({
        message: "¿Deseas borrar usuario?",
        buttons: {
            confirm: {
                label: 'Si',
                className: 'btn-success'
            },
            cancel: {
                label: 'No',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            console.log('callback borrar usuario: ' + result);
            borrarUsuario(idUsuario, actualizarTablaUsuarios);
            
        }
    });	
	
	
	
	
	
	
}



function guardarUsuario(nombre,correo,perfil) {
	
	$.ajax({
		url : "guardarUsuario.json",
		type : "POST",
		data:{
			nombre:nombre,
			correo:correo,
			perfil:perfil
		},
		beforeSend : function() {
			Mensajes.mensajeCargando("Por favor espere...", {
				autoClose : false
			});
		},
		success : function(respuestaJson) {
			Mensajes.borrarMensajes();
			if (respuestaJson.estatus === "ok") {

				Mensajes.mensajeOk(respuestaJson.mensaje);
			} else {
				if (respuestaJson.estatus === "preventivo") {
					Mensajes.mensajeAlerta(respuestaJson.mensaje);
				} else {
					Mensajes.mensajeError(respuestaJson.mensaje);
				}
			}

		},
		error : function() {
			Mensajes.borrarMensajes();
			Mensajes
					.mensajeError("Ocurri&oacute; un error al guardar usuario");

		}
	});

}



function actualizarUsuario(nombre,correo,idUsuario, callBack) {
	
	$.ajax({
		url : "actualizarUsuario.json",
		type : "POST",
		data:{
			nombre:nombre,
			correo:correo,
			idUsuario:idUsuario,
		},
		beforeSend : function() {
			Mensajes.mensajeCargando("Por favor espere...", {
				autoClose : false
			});
		},
		success : function(respuestaJson) {
			Mensajes.borrarMensajes();
			if (respuestaJson.estatus === "ok") {

				Mensajes.mensajeOk(respuestaJson.mensaje);
				
		        if (typeof callBack === 'function') {
		            callBack();
		        }				
				
			} else {
				hideModalActualizarUsuario();
				if (respuestaJson.estatus === "preventivo") {
					Mensajes.mensajeAlerta(respuestaJson.mensaje);
				} else {
					Mensajes.mensajeError(respuestaJson.mensaje);
				}
				
			}

		},
		error : function() {
			Mensajes.borrarMensajes();
			Mensajes.mensajeError("Ocurri&oacute; un error al actualizar usuario");
			hideModalActualizarUsuario();

		}
	});

}


function borrarUsuario(idUsuario, callBack) {
	
	$.ajax({
		url : "borrarUsuario.json",
		type : "POST",
		data:{
			idUsuario:idUsuario,
		},
		beforeSend : function() {
			Mensajes.mensajeCargando("Por favor espere...", {
				autoClose : false
			});
		},
		success : function(respuestaJson) {
			Mensajes.borrarMensajes();
			if (respuestaJson.estatus === "ok") {
				
				Mensajes.mensajeOk(respuestaJson.mensaje);
				
		        if (typeof callBack === 'function') {
		            callBack();
		        }					
				
			} else {
				if (respuestaJson.estatus === "preventivo") {
					Mensajes.mensajeAlerta(respuestaJson.mensaje);
				} else {
					Mensajes.mensajeError(respuestaJson.mensaje);
				}
			}

		},
		error : function() {
			Mensajes.borrarMensajes();
			Mensajes
					.mensajeError("Ocurri&oacute; un error al borrar usuario");

		}
	});

}

function consultarPerfiles() {
	// ocultarMensajes();

	$
			.ajax({
				url : "consultarPerfiles.json",
				type : "GET",
				dataType : "json",
				async : false,
				beforeSend : function() {
					Mensajes.mensajeCargando(
							"Por favor espere, cargando información...", {
								autoClose : false
							});
				},
				success : function(respuestaJson) {
					Mensajes.borrarMensajes();
					if (respuestaJson.estatus === "ok") {

						listaPerfiles = respuestaJson.lista;

						$.each(listaPerfiles, function(id, value) {
							$("#ltPerfil").append(
									'<option value="' + value.id + '">'
											+ value.nombre + '</option>');
						});

						Mensajes.borrarMensajes();
					} else {
						if (respuestaJson.estatus === "preventivo") {
							Mensajes.mensajeAlerta(respuestaJson.mensaje);
						} else {
							Mensajes.mensajeError(respuestaJson.mensaje);
						}
					}

				},
				error : function() {
					Mensajes
							.mensajeError("Ocurri&oacute; un error al consultar perfiles");
				}
			});
}

function consultarUsuarios(callBack) {
	// ocultarMensajes();

	$
			.ajax({
				url : "consultarUsuarios.json",
				type : "GET",
				dataType : "json",
				async : false,
				beforeSend : function() {
					Mensajes.mensajeCargando(
							"Por favor espere, cargando información...", {
								autoClose : false
							});
				},
				success : function(respuestaJson) {
					Mensajes.borrarMensajes();
					if (respuestaJson.estatus === "ok") {

						listaUsuarios = respuestaJson.lista;

						$('#table-usuarios').clear().rows.add(dataSet2).draw();

						if (typeof callBack == "function") {
							callBack();
						}

						Mensajes.borrarMensajes();
					} else {
						if (respuestaJson.estatus === "preventivo") {
							Mensajes.mensajeAlerta(respuestaJson.mensaje);
						} else {
							Mensajes.mensajeError(respuestaJson.mensaje);
						}
					}

				},
				error : function() {
					Mensajes
							.mensajeError("Ocurri&oacute; un error al consultar usuarios");
				}
			});
}