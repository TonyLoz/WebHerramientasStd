<script
	src="${pageContext.request.contextPath}/resources/js/bitacora.js"
	type="text/javascript"></script>
<div id="box_wrap">

	<section id="abovecontent" class="grey_section">
		<div class="container">
			<div class="row">
				<div class="block col-sm-12">
					<ul class="breadcrumb">
						<li><a href="#" class="pathway">Home</a></li>
						<li><span>Bitacora</span></li>
					</ul>
				</div>
			</div>
		</div>
	</section>


	<section id="middle" class="">

		<div class="container">

			<div class="row">
				<div class="col-sm-12 text-center">
					<h2 class="block-header">Bitacora</h2>
				</div>
			</div>
			<div class="row">

				<div class="col-sm-12">
					<div class="text-center"></div>
					<div class="content-area" id="primary">
						<div role="main" class="site-content" id="content">

							<div id="panel-bitacora-admin">
								<table id="table-bitacora" class="display table table-striped table-hover table-condensed" style="width:100%" >
									<thead>
										<tr>
											<th>Fecha</th>
											<th>Usuario</th>
											<th>Operacion</th>
											<th>Comentarios</th>
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



