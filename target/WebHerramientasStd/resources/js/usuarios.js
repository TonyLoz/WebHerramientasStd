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
		//alert("hola");
		//nuevo-usuario-form
		
		guardarUsuario(nombre,email,perfil);
	});

}

function mostrarPanelAlta() {
	$("#panel-usuarios-alta").show();
	$("#panel-usuarios-admin").hide();
}
function mostrarPanelAdmin() {

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

			return '<a href="' + full.idUsuario + '">Borrar</a>';
		}
	}
	

	];

	$('#table-usuarios').DataTable({
		ajax : {
			url : 'consultarUsuarios.json',
			dataSrc : 'lista'
		},
		columns : columns,
		language : dtLanguage
	});
}

function guardarUsuario(nombre,correo,perfil) {
	
	$.ajax({
		url : "guardarUsuario.json",
		type : "POST",
		data:{
			nombre:nombre,
			correo:correo,
			perfil:perfil,
		},
		beforeSend : function() {
			Mensajes.mensajeCargando("Por favor espere...", {
				autoClose : false
			});
		},
		success : function(respuestaJson) {
			Mensajes.borrarMensajes();
			if (respuestaJson.estatus === "ok") {

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
			Mensajes.borrarMensajes();
			Mensajes
					.mensajeError("Ocurri&oacute; un error al guardar usuario");

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