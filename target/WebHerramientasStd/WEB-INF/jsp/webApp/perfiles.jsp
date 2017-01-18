<script
	src="${pageContext.request.contextPath}/resources/js/perfiles.js"
	type="text/javascript"></script>
<div id="box_wrap">

	<section id="abovecontent" class="grey_section">
		<div class="container">
			<div class="row">
				<div class="block col-sm-12">
					<ul class="breadcrumb">
						<li><a href="#" class="pathway">Home</a></li>
						<li><span>Perfiles</span></li>
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
						<a href="#" onclick="mostrarPanelAlta();return false;" class="list-group-item">Alta de Perfiles</a> 
						<a href="#" onclick="mostrarPanelAdmin();return false;" class="list-group-item">Administración</a> 
						<a href="#" class="list-group-item">Borrar</a>
					</div>

				</aside>

				<div class="col-sm-9">
					<div class="text-center"></div>
					<div class="content-area" id="primary">
						<div role="main" class="site-content" id="content">


							<div id="panel-perfiles-alta">
								<div class="row">
									<div class="col-sm-12 text-center">
										<h2 class="block-header">Alta de Perfiles</h2>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12"></div>
								</div>
							</div>

							<div id="panel-perfiles-admin" style="display: none;">
								<div class="row">
									<div class="col-sm-12 text-center">
										<h2 class="block-header">Administración de Perfiles</h2>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12"></div>
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