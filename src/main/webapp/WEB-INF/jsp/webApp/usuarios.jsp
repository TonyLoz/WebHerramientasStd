<script
	src="${pageContext.request.contextPath}/resources/js/usuarios.js"
	type="text/javascript"></script>
<div id="box_wrap">

	<section id="abovecontent" class="grey_section">
		<div class="container">
			<div class="row">
				<div class="block col-sm-12">
					<ul class="breadcrumb">
						<li><a href="#" class="pathway">Home</a></li>
						<li><span>Usuarios</span></li>
					</ul>
				</div>
			</div>
		</div>
	</section>


	<section id="middle" class="">

		<div class="container">

			<div class="row">

				<aside class="col-sm-3">


					<div class="list-group block">
						<a href="#" onclick="mostrarPanelAlta();return false;" class="list-group-item">Alta de Usuarios</a> 
						<a href="#" onclick="mostrarPanelAdmin();return false;" class="list-group-item">Administración</a> 

					</div>

				</aside>

				<div class="col-sm-9">
					<div class="text-center"></div>
					<div class="content-area" id="primary">
						<div role="main" class="site-content" id="content">


							<div id="panel-usuarios-alta">
								<div class="row">
									<div class="col-sm-12 text-center">
										<h2 class="block-header">Alta de Usuarios</h2>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="contact-form">
											<form id="nuevo-usuario-form" class="contact-form" data-toggle="validator">
												<p class="contact-form-name">
													<label for="name">Nombre <span class="required">*</span></label>
													<input type="text" aria-required="true" size="30" value=""
														name="name" id="name" class="form-control"
														placeholder="Nombre">
												</p>
												<p class="contact-form-email">
													<label for="email">Correo <span class="required">*</span></label>
													<input type="email" aria-required="true" size="30" value=""
														name="email" id="email" class="form-control"
														placeholder="Correo electronico">
												</p>
												<p class="contact-form-perfil">
													<label for="ltPerfil">Perfil <span class="required">*</span></label>
													<select class="form-control"
														aria-required="true" name="ltPerfil" id="ltPerfil">
													</select>
												</p>
												<p
													class="contact-form-submit text-center vertical-margin-60">
													<input type="button" value="Guardar" id="btnGuardar"
														name="btnGuardar" class="theme_btn">
												</p>
											</form>
										</div>
									</div>

								</div>

							</div>

							<div id="panel-usuarios-admin" style="display: none;">
								<table id="table-usuarios" class="display table table-striped table-hover table-condensed" style="width:100%" >
									<thead>
										<tr>
											<th>Nombre</th>
											<th>Correo</th>
											<th>Perfil</th>
											<th></th>
											<th></th>
										</tr>
									</thead>
								</table>
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



       <!-- Modal tracking-->
        <div id="modal-update-user" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Actualizar Usuario <span id="headerProjectTrackingModal"></span> </h4>
                    </div>
                    <div class="modal-body">
                        
                        <input type="hidden" id="hdnIdUser" />
                        


						<form id="actualizar-usuario-form" class="contact-form" data-toggle="validator">
							<p class="contact-form-name">
								<label for="upd-name">Nombre <span class="required">*</span></label>
								<input type="text" aria-required="true" size="30" value=""
									name="upd-name" id="upd-name" class="form-control"
									placeholder="Nombre">
							</p>
							<p class="contact-form-email">
								<label for="upd-email">Correo <span class="required">*</span></label>
								<input type="email" aria-required="true" size="30" value=""
									name="upd-email" id="upd-email" class="form-control"
									placeholder="Correo electronico">
							</p>

						</form>


 

                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary theme_btn" id='btnUpdUser' title='Actualizar usuario'>Actualizar&nbsp;<i class="fa fa-refresh"></i></button>

                    </div>
                </div>

            </div>
        </div>



</div>
<!-- EOF #box_wrap -->



