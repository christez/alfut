<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<h1 class="mainHeader">Torneo "<c:out value="${tournament.name}" />"</h1>

<hr />

<a href='<spring:url value="/world-league-detail.html" />' class="btn btn-lg btn-info" data-toggle="modal">Volver a "Torneo"</a>
<a href="#myModal" class="btn btn-lg btn-primary" data-toggle="modal">Crear jornada</a>

<hr />

<form:form commandName="schedule" cssClass="form-horizontal scheduleForm">
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Crear jornada</h4>
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
						<label for="textForMatches" class="col-sm-2 control-label">Partidos:</label>
						<div class="col-sm-10">
							<form:textarea path="textForMatches" cssClass="form-control" maxlength="1024"/>
							<form:errors path="textForMatches"/>
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
	<c:when test="${empty(tournament.schedules)}">
		<div class="alert alert-warning">
			<strong>No existe ninguna jornada creada. Da click en el botón "Crear jornada" para iniciar</strong>
		</div>
		<div align="center">
			<img alt="warningIcon" src='<c:url value="/resources/images/warningIcon.png"/>'>
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach items="${tournament.schedules}" var="schedule">
			<h3 class="worldScheduleHeader"><c:out value="${schedule.name}" /></h3>
			<a href='<spring:url value="/world-league-tournament/remove/${schedule.id}.html" />' class="btn btn-danger btn-xs triggerRemove worldMatchButtonRemove">Eliminar</a>
			
			<div class="table-responsive">
				<table class="table table-bordered table-xs table-condensed teamTable">
					<thead class="teamTableHeader">
						<tr>
							<th>Fecha</th>
							<th>Hora</th>
							<th>Local</th>
							<th>Visitante</th>
							<th>Resultado</th>
							<th>Modificar</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${schedule.matches}" var="match">
							<tr class="teamTableHover">
								<td>
									<c:out value="${match.date}" />
								</td>
								<td>
									<c:out value="${match.time}" />
								</td>
								<td>
									<c:out value="${match.localName}" />
								</td>
								<td>
									<c:out value="${match.visitorName}" />
								</td>
								<td>
									<c:out value="${match.result}" />
								</td>
								<td>
									<a href='<spring:url value="/world-league-tournament-detail.html?rpMatchId=${match.id}" />' class="btn btn-info btn-xs">Modificar</a>
								</td>
								<td>
									<a href='<spring:url value="/world-league-tournament/remove/match/${match.id}.html" />' class="btn btn-danger btn-xs triggerRemove">Eliminar</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
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
				¿Seguro que deseas eliminar el registro?
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
			
			$('#modalRemove').modal();
		});
		
		$(".scheduleForm").validate({
				rules: {
					name: {
						required: true,
						minlength: 1
					},
					textForMatches: {
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
					name: "El nombre debe tener al menos 1 caracterer",
					textForMatches: "Los partidos deben tener al menos un caracter"
				}
			}
		);
	});
</script>