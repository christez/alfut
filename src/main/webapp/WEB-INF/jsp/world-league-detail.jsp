<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader"><c:out value="${league.name}" /></h1>

<hr />

<a href='<spring:url value="/world-league.html" />' class="btn btn-lg btn-info" data-toggle="modal">Volver a "Ligas"</a>
<a href="#myModal" class="btn btn-lg btn-primary" data-toggle="modal">Crear torneo</a>

<hr />

<form:form commandName="tournament" cssClass="form-horizontal tournamentForm">
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Crear torneo</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Nombre:</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" maxlength="50"/>
							<form:errors path="name"/>
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
	<c:when test="${empty(league.tournaments)}">
		<div class="alert alert-warning">
			<strong>No existe ningún torneo creado. Da click en el botón "Crear torneo" para iniciar</strong>
		</div>
		<div align="center">
			<img alt="warningIcon" src='<c:url value="/resources/images/warningIcon.png"/>'>
		</div>
	</c:when>
	<c:otherwise>
		<ul class="nav nav-tabs" role="tablist">
			<c:forEach items="${league.tournaments}" var="tournament">
				<li role="presentation"><a href="#tournament_<c:out value="${tournament.id}"/>" aria-controls="tournament_<c:out value="${tournament.id}"/>" role="tab" data-toggle="tab"><c:out value="${tournament.name}"/></a></li>
			</c:forEach>
		</ul>
		<div class="tab-content">
			<c:forEach items="${league.tournaments}" var="tournament">
				<div role="tabpanel" class="tab-pane" id="tournament_<c:out value="${tournament.id}"/>">
					<div class="row">
						<div class="col-md-12">
							<a href='<spring:url value="/world-league-tournament.html?rpTournamentId=${tournament.id}" />' class="btn btn-success worldLeagueTournamentButtonAdmin">Administrar torneo</a>
							<br />
							<a href='<spring:url value="/world-league-table.html?rpTournamentId=${tournament.id}" />' class="btn btn-warning worldLeagueTournamentButtonAdmin">Administrar tabla</a>
							<br />
							<a href='<spring:url value="/world-league-detail/remove/${tournament.id}.html" />' class="btn btn-danger btn-xs triggerRemove worldLeagueTournamentButtonRemove">Eliminar</a>
						</div>
					</div>
				</div>
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
				¿Seguro que deseas eliminar el torneo?
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
		$('.nav-tabs a:first').tab('show');
		
		$('.triggerRemove').click(function(e){
			e.preventDefault();
			
			$('#modalRemove .removeBtn').attr('href', $(this).attr('href'));
			
			$('#modalRemove').modal();;
		});
		
		$(".tournamentForm").validate(
				{
					rules: {
						name: {
							required: true,
							minlength: 1
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					},
					messages: {
						name: "El nombre debe tener al menos 1 caracterer"
					}
				}
		);
	});
</script>