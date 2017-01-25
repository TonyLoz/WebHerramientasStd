$(document).ready(function() {
	handler();

});

function handler() {

	initTabla();

}

function initTabla() {

	var columns = [ {
		data : 'fileName'
	}, {
		data : 'fileSize'
	}, {
		render : function(data, type, full, meta) {

			return '<a href="download/'+full.fileName+'">Descargar</a>';
		}
	} ];

	$('#table-archivos').DataTable({
		ajax : {
			url : 'consultarProcesados.json',
			dataSrc : 'lista'
		},
		columns : columns,
		language : dtLanguage
	});
}