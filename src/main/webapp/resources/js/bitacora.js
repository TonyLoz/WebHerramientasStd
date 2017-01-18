$(document).ready(function() {
	handler();

});

function handler() {

	initTabla();

}

function initTabla() {

	var columns = [ {
		data : 'fecha'
	}, {
		data : 'usuario'
	}, {
		data : 'operacion'
	}, {
		data : 'comentarios'
	} ];

	$('#table-bitacora').DataTable({
		ajax : {
			url : 'consultarBitacora.json',
			dataSrc : 'lista'
		},
		columns : columns,
		language : dtLanguage
	});
}