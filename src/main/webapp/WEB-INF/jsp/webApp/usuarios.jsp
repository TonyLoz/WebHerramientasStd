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
						<a href="#" class="list-group-item">Alta de usuarios</a> <a
							href="#" class="list-group-item">Actualizacion</a> <a href="#"
							class="list-group-item">Borrar</a>
					</div>

				</aside>

				<div class="col-sm-9">
					<div class="text-center"></div>
					<div class="content-area" id="primary">
						<div role="main" class="site-content" id="content">

							<div class="row">
								<div class="col-sm-12 text-center">
									<h2 class="block-header">Alta de Usuarios</h2>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="contact-form">
										<form class="contact-form" method="post" action="/">
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
												<select class="form-control" aria-required="true
													name="ltPerfil" id="ltPerfil">
												</select> 
											</p>
											<p class="contact-form-submit text-center vertical-margin-60">
												<input type="submit" value="Guardar" id="user_form_submit"
													name="contact_submit" class="theme_btn">
											</p>
										</form>
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



</div>
<!-- EOF #box_wrap -->