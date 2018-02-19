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
		<img alt="Left" src='<c:url value="/resources/images/leftArrow.png"/>' >
	</a>
	<a class="right carousel-control" href="#indexCarousel" data-slide="next">
		<img alt="Right" src='<c:url value="/resources/images/rightArrow.png"/>' >
	</a>
</div>

<div class="banner jumbotron text-center">
	<h1>Bienvenido a "ALF"</h1>
	<h4>El sitio que te permite administrar tus ligas de fútbol</h4>
	<h4>Agradecemos tu preferencia</h4>
</div>

<div class="indexHeader page-header">
	<h1>Nuestras ligas <small>(las más recientes)</small></h1>
</div>

<c:choose>
	<c:when test="${empty(leagues)}">
		<div class="alert alert-info">
			<strong>Te estamos esperando.</strong> Comienza a crear tus ligas
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<c:forEach items="${leagues}" var="league">
				<div class="col-md-3 indexContainer">
					<h3 class="text-info"><c:out value="${league.name}"/> <img src='<c:url value="/resources/images/ball.png"/>' alt="ball"></h3>
			 		<a href='<spring:url value="/result-league.html?rpLeagueId=${league.id}" />' class="btn btn-link btn-sm">Ir a la liga</a>
			 		<p><c:out value="${league.additionalInfo}"/></p>			 		
			 	</div>
			</c:forEach>
		</div>
	</c:otherwise>
</c:choose>

<div class="indexHeader page-header">
	<h1>Nuestros torneos <small>(los más recientes)</small></h1>
</div>

<c:choose>
	<c:when test="${empty(tournaments)}">
		<div class="alert alert-info">
			<strong>Te estamos esperando.</strong> Comienza a crear tus torneos
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<c:forEach items="${tournaments}" var="tournament">
				<div class="col-md-3 indexContainer">
					<h3 class="text-info"><c:out value="${tournament.name}"/> <img src='<c:url value="/resources/images/cup.png"/>' alt="cup"></h3>
			 		<h5 class="text-info">Liga: <strong><c:out value="${tournament.league.name}"/></strong></h5>
			 		<a href='<spring:url value="/result-tournament.html?rpTournamentId=${tournament.id}" />' class="btn btn-link btn-sm">Ir al torneo</a>
			 		<p><c:out value="${tournament.description}"/></p>			 		
			 	</div>
			</c:forEach>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	$(document).ready(function() {
		$("#indexCarousel").carousel({
			interval : 3000
		});
	});
</script>