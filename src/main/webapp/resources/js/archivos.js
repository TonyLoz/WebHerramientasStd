$(document).ready(function() {

	handler();

});

function handler() {

	$("#input-22").fileinput({
		// previewFileType: "pdf",
		language : "es",
		allowedFileExtensions : [ "pdf", "PDF" ],
		previewClass : "bg-warning",
		uploadUrl : "upload.json",
		uploadAsync : false,
		maxFileCount : 10,
		previewFileIcon : '<i class="fa fa-file"></i>',
		// allowedPreviewTypes: null, // set to empty, null or false to disable
		// preview for all types
		previewFileIconSettings : {
			'pdf' : '<i class="fa fa-file-pdf-o text-danger"></i>',
		}

	});
	
	//$("#myName").fileinput({'showUpload':false, 'showRemove':false});
	//$("#input-22").fileinput({'showUpload':false, 'showRemove':false});
	
	$('#input-22').on('fileuploaded', function(event, data, previewId, index) {
	    var form = data.form, files = data.files, extra = data.extra,
	        response = data.response, reader = data.reader;
	    console.log('File uploaded triggered');
	    //$(".kv-file-upload").hide();
	});	
	
	$('#input-22').on('fileloaded', function(event, file, previewId, index, reader) {
		
		$(".kv-file-upload").hide();
	    //console.log("fileloaded:" + file);
	});	
	
	$('#input-22').on('filebatchuploadcomplete', function(event, files, extra) {
	    console.log('File batch upload complete');
	});
	
	$('#input-22').on('filebatchuploadsuccess', function(event, files, extra) {
	    console.log('File filebatchuploadsuccess');
	    $('#input-22').fileinput('disable');
	    $("#btnIniciarFol").show();
	});
	
	$('#input-22').on('filebatchuploadsuccess', function(event, files, extra) {
	    console.log('File filebatchuploadsuccess');
	});	
	
	$( "#btnIniciarFol" ).click(function() {
		iniciarFoliador();
		});
}


function iniciarFoliador() {
    location.href = $("#contextPath").val() + "/iniciaFoliador.htm";
}