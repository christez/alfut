<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<h1 class="mainHeader">LIGA</h1>
</div>

<p class="resultLeagueHeader">
	<c:out value="${league.name}" /> | <c:out value="${league.user.username}" />
</p>
<p class="resultLeagueInformation">
	Información adicional: <c:out value="${league.additionalInfo}" />
</p>
<p class="resultLeagueDate">
	Fecha de creación: <fmt:formatDate value="${league.creationDate}" pattern="yyyy/MM/dd" />
</p>
<a href="#modalLocation" class="generalLink" data-toggle="modal">Ubicación <img src='<c:url value="/resources/images/map.png"/>' alt="map"></a>

<div id="modalLocation" class="modal fade modalLeague">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Ubicación de la liga</h4>
			</div>
			<div class="modal-body">
				<div id="map" class="leagueLocation"></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			</div>
		</div>
	</div>
</div>

<div align="center">
	<h1 class="resultLeagueSmallHeader">TORNEOS</h1>
</div>

<c:choose>
	<c:when test="${empty(league.tournaments)}">
		<div class="emptyDiv" align="center">
			<strong>Lo sentimos.</strong><br />No hay torneos recientes
		</div>
	</c:when>
	<c:otherwise>
		<div class="row newsTabContainer">
			<c:set var="tabCounter" scope="session" value="${1}"/>
		
			<div class="tabNews">
				<c:forEach items="${league.tournaments}" var="tournament">
					<c:choose>
						<c:when test="${tabCounter eq 1}">
							<button class="tablink" onmouseover="openTournamentTab('<c:out value="${tabCounter}" />_<c:out value="${tournament.name}" />', this, '#F15A24')" id="defaultOpen">
								<c:if test="${tournament.type eq 'Por grupos más liguilla'}">
						 			<img src='<c:url value="/resources/images/tournamentGroups.png"/>' class="img-rounded newsImageSmall" alt="Groups">
						 		</c:if>
						 		
						 		<c:if test="${tournament.type eq 'Por liguilla'}">
						 			<img src='<c:url value="/resources/images/tournamentPlayoffs.png"/>' class="img-rounded newsImageSmall" alt="Playoffs">
						 		</c:if>
						 		
						 		<c:if test="${tournament.type eq 'Por puntos'}">
						 			<img src='<c:url value="/resources/images/tournamentPoints.png"/>' class="img-rounded newsImageSmall" alt="Points">
						 		</c:if>
						 		
						 		<c:if test="${tournament.type eq 'Por puntos más liguilla'}">
						 			<img src='<c:url value="/resources/images/tournamentPointsPlayoffs.png"/>' class="img-rounded newsImageSmall" alt="PointsPlayoffs">
						 		</c:if>
						 		
						 		<c:out value="${tournament.name}" />
							</button>
						</c:when>
						<c:otherwise>
							<button class="tablink" onmouseover="openTournamentTab('<c:out value="${tabCounter}" />_<c:out value="${tournament.name}" />', this, '#F15A24')">
								<c:if test="${tournament.type eq 'Por grupos más liguilla'}">
						 			<img src='<c:url value="/resources/images/tournamentGroups.png"/>' class="img-rounded newsImageSmall" alt="Groups">
						 		</c:if>
						 		
						 		<c:if test="${tournament.type eq 'Por liguilla'}">
						 			<img src='<c:url value="/resources/images/tournamentPlayoffs.png"/>' class="img-rounded newsImageSmall" alt="Playoffs">
						 		</c:if>
						 		
						 		<c:if test="${tournament.type eq 'Por puntos'}">
						 			<img src='<c:url value="/resources/images/tournamentPoints.png"/>' class="img-rounded newsImageSmall" alt="Points">
						 		</c:if>
						 		
						 		<c:if test="${tournament.type eq 'Por puntos más liguilla'}">
						 			<img src='<c:url value="/resources/images/tournamentPointsPlayoffs.png"/>' class="img-rounded newsImageSmall" alt="PointsPlayoffs">
						 		</c:if>
						 		
						 		<c:out value="${tournament.name}" />
							</button>
						</c:otherwise>
					</c:choose>
					
					<c:set var="tabCounter" scope="session" value="${tabCounter + 1}"/>
				</c:forEach>
			</div>
			
			<c:set var="tabCounter" scope="session" value="${1}"/>
			
			<c:forEach items="${league.tournaments}" var="tournament">
				<div id='<c:out value="${tabCounter}" />_<c:out value="${tournament.name}" />' class="tabContentNews">
					<div class="row">
						<div class="col-md-5" align="center">
							<c:if test="${tournament.type eq 'Por grupos más liguilla'}">
					 			<img src='<c:url value="/resources/images/tournamentGroups.png"/>' class="img-rounded newsImage" alt="Groups">
					 		</c:if>
					 		
					 		<c:if test="${tournament.type eq 'Por liguilla'}">
					 			<img src='<c:url value="/resources/images/tournamentPlayoffs.png"/>' class="img-rounded newsImage" alt="Playoffs">
					 		</c:if>
					 		
					 		<c:if test="${tournament.type eq 'Por puntos'}">
					 			<img src='<c:url value="/resources/images/tournamentPoints.png"/>' class="img-rounded newsImage" alt="Points">
					 		</c:if>
					 		
					 		<c:if test="${tournament.type eq 'Por puntos más liguilla'}">
					 			<img src='<c:url value="/resources/images/tournamentPointsPlayoffs.png"/>' class="img-rounded newsImage" alt="PointsPlayoffs">
					 		</c:if>
						</div>
						<div class="col-md-7">
							<p class="openLeagueHeader"><c:out value="${tournament.name}" /></p>
							<p class="openLeagueInfo"><c:out value="${tournament.description}" /></p>
							<p class="openLeagueDetailHeader">Estatus: <strong class="openLeagueDetailOrange"><c:out value="${tournament.status}" /></strong></p>
							<p class="openLeagueDetailHeader">Tipo: <strong class="openLeagueDetailOrange"><c:out value="${tournament.type}" /></strong></p>
							<p class="openLeagueDetailHeader">Fecha de creación: <strong class="openLeagueDetailOrange"><fmt:formatDate value="${tournament.creationDate}" pattern="yyyy/MM/dd" /></strong></p>
							<br />
							<a href='<spring:url value="/result-tournament.html?rpTournamentId=${tournament.id}" />' class="btn btn-success btnRedirect">Ir la torneo</a>
						</div>
					</div>
				</div>
				
				<c:set var="tabCounter" scope="session" value="${tabCounter + 1}"/>
			</c:forEach>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	function initMaps() {
		var uluru = {
			lat : <c:out value="${league.lattitud}"/>,
			lng : <c:out value="${league.longitud}"/>
		};
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 15,
			center : uluru
		});

		var marker = new google.maps.Marker({
			position : uluru,
			map : map
		});
	}

	$(document).ready(function() {
		$('#modalLocation').on('shown.bs.modal', function() {
			google.maps.event.trigger(map, "resize");
		});
	});
	
	function openTournamentTab(tournamentName, element, color) {
	    var i, tabcontent, tablinks;
	    tabcontent = document.getElementsByClassName("tabContentNews");
	    
	    for (i = 0; i < tabcontent.length; i++) {
	        tabcontent[i].style.display = "none";
	    }
	    
	    tablinks = document.getElementsByClassName("tablink");
	    
	    for (i = 0; i < tablinks.length; i++) {
	        tablinks[i].style.backgroundColor = "";
	    }
	    
	    document.getElementById(tournamentName).style.display = "block";
	    element.style.backgroundColor = color;
	}
	
	document.getElementById("defaultOpen").onmouseover();
</script>

<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA9-hiJxZ0A1b1HiIa3Ltln1M1FlwQW36c&callback=initMaps"></script>