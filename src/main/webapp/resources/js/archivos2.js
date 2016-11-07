$(document).ready(function () {

	handler();

});

var uploadButton = $('<button/>').addClass('btn btn-primary')
		.prop('disabled', true).text('Processing...').on('click', function() {
			var $this = $(this), data = $this.data();
			$this.off('click').text('Abort').on('click', function() {
				$this.remove();
				data.abort();
			});
			data.submit().always(function() {
				$this.remove();
			});
		});


function handler(){
	
    $('#fileupload').fileupload({
        dataType: 'json',
        dataType: 'json',
        autoUpload: false,
        //acceptFileTypes: /(\.|\/)(pdf|tif)$/i,
        done: function (e, data) {
        	$("tr:has(td)").remove();
            $.each(data.result, function (index, file) {
           	
                $("#uploaded-files").append(
                		$('<tr/>')
                		.append($('<td/>').text(file.fileName))
                		.append($('<td/>').text(file.fileSize))
                		.append($('<td/>').text(file.fileType))
                		.append($('<td/>').html("<a onclick='borrarArchivo("+index+")' href='javascript:void(0);'>Borrar</a>"))
                		//.append($('<td/>').html("<a href='restfiles/get/"+index+"'>Click</a>"))
                		)//end $("#uploaded-files").append()
            }); 
        },
        
        progressall: function (e, data) {
	        var progress = parseInt(data.loaded / data.total * 100, 10);
	        $('#progress .bar').css(
	            'width',
	            progress + '%'
	        );
   		},
   		
		dropZone: $('#dropzone')
    }).on('fileuploadadd', function (e, data) {
        
    	
        $.each(data.files, function (index, file) {
             	
           	if (!index) {
           		var fsize = (file.size / 1024) + " Kb";
                $("#uploaded-files").append(
                		$('<tr/>')
                		.append($('<td/>').text(file.name))
                		.append($('<td/>').text(fsize))
                		.append($('<td/>').text(file.type))
                		.append($('<td/>').html(uploadButton.clone(true).data(data)))
                		.append($('<td/>').html("<a onclick='borrarArchivo("+index+")' href='javascript:void(0);'>Borrar</a>"))
                		//.append($('<td/>').html("<a href='restfiles/get/"+index+"'>Click</a>"))
                		);//end $("#uploaded-files").append()
            }

        }).on('fileuploadprocessalways', function (e, data) {
        var index = data.index,
            file = data.files[index],
            node = $(data.context.children()[index]);
        if (file.preview) {
            node
                .prepend('<br>')
                .prepend(file.preview);
        }
        if (file.error) {
            node
                .append('<br>')
                .append($('<span class="text-danger"/>').text(file.error));
        }
        if (index + 1 === data.files.length) {
            data.context.find('button')
                .text('Upload')
                .prop('disabled', !!data.files.error);
        }
    })   	
    	
    	
    	
    	data.context = $('<div/>').appendTo('#files');
        
        
        /*$.each(data.files, function (index, file) {
            var node = $('<p/>')
                    .append($('<span/>').text(file.name));
            if (!index) {
                node
                    .append('<br>')
                    .append(uploadButton.clone(true).data(data));
            }
            node.appendTo(data.context);
        });*/
    })
    
    
    $('#slTypeFile').on('hidden.bs.select', function (e) {
    	var type = $('#slTypeFile').selectpicker('val');
    	$("#panel-files").show();
    	seleccionarTipoArchivo(type);
    });    

    


	$("#btnIniciarFoliador").click(function() {
		iniciarFoliador();
	});   
	
	$("#btnCancelarUpload").click(function() {
		cancelarUpload();
	});  	
	
		
	
}


function borrarArchivo(idx) {
    //ocultarMensajes();

    $.ajax({
        url: "borrarArchivo.json",
        type: "GET",
        dataType: "json",
        data: { index: idx}, // parameters
        async: false,
        beforeSend: function() {
            //mostrarMensajeCargando("Por favor espere, cargando información");
        },
        success: function(respuestaJson) {
            
        	$("tr:has(td)").remove();
            $.each(respuestaJson, function (index, file) {
                $("#uploaded-files").append(
                		$('<tr/>')
                		.append($('<td/>').text(file.fileName))
                		.append($('<td/>').text(file.fileSize))
                		.append($('<td/>').text(file.fileType))
                		.append($('<td/>').html("<a onclick='borrarArchivo("+index+")' href='javascript:void(0);'>Borrar</a>"))
                		
                		)//end $("#uploaded-files").append()
            }); 
        },
        error: function() {
            //ocultarMensajes();
            //mostrarMensajeError("Ocurri&oacute; un error al consultar Ejecutivos");
        }
    });
}



function seleccionarTipoArchivo(tipoArchivo) {
    //ocultarMensajes();

    $.ajax({
        url: "seleccionarTipoArchivo.json",
        type: "GET",
        dataType: "json",
        data: { tipo: tipoArchivo}, // parameters
        async: false,
        beforeSend: function() {
            //mostrarMensajeCargando("Por favor espere, cargando información");
        },
        success: function(respuestaJson) {

        },
        error: function() {
            //ocultarMensajes();
            //mostrarMensajeError("Ocurri&oacute; un error al consultar Ejecutivos");
        }
    });
}


function cancelarUpload() {
    //ocultarMensajes();

    $.ajax({
        url: "cancelarUpload.json",
        type: "GET",
        dataType: "json",
        async: false,
        beforeSend: function() {
            //mostrarMensajeCargando("Por favor espere, cargando información");
        },
        success: function(respuestaJson) {
        	$("tr:has(td)").remove();
        },
        error: function() {
            //ocultarMensajes();
            //mostrarMensajeError("Ocurri&oacute; un error al consultar Ejecutivos");
        }
    });
}

function iniciarFoliador() {
    location.href = $("#contextPath").val() + "/iniciaFoliador.htm";
}
