<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<img class="mainLogo" alt="mainLogo" src='<c:url value="/resources/images/main-logo.png"/>'>
</div>

<div align="center">
	<div id="indexCarousel" class="carousel slide carousel-fade indexCarousel" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#indexCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#indexCarousel" data-slide-to="1"></li>
			<li data-target="#indexCarousel" data-slide-to="2"></li>
		</ol>
	
		<div class="carousel-inner">
			<div class="item active">
				<img src='<c:url value="/resources/images/b-01.png"/>' alt="imageOne" class="indexCarouselImage">
				<div class="carousel-caption indexCarouselText">
			        <h2>Administra tus ligas en un solo sitio</h2>
			        <h4>Crea tantas ligas como necesites</h4>
				</div>
			</div>
	
			<div class="item">
				<img src='<c:url value="/resources/images/b-02.png"/>' alt="imageTwo" class="indexCarouselImage">
				<div class="carousel-caption indexCarouselText">
			        <h2>Escoge entre cuatro tipos de torneos</h2>
			        <h4>Puntos | Liguilla | Grupos | Copa</h4>
				</div>
			</div>
	
			<div class="item">
				<img src='<c:url value="/resources/images/b-03.png"/>' alt="imageThree" class="indexCarouselImage">
				<div class="carousel-caption indexCarouselText">
			        <h2>Actualiza los marcadores en tiempo real</h2>
			        <h4>Disfruta de los beneficios y olvídate de los procesos aburridos</h4>
				</div>
			</div>
		</div>
	</div>
</div>

<div align="center">
	<div class="indexCarouselFooter">
		<br />
		<br />
		<p>ADMINISTRADOR DE LIGAS DE FUTBOL</p>
	</div>
</div>

<div align="center">
	<div class=indexInformationContainer>
		<div align="left">
			<p class="indexHeader">NUESTRAS LIGAS MÁS RECIENTES</p>
		</div>
		
		<c:choose>
			<c:when test="${empty(leagues)}">
				<div class="emptyDiv" align="center">
					<strong>Te estamos esperando</strong><br />Comienza a crear tus ligas
				</div>
			</c:when>
			<c:otherwise>
				<div class="row">
					<c:forEach items="${leagues}" var="league">
						<div class="col-md-4 indexContainer">
							<p class="indexSubHeader"><c:out value="${league.name}"/></p>
							<img src='<c:url value="/resources/images/ball.png"/>' alt="ball">
							<p class="indexAdditionalInfo"><c:out value="${league.additionalInfo}"/></p>
					 		<a href='<spring:url value="/result-league.html?rpLeagueId=${league.id}" />' class="btn btn-success btnRedirect">Ir a la liga</a>
					 	</div>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>
		
		<div align="left">
			<p class="indexHeader">NUESTROS TORNEOS MÁS RECIENTES</p>
		</div>
		
		<c:choose>
			<c:when test="${empty(tournaments)}">
				<div class="emptyDiv" align="center">
					<strong>Te estamos esperando.</strong><br />Comienza a crear tus torneos
				</div>
			</c:when>
			<c:otherwise>
				<div class="row">
					<c:forEach items="${tournaments}" var="tournament">
						<div class="col-md-4 indexContainer">
							<p class="indexSubHeader"><c:out value="${tournament.name}"/></p>
							<img src='<c:url value="/resources/images/cup.png"/>' alt="cup">
							<p class="indexDescription">Liga: <strong><c:out value="${tournament.league.name}"/></strong></p>
							<p class="indexAdditionalInfo"><c:out value="${tournament.description}"/></p>
					 		<a href='<spring:url value="/result-tournament.html?rpTournamentId=${tournament.id}" />' class="btn btn-success btnRedirect">Ir al torneo</a>
					 	</div>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<div align="center" class="bannerContainer">
	<img alt="banner" src='<c:url value="/resources/images/banner.png"/>' style="width: 100%;">
	<div class="bannerTextCentered">El sitio que te permite administrar tus ligas de fútbol<br />Agradecemos tu preferencia</div>
</div>

<div align="center">
	<div class=indexInformationContainer>
		<p class="indexHeaderGallery">GALERÍA DE LA SEMANA</p>
	
	
		<c:choose>
			<c:when test="${empty(galleries)}">
				<div class="emptyDiv" align="center">
					<strong>Sitio en construcción.</strong><br />En breve estará listo
				</div>
			</c:when>
			<c:otherwise>
				<div id="galleryCarousel" class="carousel slide carousel-fade galleryCarousel" data-ride="carousel" data-pause="hover">
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
				
				<br />
				<br />
				<br />
				<br />
			</c:otherwise>
		</c:choose>
	</div>
</div>

<div align="center">
	<div class=indexNewsContainer>
		<p class="indexNewsHeader">NOTICIAS RECIENTES</p>
		
		<c:choose>
			<c:when test="${empty(news)}">
				<div class="emptyDiv" align="center">
					<strong>Sitio en construcción.</strong>
					<p style="color: #ffffff;">En breve estará listo</p>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row">
					<c:forEach items="${news}" var="currentNew">
						<div class="col-md-4 indexContainer">
							<img alt="icon" src='<c:url value="${currentNew.url}"/>' class="openWorldNewIcon">
							<h3 class="text-info indexSubHeader"><c:out value="${currentNew.header}"/></h3>
							<div align="justify">
								<p class="indexNewsInformation"><c:out value="${currentNew.information}"/></p>
							</div>
					 	</div>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$("#indexCarousel").carousel({
			interval : 5000
		});
		
		$("#galleryCarousel").carousel({
			interval : 5000
		});
	});
</script>