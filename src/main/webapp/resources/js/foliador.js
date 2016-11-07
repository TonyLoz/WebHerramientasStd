var tablaArchivos;
var listaArchivos;
$(document).ready(function() {

	handler();
	consultarArchivos();
});

function handler() {

	$("input[name='fMargenV']").TouchSpin({
		min : 0,
		max : 10,
		step : 0.1,
		decimals : 2,
		// boostat: 5,
		maxboostedstep : 2,
		verticalbuttons : true
	});

	$("input[name='fMargenH']").TouchSpin({
		min : 0,
		max : 10,
		step : 0.1,
		decimals : 2,
		// boostat: 5,
		maxboostedstep : 2,
		verticalbuttons : true
	});

	$('#fColor').colorpicker();
}

function consultarArchivos() {
	// ocultarMensajes();

	$.ajax({
		url : "consultarArchivos.json",
		type : "GET",
		dataType : "json",
		async : false,
		beforeSend : function() {
			// mostrarMensajeCargando("Por favor espere, cargando información");
		},
		success : function(respuestaJson) {
			// ocultarMensajes();
			if (respuestaJson.estatus === "ok") {

				listaArchivos = respuestaJson.lista;

				initTable(listaArchivos);

				// ocultarMensajes();
			} else {
				if (respuestaJson.estatus === "preventivo") {
					// mostrarMensajePreventivo(respuestaJson.mensaje);
				} else {
					// mostrarMensajeError(respuestaJson.mensaje);
				}
			}

		},
		error : function() {
			// ocultarMensajes();
			// mostrarMensajeError("Ocurri&oacute; un error al consultar
			// Ejecutivos");
		}
	});
}

function initTable(listaArchivos) {

	var cols = [ {
		data : "fileName",
		type : 'text',
		readOnly : true
	}, {
		data : "flagFoliar",
		type : 'checkbox'
	}, {
		data : "indexColectivo",
		type : 'numeric',
		format : '0'
	}, {
		data : "flagVistaPrevia",
		type : 'checkbox'
	}, {
		data : "flagCertFinal",
		type : 'checkbox'
	}, {
		data : "flagCertTodo",
		type : 'checkbox'
	}

	];

	var headers = [ "Archivo", "Foliar", "Colectivo", "Vista Previa",
			"Certificar Final", "Certificar Todo" ];

	var config = {
		data : listaArchivos,
		columns : cols,
		colHeaders : headers,
		height : 800,
		rowHeaders : true,
		stretchH : 'all',
		// contextMenu: true,
		className : "htCenter htMiddle",
		tableClassName: "table table-hover table-striped table-bordered",
		// multiSelect:false,
		fixedColumnsLeft : 1,
		maxRows : listaArchivos.length,
		maxCols : 7,
		// sortIndicator: true,
		// columnSorting: true,
		// manualRowResize: true,
		manualColumnResize : true,
		afterSelectionEndByProp : function(rowNumber, property) {

		},
		afterChange : function(changesArray, sourceString) {

			if (changesArray !== null) {

				var traslateIndex = false;

				if (changesArray.length > 0) {
					if (typeof changesArray[0].length === 'undefined') {
						var chItem = changesArray;
						changesArray = [];
						changesArray.push(chItem);
						traslateIndex = false;
					} else {
						traslateIndex = true;
					}
				}

				for (j = 0; j < changesArray.length; j++) {
					var item = changesArray[j];
					var rowNumber = item[0];
					var field = item[1];
					var value = item[3];

					if (typeof rowNumber !== 'undefined' && rowNumber !== null) {

						var physicalIndex;

						if (traslateIndex) {
							var logicalIndex = rowNumber;
							if (logicalIndex < containerGrid.sortIndex.length) {
								physicalIndex = containerGrid.sortIndex[logicalIndex][0];
							} else {
								physicalIndex = logicalIndex;
							}
						} else {
							physicalIndex = rowNumber;
						}

						// var cuid =
						// containerGrid.getData()[physicalIndex].uid;

					}

				}// end-for 5

			}
		}// end function

	};

	var ex = document.getElementById('tabla-archivos-container');
	tablaArchivos = new Handsontable(ex, config);
	
	/*$('.htCore').each(function() {
		
		tableInstance = this;
		Handsontable.Dom.addClass(tableInstance, 'table');
		Handsontable.Dom.addClass(tableInstance, 'table-hover');
		Handsontable.Dom.addClass(tableInstance, 'table-striped');
		Handsontable.Dom.addClass(tableInstance, 'table-bordered');		
		
	});*/
	
	  table = ex.querySelectorAll('table');
	  
	  function findAncestor(el, cls) {
		  while ((el = el.parentElement) && !el.classList.contains(cls)){
		    return el;
		  }

		}

		for (i = 0, len = table2.length; i < len; i++) {
		  var tableInstance = table[i];
		  var isMaster = !!findAncestor(tableInstance, 'ht_master');
		  Handsontable.Dom.addClass(tableInstance, 'table');
		  Handsontable.Dom.addClass(tableInstance, 'table-hover');
		  Handsontable.Dom.addClass(tableInstance, 'table-striped');
		  if (isMaster) {
		    Handsontable.Dom.addClass(tableInstance, 'table-bordered');
		  }
		}	  

}