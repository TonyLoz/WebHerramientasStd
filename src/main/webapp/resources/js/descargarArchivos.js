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

			//return "";
			//return '<a href="download.do?nombre='+nombreArchivo+'" target="_blank">Descargar</a>';
			
			return '<a target="_blank" href="download.do?nombre='+full.fileName+'" >Descargar</a>';
			
			//return '<a href="#" onclick="descargarArchivo(\''+full.fileName+'\');return false;">Descargar</a>';
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


function descargarArchivo(nombreArchivo){

    /*$.ajax({
        url: 'download.do?nombre='+nombreArchivo,
        success: function(data) {
            var blob=new Blob([data]);
            var link=document.createElement('a');
            link.href=window.URL.createObjectURL(blob);
            link.download="Dossier_"+new Date()+".pdf";
            link.click();
        }
    });*/	
	
	/*$.ajax({
		url : "download.do",
		type : "GET",
		dataType: "application/pdf",
		data:{nombre:nombreArchivo},
		success: function(data, textStatus, jqXHR) {
		    window.open(escape(data), "Title", "");
		}		
		
	});*/
	
	//$('<iframe src="download.do?nombre='+nombreArchivo+'></iframe>').appendTo('body').hide();
    
	$('a#someID').attr({target: '_blank', 
        href  : 'http://localhost/directory/file.pdf'});	
	
	$.ajax({
	    type: "GET",
	    url: 'download.do?',
	    data:{nombre:nombreArchivo},
	    success: function(data, textStatus, jqXHR) {
	    	
	        var pdfWin= window.open("data:application/pdf;base64, " + base64EncodedPDF, '', 'height=650,width=840');
	        // some actions with this win, example print...
	    },
	    error: function(jqXHR) {
	        showError("...");
	    }
	});	
	
	
    /*$.download(
    	    'download.do',
    	    'filename='+nombreArchivo,'GET'
    	);*/    
    
	
}

jQuery.download = function(url, data, method) {
    //url and data options required
    if (url && data) {
        //data can be string of parameters or array/object
        data = typeof data == 'string' ? data : jQuery.param(data);
        //split params into form inputs
        var inputs = '';
        jQuery.each(data.split('&'), function() {
            var pair = this.split('=');
            inputs += '<input type="hidden" name="' + pair[0] +
                '" value="' + pair[1] + '" />';
        });
        //send request
        jQuery('<form action="' + url +
                '" method="' + (method || 'post') + '">' + inputs + '</form>')
            .appendTo('body').submit().remove();
    };
};