<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Ligas del mundo</h1>

<hr />

<a href="#myModal" class="btn btn-lg btn-primary" data-toggle="modal">Crear liga</a>

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
						<label for="flagUrl" class="col-sm-2 control-label">Url de bandera:</label>
						<div class="col-sm-10">
							<form:input path="flagUrl" cssClass="form-control" maxlength="250"/>
							<form:errors path="flagUrl"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<input type="submit" class="btn btn-primary" value="Crear">
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
	<c:when test="${empty(leagues)}">
		<div class="alert alert-warning">
			<strong>No existe ninguna liga creada. Da click en el botón "Crear liga" para iniciar</strong>
		</div>
		<div align="center">
			<img alt="warningIcon" src='<c:url value="/resources/images/warningIcon.png"/>'>
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<c:set var="colorCounter" scope="session" value="${0}"/>
			
			<c:forEach items="${leagues}" var="league">
				<div class="col-sm-4">
					<c:if test="${colorCounter % 5 == 0}">
						<a href='<spring:url value="/world-league-detail.html?rpLeagueId=${league.id}" />' class="btn btn-lg btn-info worldLeagueButton" data-toggle="modal"><c:out value="${league.name}" /></a>
					</c:if>
					
					<c:if test="${colorCounter % 5 == 1}">
						<a href='<spring:url value="/world-league-detail.html?rpLeagueId=${league.id}" />' class="btn btn-lg btn-success worldLeagueButton" data-toggle="modal"><c:out value="${league.name}" /></a>
					</c:if>
					
					<c:if test="${colorCounter % 5 == 2}">
						<a href='<spring:url value="/world-league-detail.html?rpLeagueId=${league.id}" />' class="btn btn-lg btn-warning worldLeagueButton" data-toggle="modal"><c:out value="${league.name}" /></a>
					</c:if>
					
					<c:if test="${colorCounter % 5 == 3}">
						<a href='<spring:url value="/world-league-detail.html?rpLeagueId=${league.id}" />' class="btn btn-lg btn-danger worldLeagueButton" data-toggle="modal"><c:out value="${league.name}" /></a>
					</c:if>
					
					<c:if test="${colorCounter % 5 == 4}">
						<a href='<spring:url value="/world-league-detail.html?rpLeagueId=${league.id}" />' class="btn btn-lg btn-default worldLeagueButton" data-toggle="modal"><c:out value="${league.name}" /></a>
					</c:if>
					
					<a href='<spring:url value="/world-league/remove/${league.id}.html" />' class="btn btn-danger btn-xs triggerRemove worldLeagueButtonRemove">Eliminar</a>
				</div>
				
				<c:set var="colorCounter" scope="session" value="${colorCounter + 1}"/>
			</c:forEach>
		</div>
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
	$(document).ready(function() {
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
						flagUrl: {
							required: true,
							url: true
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
						flagUrl: {
							required: "Campo requerido",
							url: "Formato URL"
						}
					}
				}
		);
	});
</script>