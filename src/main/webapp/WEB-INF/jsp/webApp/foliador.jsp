<script
	src="${pageContext.request.contextPath}/resources/js/foliador.js"
	type="text/javascript"></script>


<div id="box_wrap">

	<section id="abovecontent" class="grey_section">
		<div class="container">
			<div class="row">
				<div class="block col-sm-12">
					<ul class="breadcrumb">
						<li><a href="#" class="pathway">Home</a></li>
						<li><span>Foliador</span></li>
					</ul>
				</div>
			</div>
		</div>
	</section>


	<section id="middle" class="">

		<div class="container">

			<div class="row">



				<div class="col-sm-9">
					<div class="text-center"></div>
					<div class="content-area" id="primary">
						<div role="main" class="site-content" id="content">

							<div class="row">
								<div class="col-sm-12 text-center">
									<h2 class="block-header">Foliador de documentos</h2>
								</div>
							</div>
							<div class="row">
								<button id="btnProcessFile" type="button" class="btn btn-warning">Procesar Archivos</button>
							</div>
							<div class="row">
								<div class="col-sm-12">
								
									<div id="tabla-archivos-container"></div>
									
								</div>

							</div>


						</div>
						<!-- #content -->
					</div>
				</div>

				<aside class="col-sm-3">

					<div>
						<div class="form-group">
							<label for="fPagInit">¿Desde que página quieres numerar?:</label>
							<input type="text" class="form-control" id="fPagInit">
						</div>
						<div class="form-group">
							<label for="fIndex">Empezar con el número:</label> <input
								type="text" class="form-control" id="fIndex">
						</div>
						<div class="form-group">
							<label for="fMask">Mascara:</label> <input type="text"
								class="form-control" id="fMask">
						</div>
						<div class="form-group">
							<label for="fCeros">Ceros:</label> <input type="text"
								class="form-control" id="fCeros">
						</div>
						
						<div class="form-group">
							<label for="fPosVertical">Posicion Vertical:</label> 
							<select
								class="form-control" id="fPosVertical">
								<option>Arriba</option>
								<option>Abajo</option>
							</select>
						</div>
						
						<div class="form-group">
						<label for="fMargenV">Margen Vertical:</label> 
 						<input id="fMargenV" type="text" value="2" name="fMargenV">
 						</div>
 						
						<div class="form-group">
							<label for="fPosHorizontal">Posicion Horizontal:</label> 
							<select
								class="form-control" id="fPosHorizontal">
								<option>Derecha</option>
								<option>Izquierda</option>
							</select>
						</div> 
						
						<div class="form-group">
						<label for="fMargenH">Margen Horizontal:</label> 
 						<input id="fMargenH" type="text" value="2" name="fMargenH">
 						</div>												

						<div class="form-group">
							<label for="fTipografia">Tipografía:</label> 
							<select
								class="form-control" id="fTipografia">
							</select>
						</div>

					  <div class="form-group">
					  	<label for="fSize">Tamaño:</label> 
					    <div class="input-group">
					      <input type="text" class="form-control" id="fSize">
					      <div class="input-group-addon">pt</div>
					    </div>
					  </div>
					  
						<div class="form-group">
							<label for="fColor">Color:</label> 
							
							<div id="fColor" class="input-group colorpicker-component">
							    <input type="text" value="#00AABB" class="form-control" />
							    <span class="input-group-addon"><i></i></span>
							</div>							

						</div>

						<button id="btnGuardarDefault" type="button" class="btn btn-primary">Guardar Como Default</button>
						<button id="btnGuardarTMP" type="button" class="btn btn-warning">Aplicar Temporalmente</button>

					</div>


				</aside>


			</div>
		</div>
	</section>


	<section id="copyright" class="dark_section">
		<div class="container">
			<div class="row">

				<div class="col-sm-6">
					<p>
						&copy; Copyright 2016.<a href="#" target="_blank"><img
							src="${pageContext.request.contextPath}/resources/img/flama.png"
							style="width: 22px;" border="0">Santander</a>
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



</div>
<!-- EOF #box_wrap -->