<link
	href="${pageContext.request.contextPath}/resources/css/dropzone.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/archivos.js"
	type="text/javascript"></script>

<section id="abovecontent" class="grey_section">
	<div class="container">
		<div class="row">
			<div class="block col-sm-12">
				<ul class="breadcrumb">
					<li><a href="#" class="pathway">Home</a></li>
					<li><span>Foliador de Documentos</span></li>
				</ul>
			</div>
		</div>
	</div>
</section>

<section id="middle" class="">

	<div class="container">

		<div class="row">


			<div class="col-sm-12">
				<div class="text-center"></div>
				<div class="content-area" id="primary">
					<div role="main" class="site-content" id="content">

						<div class="row">
							<div class="col-sm-12 text-center">
								<h2 class="block-header">Subir archivos</h2>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">

								<div>
									<div class="row">
									  <div class="col-xs-5">
									    <div class="form-group">
									      <select id="slTypeFile" class="selectpicker form-control" title="Tipo de archivo...">
									        <option>PDF</option>
									        <option>TIFF</option>
									      </select>
									    </div>
									  </div>
									</div>
									
									<div id="panel-files" style="display: none;">
									
								    <span class="btn btn-success fileinput-button">
								        <i class="glyphicon glyphicon-plus"></i>
								        <span>Seleccionar archivos...</span>
								        <!-- The file input field used as target for the file upload widget -->
								        <input id="fileupload" type="file" name="files[]" multiple data-url="upload.json">
								    </span>
    
					                <button id="btnIniciarFoliador" type="submit" class="btn btn-primary start">
					                    <i class="glyphicon glyphicon-upload"></i>
					                    <span>Iniciar con el foliador</span>
					                </button>
					                <button id="btnCancelarUpload" type="reset" class="btn btn-warning cancel">
					                    <i class="glyphicon glyphicon-ban-circle"></i>
					                    <span>Cancelar operacion</span>
					                </button>
					                

									<div id="dropzone" class="fade well">Arrastrar archivos aqui</div>
																		
									</div>
									


									<div id="progress" class="progress">
										<div class="bar" style="width: 0%;"></div>
									</div>

									<table id="uploaded-files" class="table">
										<tr>
											<th>Nombre archivo</th>
											<th>Tamaño archivo</th>
											<th>Tipo archivo</th>
											<th>Subir</th>
											<th>Borrar</th>
										</tr>
									</table>

								</div>


							</div>

						</div>


					</div>
					<!-- #content -->
				</div>
			</div>


		</div>
	</div>
</section>


	<section id="copyright" class="dark_section">
		<div class="container">
			<div class="row">

				<div class="col-sm-6">
					<p>
						&copy; Copyright 2016.<a href="#" target="_blank"><img src="${pageContext.request.contextPath}/resources/img/flama.png" style="width: 22px;" border="0">Santander</a>
					</p>
				</div>

				<div class="col-sm-6">
					<!--div class="block widget_nav_menu">
						<ul class="nav menu">
							<li><a href="home.html">Home</a></li>
						</ul>
					</div-->
				</div>

			</div>
		</div>
	</section>
