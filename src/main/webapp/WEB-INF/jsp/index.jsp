<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<img alt="logo" src='<c:url value="/resources/images/logo.png"/>'>
</div>

<div id="indexCarousel" class="carousel slide indexCarousel" data-ride="carousel" data-pause="hover">
	<ol class="carousel-indicators">
		<li data-target="#indexCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#indexCarousel" data-slide-to="1"></li>
		<li data-target="#indexCarousel" data-slide-to="2"></li>
	</ol>

	<div class="carousel-inner">
		<div class="item active">
			<img src='<c:url value="/resources/images/indexCarouselBackground.png"/>' alt="imageOne" class="indexCarouselImage">
			<div class="carousel-caption indexCarouselText">
		        <h2>Administra tus ligas en un solo sitio</h2>
		        <h4>Crea tantas ligas como necesites</h4>
			</div>
		</div>

		<div class="item">
			<img src='<c:url value="/resources/images/indexCarouselBackground.png"/>' alt="imageTwo" class="indexCarouselImage">
			<div class="carousel-caption indexCarouselText">
		        <h2>Escoge entre tres tipos de torneos</h2>
		        <h4>Puntos | Liguilla | Grupos</h4>
			</div>
		</div>

		<div class="item">
			<img src='<c:url value="/resources/images/indexCarouselBackground.png"/>' alt="imageThree" class="indexCarouselImage">
			<div class="carousel-caption indexCarouselText">
		        <h2>Actualiza los marcadores en tiempo real</h2>
		        <h4>Disfruta de los beneficios y olvídate de los procesos aburridos</h4>
			</div>
		</div>
	</div>

	<a class="left carousel-control" href="#indexCarousel" data-slide="prev">
		<img class="carouselControlImage" alt="Left" src='<c:url value="/resources/images/leftArrow.png"/>' >
	</a>
	<a class="right carousel-control" href="#indexCarousel" data-slide="next">
		<img class="carouselControlImage" alt="Right" src='<c:url value="/resources/images/rightArrow.png"/>' >
	</a>
</div>

<div class="banner jumbotron text-center">
	<h1>Bienvenido a "ALFUT"</h1>
	<h4>El sitio que te permite administrar tus ligas de fútbol</h4>
	<h4>Agradecemos tu preferencia</h4>
</div>

<div class="indexHeader">
	<h1>Nuestras ligas <small>(las más recientes)</small></h1>
</div>

<hr class="clusterScheduleDivider">

<c:choose>
	<c:when test="${empty(leagues)}">
		<div class="alert alert-info">
			<strong>Te estamos esperando.</strong> Comienza a crear tus ligas
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<c:forEach items="${leagues}" var="league">
				<div class="col-md-4 indexContainer">
					<h3 class="text-info indexSubHeader"><c:out value="${league.name}"/> <img src='<c:url value="/resources/images/ball.png"/>' alt="ball"></h3>
			 		<p><c:out value="${league.additionalInfo}"/></p>
			 		<a href='<spring:url value="/result-league.html?rpLeagueId=${league.id}" />' class="btn btn-success btn-sm">Ir a la liga</a>
			 	</div>
			</c:forEach>
		</div>
	</c:otherwise>
</c:choose>

<div class="indexHeader">
	<h1>Nuestros torneos <small>(los más recientes)</small></h1>
</div>

<hr class="clusterScheduleDivider">

<c:choose>
	<c:when test="${empty(tournaments)}">
		<div class="alert alert-info">
			<strong>Te estamos esperando.</strong> Comienza a crear tus torneos
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<c:forEach items="${tournaments}" var="tournament">
				<div class="col-md-4 indexContainer">
					<h3 class="text-info indexSubHeader"><c:out value="${tournament.name}"/> <img src='<c:url value="/resources/images/cup.png"/>' alt="cup"></h3>
			 		<h4 class="text-info">Liga: <strong><c:out value="${tournament.league.name}"/></strong></h4>
			 		<p><c:out value="${tournament.description}"/></p>
			 		<a href='<spring:url value="/result-tournament.html?rpTournamentId=${tournament.id}" />' class="btn btn-warning btn-sm">Ir al torneo</a>
			 	</div>
			</c:forEach>
		</div>
	</c:otherwise>
</c:choose>

<div class="indexHeader">
	<h1>Noticias del mundo <small>(las más recientes)</small></h1>
</div>

<hr class="clusterScheduleDivider">

<c:choose>
	<c:when test="${empty(news)}">
		<div class="alert alert-info">
			<strong>Sitio en construcción.</strong> En breve estará listo
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<c:forEach items="${news}" var="currentNew">
				<div class="col-md-4 indexContainer">
					<h3 class="text-info indexSubHeader"><c:out value="${currentNew.header}"/></h3>
					<p><c:out value="${currentNew.information}"/></p>
					<img alt="icon" src='<c:url value="${currentNew.url}"/>' class="openWorldNewIcon">
			 	</div>
			</c:forEach>
		</div>
	</c:otherwise>
</c:choose>

<div class="indexHeader">
	<h1>Galería de la semana <small></small></h1>
</div>

<hr class="clusterScheduleDivider">

<c:choose>
	<c:when test="${empty(galleries)}">
		<div class="alert alert-info">
			<strong>Sitio en construcción.</strong> En breve estará listo
		</div>
	</c:when>
	<c:otherwise>
		<div id="galleryCarousel" class="carousel slide galleryCarousel" data-ride="carousel" data-pause="hover">
			<ol class="carousel-indicators">
				<c:set var="activeCounter" scope="session" value="${0}"/>
				
				<c:forEach items="${galleries}" var="gallery">
					<c:choose>
						<c:when test="${activeCounter eq 0}">
							<li data-target="#galleryCarousel" data-slide-to="<c:out value="${activeCounter}" />" class="active"></li>
						</c:when>
						<c:otherwise>
							<li data-target="#galleryCarousel" data-slide-to="<c:out value="${activeCounter}" />"></li>
						</c:otherwise>
					</c:choose>
					
					<c:set var="activeCounter" scope="session" value="${activeCounter + 1}"/>
				</c:forEach>
			</ol>
		
			<div class="carousel-inner">
				<c:set var="activeCounter" scope="session" value="${0}"/>
				
				<c:forEach items="${galleries}" var="gallery">
					<c:choose>
						<c:when test="${activeCounter eq 0}">
							<div class="item active">
								<img src='<c:url value="${gallery.url}"/>' alt="galleryImage<c:out value="${activeCounter}" />" class="galleryCarouselImage">
							</div>
						</c:when>
						<c:otherwise>
							<div class="item">
								<img src='<c:url value="${gallery.url}"/>' alt="galleryImage<c:out value="${activeCounter}" />" class="galleryCarouselImage">
							</div>
						</c:otherwise>
					</c:choose>
					
					<c:set var="activeCounter" scope="session" value="${activeCounter + 1}"/>
				</c:forEach>
			</div>
			
			<a class="left carousel-control" href="#galleryCarousel" data-slide="prev">
				<img class="carouselControlImage" alt="Left" src='<c:url value="/resources/images/leftArrow.png"/>' >
			</a>
			<a class="right carousel-control" href="#galleryCarousel" data-slide="next">
				<img class="carouselControlImage" alt="Right" src='<c:url value="/resources/images/rightArrow.png"/>' >
			</a>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	$(document).ready(function() {
		$("#indexCarousel").carousel({
			interval : 3000
		});
		
		$("#galleryCarousel").carousel({
			interval : 3000
		});
	});
</script>