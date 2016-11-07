<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="${pageContext.request.contextPath}/resources/css/encabezado.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/encabezado.js"
	type="text/javascript"></script>

<section id="header">
	<div class="container">
		<div class="row">

			<a class="navbar-brand" href="#home.htm"><img
				src="${pageContext.request.contextPath}/resources/img/icono.png"
				alt="" style="width: 60px; height: 60px;">Herramientas</a>

			<div class="col-sm-12 mainmenu_wrap">
				<div class="main-menu-icon visible-xs">
					<span></span><span></span><span></span>
				</div>
				<ul id="mainmenu" class="nav menu sf-menu responsive-menu superfish">

					<c:forEach items="${usuario.perfil.listaMenus}" var="current">

						<li class="dropdown"><a href="#">${current.nombre}</a>
							<ul class="nav dropdown-menu">
								<c:forEach items="${current.listaOpciones}" var="currentOpt">
									<li class=""><a href="${currentOpt.controller}">${currentOpt.opcion}</a></li>
								</c:forEach>
							</ul></li>
					</c:forEach>

					<li class="dropdown"><a id="aNonbreUsuario" href="#"><i
							class="fa fa-user" aria-hidden="true"></i>&nbsp;${nombre}</a>
						<ul class="nav dropdown-menu">
							<li class=""><a href="cerrarSesion.htm"><i
									class="fa fa-sign-out" aria-hidden="true"></i> Salir</a></li>
						</ul></li>

				</ul>
			</div>

		</div>
	</div>
</section>