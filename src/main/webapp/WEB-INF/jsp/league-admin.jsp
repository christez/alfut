<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Mis ligas</h1>

<hr />

<a href="#myModal" class="btn btn-lg btnAdministrationPrimary" data-toggle="modal">Crear liga</a>

<hr />

<form:form commandName="league" cssClass="form-horizontal leagueForm">
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Crear liga</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Nombre:</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" maxlength="50"/>
							<form:errors path="name"/>
						</div>
					</div>
					<div class="form-group">
						<label for="additionalInfo" class="col-sm-2 control-label">Información adicional:</label>
						<div class="col-sm-10">
							<form:textarea path="additionalInfo" cssClass="form-control" maxlength="200"/>
							<form:errors path="additionalInfo"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<input type="submit" class="btn btnAdministrationPrimary" value="Crear">
				</div>
			</div>
		</div>
	</div>
</form:form>

<c:if test="${success eq true}">
	<div class="alert alert-success alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Acción completada.</strong> <c:out value="${message}"/>
	</div>
</c:if>

<c:if test="${redirectedError eq true}">
	<div class="alert alert-danger alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Ocurrió un error.</strong> <c:out value="${message}"/>
	</div>
</c:if>

<c:choose>
	<c:when test="${empty(user.leagues)}">
		<div class="emptyDiv" align="center">
			<strong>No cuentas con ninguna liga creada.</strong><br />Da click en el botón "Crear liga" para iniciar
		</div>
	</c:when>
	<c:otherwise>
		<ul class="nav nav-tabs" role="tablist">
			<c:forEach items="${user.leagues}" var="league">
				<li role="presentation"><a href="#league_<c:out value="${league.id}"/>" aria-controls="league_<c:out value="${league.id}"/>" role="tab" data-toggle="tab"><c:out value="${league.name}"/></a></li>
			</c:forEach>
		</ul>
		<div class="tab-content">
			<c:forEach items="${user.leagues}" var="league">
				<div role="tabpanel" class="tab-pane" id="league_<c:out value="${league.id}"/>">
					<div class="row">
		  				<div class="col-md-4">
		  					<h3 class="leagueTabHeader">Liga: <span class="orangeColor"><c:out value="${league.name}"/></span></h3>
							<p class="leagueAdditionalInfo">Información adicional: <span class="orangeColor"><c:out value="${league.additionalInfo}"/></span></p>
							<p class="leagueCreationDate">Creada en: <span class="orangeColor"><fmt:formatDate value="${league.creationDate}" pattern="yyyy/MM/dd"/></span></p>
							
							<a href='<spring:url value="/tournament-admin.html?rpLeagueId=${league.id}" />' class="btn btn-sm btn-info" data-toggle="modal">Torneos</a>
		  					<a href='<spring:url value="/league-detail.html?rpLeagueId=${league.id}" />' class="btn btn-sm btn-success" data-toggle="modal">Modificar</a>
		           			<a href='<spring:url value="/league-admin/remove/${league.id}.html" />' class="btn btn-danger btn-sm triggerRemove">Eliminar</a>
		  				</div>
		  				<div class="col-md-8" id="leagueMapContainer<c:out value="${league.id}"/>">
		  					<h3 class="leagueTabHeader">Ubicación</h3>
		    				<div id="map<c:out value="${league.id}"/>" class="leagueLocation"></div>
		  				</div>
		  			</div>
				</div>
			</c:forEach>
		</div>
		
		<br />
		<br />
	</c:otherwise>
</c:choose>

<div id="modalRemove" class="modal fade modalRemove">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Confirmar acción</h4>
			</div>
			<div class="modal-body">
				¿Seguro que deseas eliminar la liga?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<a href="" class="btn btn-danger removeBtn">Eliminar</a>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function initMaps() {
		<c:forEach items="${user.leagues}" var="league">
			var uluru<c:out value="${league.id}"/> = {lat: <c:out value="${league.lattitud}"/>, lng: <c:out value="${league.longitud}"/>};
	        var map<c:out value="${league.id}"/> = new google.maps.Map(document.getElementById('map<c:out value="${league.id}"/>'), {
	        	zoom: 15,
	          	center: uluru<c:out value="${league.id}"/>
	        });
	        
	        var marker<c:out value="${league.id}"/> = new google.maps.Marker({
	          	position: uluru<c:out value="${league.id}"/>,
	          	map: map<c:out value="${league.id}"/>
	        });
	    </c:forEach>
	}
	
	$(document).ready(function() {
		$('.nav-tabs a:first').tab('show');
		
		$('.triggerRemove').click(function(e){
			e.preventDefault();
			
			$('#modalRemove .removeBtn').attr('href', $(this).attr('href'));
			
			$('#modalRemove').modal();;
		});
		
		$(".leagueForm").validate(
				{
					rules: {
						name: {
							required: true,
							minlength: 1
						},
						additionalInfo: {
							required: true,
							minlength: 1,
							maxlength: 200
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					},
					messages: {
						name: "El nombre de la liga debe tener al menos 1 caracterer",
						additionalInfo: "El nombre de la liga debe tener al menos 1 caracterer y máximo 200"
					}
				}
		);
		
		$('.nav-tabs').on('shown.bs.tab', function () {
			google.maps.event.trigger(window, 'resize', {});
	    });
	});
</script>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA9-hiJxZ0A1b1HiIa3Ltln1M1FlwQW36c&callback=initMaps"></script>