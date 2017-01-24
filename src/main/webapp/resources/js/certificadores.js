var tabla;

$(document).ready(function() {
	
	handler();

});


function handler() {
	$('#nuevo-certificador-form').validator();
	
	initTabla();
	
	$("#btnGuardar").click(function() {
		
		var nombre = $("#name").val();
		
		guardarCertificador(nombre);
	});
	
	$("#btnUpdCert").click(function() {
		
		var nombre = $("#upd-name").val();
		var idCert = $("#hdnIdCert").val();
		
		hideModalActualizarCertificador();
		
		actualizarCertificador(nombre,idCert, function(){
			actualizarTablaCertificador();
		});
	});		
	
}


function mostrarPanelAlta() {
	$("#panel-certificador-alta").show();
	$("#panel-certificador-admin").hide();
}
function mostrarPanelAdmin() {
	
	actualizarTablaCertificador();
	
	$("#panel-certificador-alta").hide();
	$("#panel-certificador-admin").show();

}


function initTabla() {

	var columns = [ {
		data : 'nombre'
	},{
		render : function(data, type, full, meta) {
			var ac = "";
			if(full.seleccionado===1){
				ac="<span>Si</span>"
			}else{
				ac="<span>No</span>"
			}
			return ac;
		}
	}, {
		render : function(data, type, full, meta) {

			return '<a href="#" onclick="borrarCertificadorConfirmacion('+full.idCertificador+');return false;">Borrar</a>';
		}
	},
	{
		render : function(data, type, full, meta) {
			
			return '<a href="#" onclick="modalActualizarCertificador('+full.idCertificador+',\''+full.nombre+'\');return false;">Actualizar</a>';
		}
	}

	];

	tabla = $('#table-certificador').DataTable({
		ajax : {
			url : 'consultarCertificadores.json',
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


function actualizarTablaCertificador(){
	
	tabla.ajax.reload();
	
}


function modalActualizarCertificador(idCert, nombre, callBack) {

	$("#upd-name").val(nombre);
    $("#hdnIdCert").val(idCert);
    $('#modal-update-certificador').modal({backdrop: 'static', keyboard: false});

}

function hideModalActualizarCertificador() {

	$("#upd-name").val("");
    $("#hdnIdCert").val("");
    $('#modal-update-certificador').modal('hide');

}

function guardarCertificador(nombre) {
	
	$.ajax({
		url : "guardarCertificador.json",
		type : "POST",
		data:{
			nombre:nombre
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
			Mensajes.mensajeError("Ocurri&oacute; un error al guardar certificador");

		}
	});

}


function actualizarCertificador(nombre,idCert, callBack) {
	
	$.ajax({
		url : "actualizarCertificadores.json",
		type : "POST",
		data:{
			nombre:nombre,
			idCert:idCert
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
				
				hideModalActualizarCertificador();
				
				if (respuestaJson.estatus === "preventivo") {
					Mensajes.mensajeAlerta(respuestaJson.mensaje);
				} else {
					Mensajes.mensajeError(respuestaJson.mensaje);
				}
			}

		},
		error : function() {
			Mensajes.borrarMensajes();
			Mensajes.mensajeError("Ocurri&oacute; un error al actualizar certificador");
			
			hideModalActualizarCertificador();
			

		}
	});

}


function borrarCertificadorConfirmacion(idCert){
	
    bootbox.confirm({
        message: "¿Deseas borrar certificador?",
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
            console.log('callback borrar certificador: ' + result);
            borrarCertificador(idCert, actualizarTablaCertificador);
            
        }
    });	
	
}


function borrarCertificador(idCert, callBack) {
	
	$.ajax({
		url : "borrarCertificador.json",
		type : "POST",
		data:{
			idCert:idCert
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
					.mensajeError("Ocurri&oacute; un error al borrar certificador");

		}
	});

}


function consultarCertificadores(callBack) {
	// ocultarMensajes();

	$
			.ajax({
				url : "actualizarCertificadores.json",
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

						listaCertificadores = respuestaJson.lista;

						$('#table-certificador').clear().rows.add(dataSet2).draw();

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
							.mensajeError("Ocurri&oacute; un error al consultar certificadores");
				}
			});
}