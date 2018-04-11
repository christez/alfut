<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Torneos de la liga <span class="orangeColor"><c:out value="${league.name}"/></span></h1>

<hr />

<a href='<spring:url value="/league-admin.html" />' class="btn btn-lg btn-info" data-toggle="modal">Volver a "Ligas"</a>
<a href="#myModal" class="btn btn-lg btnAdministrationPrimary" data-toggle="modal">Crear torneo</a>

<hr />

<form:form commandName="tournament" cssClass="form-horizontal tournamentForm">
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Nuevo torneo</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">Nombre:</label>
						<div class="col-sm-9">
							<form:input path="name" cssClass="form-control" maxlength="50" />
							<form:errors path="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-3 control-label">Descripción:</label>
						<div class="col-sm-9">
							<form:textarea path="description" cssClass="form-control" maxlength="250" />
							<form:errors path="description" />
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label">Tipo de torneo:</label>
						<div class="col-sm-9">
							<form:select path="type" cssClass="form-control">
								<form:option value="0" label="Opciones" />
								<form:options items="${type}" />
							</form:select>
							<form:errors path="type" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<input type="submit" class="btn btn-success btnAdministrationPrimary" value="Crear">
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
	<div class="alert alert-success alert-dismissable">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
	    <strong>Ocurrió un error.</strong> <c:out value="${message}"/>
	</div>
</c:if>

<c:choose>
	<c:when test="${empty(league.tournaments)}">
		<div class="emptyDiv" align="center">
			<strong>No cuentas con ningún torneo creado.</strong><br />Da click en el botón "Crear torneo" para iniciar
		</div>
	</c:when>
	<c:otherwise>
		<div class="container">
			<c:forEach items="${league.tournaments}" var="tournament">
				<div class="col-md-2 tournamentContainer">
					<div class="tournamentContainerHeader"><c:out value="${tournament.name}"/></div>
					<div class="tournamentContainerBody">
						<img src='<spring:url value="/resources/images/tournamentBackground.png" />' alt="TournamentImage" class="tournamentImage">
						<div class="textbox">
							<a class="btn btn-xs btn-info headerDetail tournamentInnerButton" data-toggle="popover" data-placement="bottom" data-html="true" title="Detalles del torneo" data-content='
								<p class="tournamentDescriptionHeaderDetail">Descripción: <strong><span class="orangeColor"><c:out value="${tournament.description}"/></span></strong></p>
								<p class="tournamentDescriptionHeaderDetail">Tipo: <strong><span class="orangeColor"><c:out value="${tournament.type}"/></span></strong></p>
								<p class="tournamentDescriptionHeaderDetail">Creado: <strong><span class="orangeColor"><fmt:formatDate value="${tournament.creationDate}" pattern="yyyy/MM/dd"/></span></strong></p>
								<p class="tournamentDescriptionHeaderDetail">Estatus: <strong><span class="orangeColor"><c:out value="${tournament.status}"/></span></strong></p>
								<c:if test="${tournament.status eq 'Finalizado'}"><p class="tournamentDescriptionHeaderDetail">Campeón: <strong><span class="orangeColor"><c:out value="${tournament.winner}"/></span></strong></p></c:if>'>
								Detalles</a>
							<br />
							<a href='<spring:url value="/tournament-detail.html?rpTournamentId=${tournament.id}" />' class="btn btn-xs btn-warning tournamentInnerButton">Modificar</a>
							<br />
							<c:choose>
								<c:when test="${tournament.type eq 'Por grupos más liguilla'}">
									<a href='<spring:url value="/cluster-admin.html?rpTournamentId=${tournament.id}" />' class="btn btn-xs btn-primary tournamentInnerButton">Grupos</a>
								</c:when>
								<c:otherwise>
									<a href='<spring:url value="/team-admin.html?rpTournamentId=${tournament.id}" />' class="btn btn-xs btn-primary tournamentInnerButton">Equipos</a>
								</c:otherwise>
							</c:choose>
							<br />
							<a href='<spring:url value="/schedule-admin.html?rpTournamentId=${tournament.id}" />' class="btn btn-xs btn-success tournamentInnerButton">Jornadas</a>
							<br />
							<a href='<spring:url value="/tournament-admin/remove/${tournament.id}.html" />' class="btn btn-danger btn-xs triggerRemove tournamentInnerButton">Eliminar</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		
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
						},
						description: {
							required: true,
							minlength: 1
						},
						type: {
							validSelect: true
						}
					},
					highlight: function(element){
						$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
					},
					unhighlight: function(element){
						$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
					},
					messages: {
						name: "El nombre debe tener al menos 1 caracterer",
						description: "La descripción debe tener al menos 1 caracterer"
					}
				}
		);
		
		jQuery.validator.addMethod('validSelect', function (value) {
			return (value != '0');
	    }, "Opción invalida");
	});
	
	$('[data-toggle="popover"]').popover(); 
</script>