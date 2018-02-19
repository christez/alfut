<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<div align="center">
	<img src='<c:url value="/resources/images/resultLeague.png"/>' alt="League">
</div>

<p class="resultLeagueHeader"><c:out value="${league.name}" /> | <c:out value="${league.user.username}" /></p>
<p class="resultLeagueInformation"><c:out value="${league.additionalInfo}" /></p>
<p class="resultLeagueDate"><fmt:formatDate value="${league.creationDate}" pattern="yyyy/MM/dd"/></p>
<a href="#modalLocation" class="btn btn-sm btn-info" data-toggle="modal">Ubicación</a>

<div id="modalLocation" class="modal fade modalLeague">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
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

<hr />

<p class="resultLeagueSmallHeader">Torneos</p>

<c:choose>
	<c:when test="${empty(league.tournaments)}">
		<div class="alert alert-info">
			<strong>Lo sentimos.</strong> No hay torneos recientes
		</div>
		<div align="center">
			<img alt="sadFace" src='<c:url value="/resources/images/sadFace.png"/>'>
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach items="${league.tournaments}" var="tournament">
			<div class="row openLeagueContainer">
				<div class="col-md-3"></div>
				<div class="col-md-4">
					<p class="openLeagueHeader"><c:out value="${tournament.name}"/></p>
					<p class="openLeagueInfo"><c:out value="${tournament.description}"/></p>
					<a href='<spring:url value="/result-tournament.html?rpTournamentId=${tournament.id}" />' class="btn btn-success btn-sm">Ir la torneo</a>
			 	</div>
			 	<div class="col-md-3 openLeagueDetail">
			 		<p>Estatus: <strong><c:out value="${tournament.status}"/></strong></p>
			 		<p>Tipo: <strong><c:out value="${tournament.type}"/></strong></p>
			 		<p>Fecha de creación: <strong><fmt:formatDate value="${tournament.creationDate}" pattern="yyyy/MM/dd"/></strong></p>	 
			 	</div>
			 	<div class="col-md-1"></div>
		 	</div>
		</c:forEach>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	function initMaps() {
		var uluru = {lat: <c:out value="${league.lattitud}"/>, lng: <c:out value="${league.longitud}"/>};
        var map = new google.maps.Map(document.getElementById('map'), {
        	zoom: 15,
          	center: uluru
        });
        
        var marker = new google.maps.Marker({
          	position: uluru,
          	map: map
        });
	}
	
	$(document).ready(function() {
		$('#modalLocation').on('shown.bs.modal', function(){
			google.maps.event.trigger(map, "resize");
		});
	});
</script>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA9-hiJxZ0A1b1HiIa3Ltln1M1FlwQW36c&callback=initMaps"></script>